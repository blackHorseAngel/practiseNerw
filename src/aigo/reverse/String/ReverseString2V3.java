package aigo.reverse.String;

import java.util.Stack;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/4 13:57
 * @Version 1.0.0
 */
public class ReverseString2V3 extends ReverseString2Super {
    /**
     * 使用stack，
     * @param s
     * @return
     */
    @Override
    public String reverseWords(String s) {
        Stack<Character>stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(c == ' '){
                while(!stack.empty()){
                    builder.append(stack.pop());
                }
                builder.append(c);
            }else{
                stack.push(c);
            }
        }
        while(!stack.empty()){
            builder.append(stack.pop());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        // "s'teL ekat edoCteeL tsetnoc"
        // "doG gniD"
        String[] strings = new String[]{"Let's take LeetCode contest", "God Ding"};
        ReverseString2V3 reverseString2 = new ReverseString2V3();
        for (String ss : strings) {
            String result = reverseString2.reverseWords(ss);
            System.out.println(result);
        }
    }
}
