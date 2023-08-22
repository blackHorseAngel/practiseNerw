package aigo.valid.Bracket;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 18:46
 * @Version 1.0.0
 */
public class ValidBracketV2 extends ValidBracketSuper{
    /**
     *@Description 优化：
     *@Author zhangshenming
     *@Param s
     *@Date 2021/9/19 17:43
     *@Return boolean
     */
    public boolean isValid(String s) {
        if(s.length() == 0){
            return false;
        }
        Map<Character,Character> map = new HashMap<Character,Character>(16);
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        map.put('<','>');
        map.put('"','"');
        Stack<Character> stack = new Stack<Character>();
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
        ValidBracketV2 validBracketV2 = new ValidBracketV2();
        for(int i = 0 ; i < brackets.length ; i++){
            flag = validBracketV2.isValid(brackets[i]);
            System.out.println("该括号字符串"+i+"   "+brackets[i]+"   是否有效："+flag);
        }
    }
}
