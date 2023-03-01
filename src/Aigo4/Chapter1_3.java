package Aigo4;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/2/21 18:29
 * @Version 1.0.0
 */
public class Chapter1_3 {
    //1.3.2
    public static void print(String[]s){
        Stack<String>stack = new Stack<>();
        for(int i = 0 ; i < s.length;i++){
            stack.push(s[i]);
        }
        while(stack.size() != 0){
            System.out.print(stack.pop());
        }
    }
    //1.3.4
    public static boolean parenthess(String[]s){
        if(s.length == 0 || s.length % 2 != 0){
            return false;
        }
        Stack<String>stack = new Stack<String>();
        for(int i = 0 ; i < s.length ; i++){
                if(stack.size() == 0) {
                    stack.push(s[i]);
                }else{
                    String ss = stack.peek();
                    if("}".equals(s[i]) && "{".equals(ss)){
                        stack.pop();
                    }else if("]".equals(s[i]) && "[".equals(ss)){
                        stack.pop();
                    }else if(")".equals(s[i]) && "(".equals(ss)){
                        stack.pop();
                    }else{
                        stack.push(s[i]);
                    }
                }
        }
        if(stack.size() == 0){
            return true;
        }else{
            return false;
        }
    }
    public static boolean parenthess2(String[]s){
        if(s.length == 0 || s.length % 2 != 0){
            return false;
        }
        Stack<String>stack = new Stack<String>();
        for(int i = 0 ; i < s.length ; i++) {
            if ("{".equals(s[i]) || "[".equals(s[i]) || "(".equals(s[i])) {
                stack.push(s[i]);
            } else {
                if (stack.size() == 0) {
                    return false;
                } else {
                    String ss = stack.peek();
                    if ("}".equals(s[i]) && "{".equals(ss)) {
                        stack.pop();
                    } else if ("]".equals(s[i]) && "[".equals(ss)) {
                        stack.pop();
                    } else if (")".equals(s[i]) && "(".equals(ss)) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        if(stack.size() == 0){
            return true;
        }else{
            return false;
        }
    }
    //1.3.5
    public static void printBinary(int N){
        Stack<Integer>stack = new Stack<>();
        while(N > 0){
            stack.push(N % 2);
            N /= 2;
        }
        while(stack.size() != 0){
            int a = stack.pop();
            System.out.print(a);
        }
    }
    //1.3.9
    public static String calculator(String s){
        if(s.length() == 0){
            return null;
        }
        Stack<String>operatorStack = new Stack<>();
        Stack<String>valueStack = new Stack<>();
        Stack<String>resultStack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        String tempString = "";
        String tempValue1 = "";
        String tempValue2 = "";
        String operatorString = "";
        for(int i = 0 ; i < s.length() ; i++){
             tempString = String.valueOf(s.charAt(i));
            if(tempString.matches("\\d")){
                valueStack.push(tempString);
            }else{
                if(")".equals(tempString)){
                    if(valueStack.size() != 0){
                        tempValue1 = valueStack.pop();
                        tempValue2 = valueStack.pop();
                    }else {
                        tempValue1 = resultStack.pop();
                        tempValue2 = resultStack.pop();
                    }
                    operatorString = operatorStack.pop();
                    builder.append("(");
                    builder.append(tempValue2);
                    builder.append(operatorString);
                    builder.append(tempValue1);
                    builder.append(")");
                    resultStack.push(builder.toString());
                    builder.setLength(0);
                }else{
                    operatorStack.push(tempString);
                }
            }
        }
        String resultString = resultStack.pop();
        return resultString;
    }
    public static double  calculator2(String s){
        if(s.length() == 0){
            return 0;
        }
        Stack<String>operatorStack = new Stack<>();
        Stack<String>valueStack = new Stack<>();
        Stack<Double>resultStack = new Stack<>();
        String tempString = "";
        String tempValue1 = "";
        String tempValue2 = "";
        String tempOperator = "";
        double doubleValue1 = 0.0;
        double doubleValue2 = 0.0;
        double  result = 0.0;
        for(int i = 0 ; i < s.length() ; i++){
            tempString = String.valueOf(s.charAt(i));
            if(tempString.matches("\\d")){
                valueStack.push(tempString);
            }else{
                if(")".equals(tempString)){
                    if(valueStack.size() != 0){
                        tempValue1 = valueStack.pop();
                        doubleValue1 = Double.parseDouble(tempValue1);
                        tempValue2 = valueStack.pop();
                        doubleValue2 = Double.parseDouble(tempValue2);
                    }else{
                        doubleValue1 = resultStack.pop();
                        doubleValue2 = resultStack.pop();
                    }
                    tempOperator = operatorStack.pop();
                    if("+".equals(tempOperator)){
                        result = doubleValue2 + doubleValue1;
                    }else if("-".equals(tempOperator)){
                        result = doubleValue2 - doubleValue1;
                    }else if("*".equals(tempOperator)){
                        result = doubleValue2 * doubleValue1;
                    }else if("/".equals(tempOperator)){
                        result = doubleValue2 / doubleValue1;
                    }
                    resultStack.push(result);
                }else{
                    operatorStack.push(tempString);
                }
            }
        }
        if(resultStack.size() != 0){
            result = resultStack.pop();
            return result;
        }else{
            return 0;
        }
    }
    //1.3.12
    public static Stack<String>copy(Stack<String>stack){
        Iterator<String>iterator = stack.iterator();
        Stack<String> tempStack = new Stack<>();
        Stack<String>resultStack = new Stack<>();
        while(iterator.hasNext()){
            tempStack.push(iterator.next());
        }
        iterator = tempStack.iterator();
        while(iterator.hasNext()){
           resultStack.push(iterator.next());
        }
      return resultStack;
    }
    //1.3.14
    class ResizingArrayQueueOfStrings{
        //队列中元素的数量
        private int N;
        //定长数组
        private String[]string = new String[1];

        public int size(int N){
            return N;
        }

        public boolean isEmpty(int N){
            return N == 0 ? true:false;
        }

        public void enquene(String item){
            if(N == string.length){
                resize(2 * string.length);
            }
            string[N++] = item;
        }
        public String dequeue(){
            String item = string[0];
            for(int i = 0 ; i < N ; i++){
                string[i] = string[i + 1];
            }
            N--;
            if(N > 0 && N == string.length / 4){
                resize(string.length / 2);
            }
            return "";
        }
        private void resize(int m) {
            String[]temp = new String[m];
            for (int i = 0 ; i < N ; i++){
                temp[i] = string[i];
            }
            string = temp;
        }
    }
    //1,3,15
    public static String getDeQueueK(int k){
        String str = "";
        Queue<String>queue = new ArrayDeque<>();
        for (int i = 0 ; i < 10 ; i++){
            queue.add(String.valueOf(i));
        }
        int length = queue.size() - k;
        for(int i = 0 ; i < length ; i++){
            str = queue.poll();
        }
        return str;
    }
    //
    public static void main(String[] args) {
        //1.3.2
//        String[]s ={"it ","was ","- ","the ","best ","of ","times ","- ","- ","- ","it ","was ","the ","- ","- "};
//        print(s);
        //1.3.4
//        String[]s1 = {"[","(",")","]","{","}","{","[","(",")","(",")","]","(",")","}"};
        //true
//        boolean b1 = parenthess2(s1);
//        String[]s2 = {"[","(","]",")"};
        //false
//        boolean b2 = parenthess2(s2);
//        String[]s3 = {"{","{","{","{"};
        //false
//        boolean b3 = parenthess2(s3);
        //false
//        String[]s4 = {"{",")",")","}"};
//        boolean b4 = parenthess2(s4);
        //false
//        String[]s5 = {"{","{","[","]","]","}","("};
//        boolean b5 = parenthess2(s5);
        //true
//        String[]s6 = {"(",")"};
//        boolean b6 = parenthess2(s6);
        //false
//        String[]s7 = {"{",")"};
//        boolean b7 = parenthess2(s7);
        //false
//        String[]s8 = {"{","{","{","}"};
//        boolean b8 = parenthess2(s8);
        //false
//        String[]s9 = {"{","{","{","]"};
//        boolean b9 = parenthess2(s9);
//        String[]s10 = {"{","{"};
//        boolean b10 = parenthess2(s10);
//        String[]s11 = {};
//        if(b6){
//            System.out.println(true);
//        }else{
//            System.out.println(false);
//        }

        //1.3.5
//        printBinary(50);
        //1.3.9
//        String s = "1+2)*3-4)*5-6)))";
//        String resultString = calculator(s);
//        System.out.println(resultString);
//        double d = calculator2(s);
//        System.out.println(d);
        //1.3.12
//        Stack<String>stack = new Stack<>();
//        for(int i = 0 ; i < 6;i++){
//            stack.push(String.valueOf(i));
//        }
//        Stack<String>resultStack = new Stack<>();
//        resultStack = copy(stack);
//        String tempString = "";
//        while (resultStack.size() != 0){
//            tempString = resultStack.pop();
//            System.out.println(tempString);
//        }
      //1.3.15
//        String s = getDeQueueK(5);
//        System.out.println(s);
    }
}
