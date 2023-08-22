package aigo.reverse.String;

import java.util.Stack;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/4 14:17
 * @Version 1.0.0
 */
public class ReverteWordsV2 extends ReverteWordsSuper{
    @Override
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        Stack<String>stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            String ss = String.valueOf(s.charAt(i));
            boolean flag = judgeState(ss);
            if(flag){
                builder.append(ss);
            }else{
                if(builder.length() != 0){
                    stack.push(builder.toString());
                    builder.setLength(0);
                }
            }
        }

        while(!stack.empty()){
            if(builder.length()!= 0){
                builder.append(" ");
            }
            builder.append(stack.pop());
        }
        return builder.toString();

    }
    /**
     * true:处理字符串的非空格字符
     * false：处理字符串中的空格字符
     * @param ss
     * @return
     */
    private boolean judgeState(String ss) {
        String regex = "[A-Za-z0-9]";
        if(ss.matches(regex)){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        ReverteWordsV2 reverteWords = new ReverteWordsV2();
        //blue is sky the
        //world hello
        //example good a
        String[] s = {"the sky is blue", " hello world ", "a good  example"};
        for (String ss : s) {
            String str = reverteWords.reverseWords(ss);
            System.out.println(str);
        }
    }
}
