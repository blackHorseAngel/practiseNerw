package Aigo.Reverse.String;

import java.util.Stack;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/4 14:19
 * @Version 1.0.0
 */
public class ReverteWordsV3 extends ReverteWordsSuper{
    //开始状态
    private static final int STATE_BEGIN = 0;
    //读单词状态
    private static final int STATE_READ_WORD = 1;
    //读空格状态
    private static final int STATE_READ_SPACE = 2;
    /**
     * 状态机
     * @param s
     * @return
     */
    @Override
    public String reverseWords(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        char chars[] = s.toCharArray();
        int state = STATE_BEGIN;
        for (char ch : chars) {
            switch (state) {
                case STATE_BEGIN:
                    if (ch == ' ') {
                        continue;
                    }
                    else {
                        StringBuilder sb =new StringBuilder();
                        sb.append(ch);
                        stack.push(sb);
                        state = STATE_READ_WORD;
                    }
                    break;
                case STATE_READ_WORD:
                    if (ch == ' ') {
                        state = STATE_READ_SPACE;
                    }
                    else {
                        stack.peek().append(ch);
                    }
                    break;
                case STATE_READ_SPACE:
                    if (ch != ' ') {
                        StringBuilder sb =new StringBuilder();
                        sb.append(ch);
                        stack.push(sb);
                        state = STATE_READ_WORD;
                    }
                    break;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        ReverteWordsV3 reverteWords = new ReverteWordsV3();
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
