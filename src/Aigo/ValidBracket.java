package Aigo;

import java.util.*;

/**
 *@Desprition https://leetcode-cn.com/problems/valid-parentheses/
 *给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串s,判断字符串是否有效。
 *有效字符串需满足：1、左括号必须用相同类型的右括号闭合。2、左括号必须以正确的顺序闭合。
 *@Author zhangshenming
 *@Date 2021/9/10 23:00
 *@Version 1.0
 */
public class ValidBracket {
    /**
     *@Description 1、将括号的三种组合用map进行封装；2、new一个stack用来存储遍历string得到的字符；
     * 3、遍历string，将每次出现的符号如果不匹配存入stack中；
     *@Author zhangshenming
     *@Param s
     *@Date 2021/9/10 23:02
     *@Return boolean
     */
    public static boolean isValid(String s) {
        if((s.length() == 0) || (s.length() % 2 != 0)){
            return false;
        }
        Map<Character,Character> map = new HashMap<Character,Character>(16);
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        Stack<Character>stack = new Stack<Character>();
        char peekChar;
        char ch;
        for(int i = 0;i < s.length();i++){
            ch = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(ch);
            }else{
                peekChar = stack.peek();
                if(map.containsKey(peekChar)){
                    if(map.get(peekChar).equals(ch)){
                        stack.pop();
                    }else{
                        stack.push(ch);
                    }
                }else{
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
    /**
     *@Description 优化：
     *@Author zhangshenming
     *@Param s
     *@Date 2021/9/19 17:43
     *@Return boolean
     */
    public static boolean isValid2(String s) {
        if(s.length() == 0){
            return false;
        }
        Map<Character,Character> map = new HashMap<Character,Character>(16);
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        map.put('<','>');
        map.put('"','"');
        Stack<Character>stack = new Stack<Character>();
        char peekChar;
        char ch;
        for(int i = 0;i < s.length();i++) {
            ch = s.charAt(i);
            if ((!map.containsKey(ch)) && (!map.containsValue(ch))) {
                continue;
            }
            if (map.containsKey(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    peekChar = stack.peek();
                    if (map.get(peekChar).equals(ch)) {
                        stack.pop();
                    } else {
                       return false;
                    }
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String[] brackets = {"(())","()[]{}","(]","([)]","{[]}","){", "(((())))"};
        boolean flag = false;
        for(int i = 0;i < brackets.length;i++){
            flag = isValid(brackets[i]);
            System.out.println("该括号字符串"+i+"   "+brackets[i]+"   是否有效："+flag);
        }
    }
}
