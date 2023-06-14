package Aigo.Reverse.String;

import java.util.Stack;

/**
 * @Description https://leetcode.cn/problems/reverse-words-in-a-string
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * 输入：s = " hello world "
 * 输出："world hello"
 * 解释：反转后的字符串中不能存在前导空格和尾随空格。
 * 输入：s = "a good  example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
 * 1 <= s.length <= 104
 * s 包含英文大小写字母、数字和空格 ' '
 * s 中 至少存在一个 单词
 * @Author Administrator
 * @Date 2023/6/2 12:37
 * @Version 1.0.0
 */
public class ReverteWordsV1 extends ReverteWordsSuper{
    /**
     * 清除字符串前后出现的空格，将清除空格后的字符串根据每个字符串间的空格进行拆分并放入stack中，重组stack中的字符串并返回
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        //如果字符串的长度是1，直接返回
        if(s.length() == 1){
            return s;
        }
        //先删除整个字符串前面后面的空格
        s = deleteSpaceBeforeAndAfterAlpha(s);
        Stack<String>stack = new Stack<>();
        //把给定字符串整理成每个字符串子串并放入stack
        stack = handleStringToStack(s,stack);
        //重新生成结果字符串
        String result = rebuildFromStack(stack);
        return result;
    }
    /**
     * 重组字符串
     * @param stack
     * @return
     */
    private String rebuildFromStack(Stack<String> stack) {
        StringBuilder builder = new StringBuilder();
        while (!stack.empty()){
            builder.append(stack.pop());
        }
        String result = builder.toString();
        return result;
    }

    /**
     * 将字符串做处理之后放入栈中
     * @param s
     * @param stack
     * @return
     */
    private Stack<String> handleStringToStack(String s, Stack<String> stack) {
        //用于记录字符串中每个单词中的空格
        int count = 0;
        //用于记录字符串中的每个单词，
        String word = "";
        //将上面记录的word存在stack中
        StringBuilder builder = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) != ' '){
                if(count != 0){
                    stack.push(" ");
                    count = 0;
                }
                builder.append(String.valueOf(s.charAt(i)));
            }else{
                if(count == 0){
                    word = builder.toString();
                    builder.setLength(0);
                    stack.push(word);
                    word = "";
                }
                count++;
            }
        }
        if(builder.length() != 0){
            word = builder.toString();
            stack.push(word);
        }
        return stack;
    }
    /**
     * 删除字符串第一个字母或数字前的空格和最后一个字母或数字后的空格
     * @param s
     * @return
     */
    private String deleteSpaceBeforeAndAfterAlpha(String s) {
        int start = 0;
        int end = 0;
        String regex = "[A-Za-z0-9]";
        for(int i = 0 ; i < s.length() ; i++){
            if(String.valueOf(s.charAt(i)).matches(regex)){
                start = i;
                break;
            }
        }
        for(int j = s.length()-1 ; j >= 0 ; j--){
            if(String.valueOf(s.charAt(j)).matches(regex)){
                end = j;
                break;
            }
        }
        s = s.substring(start,end + 1);
        return s;
    }
    public static void main(String[] args) {
        ReverteWordsV1 reverteWords = new ReverteWordsV1();
        //blue is sky the
        //world hello
        //example good a
        String[]s = {"the sky is blue"," hello world ","a good  example"};
        for(String ss : s){
            String str = reverteWords.reverseWords(ss);
//            String str = reverteWords.reverseWords2(ss);
            System.out.println(str);
        }
    }
}
