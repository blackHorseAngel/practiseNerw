package aigo.reverse.String;

import java.util.Stack;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/4 13:56
 * @Version 1.0.0
 */
public class ReverseString2V2 extends ReverseString2Super{
    /**
     * 使用stack操作
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i< s.length() ; i++){
            stack.push(s.charAt(i));
        }
        StringBuilder builder = new StringBuilder();
        String result = "";
        while(!stack.empty()){
            if(' ' == stack.peek()){
                builder.insert(0,stack.pop());
                result = builder.toString() + result;
                builder.setLength(0);
            }else{
                builder.append(stack.pop());
            }
        }
        result = builder.toString() ;
        builder.setLength(0);
        return result;
    }
    public static void main(String[] args) {
        // "s'teL ekat edoCteeL tsetnoc"
        // "doG gniD"
        String[] strings = new String[]{"Let's take LeetCode contest", "God Ding"};
        ReverseString2V2 reverseString2 = new ReverseString2V2();
        for (String ss : strings) {
            String result = reverseString2.reverseWords2(ss);
            System.out.println(result);
        }
    }
}
