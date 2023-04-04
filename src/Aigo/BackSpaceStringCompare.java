package Aigo;

import java.util.Stack;

/**
 * @Description  https://leetcode.cn/problems/backspace-string-compare
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * 输入：s = "ab#c", t = "ad#c"
 * 输出：true
 * 解释：s 和 t 都会变成 "ac"。
 * 输入：s = "ab##", t = "c#d#"
 * 输出：true
 * 解释：s 和 t 都会变成 ""。
 * 输入：s = "a#c", t = "b"
 * 输出：false
 * 解释：s 会变成 "c"，但 t 仍然是 "b"。
 *  @Author Administrator
 * @Date 2023/3/3 18:14
 * @Version 1.0.0
 */
public class BackSpaceStringCompare {
    //
    public static boolean backspaceCompare(String s, String t) {
        Stack<Character>sstack = new Stack<>();
        Stack<Character>tstack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            char sc = s.charAt(i);
            if(sc != '#'){
                sstack.push(sc);
            }else{
                if(sstack.size() != 0){
                    sstack.pop();
                }
            }
        }
        for(int j = 0 ; j < t.length() ; j++){
            char tc = t.charAt(j);
            if(tc != '#'){
                tstack.push(tc);
            }else{
                if(tstack.size() != 0){
                    tstack.pop();
                }
            }
        }
        if(sstack.size() == tstack.size()){
            while(sstack.size() != 0){
                char sc = sstack.pop();
                char tc = tstack.pop();
                if(sc != tc){
                    return false;
                }
            }
        }else{
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        String s = "ab#c";
//        String t = "ad#c";
//        String s = "a#c";
//        String t = "b";
        String s = "ab##";
        String t = "c#d#";
        boolean flag = backspaceCompare(s,t);
        System.out.println(flag);
    }
}
