package aigo.reverse.String;

/**
 *@Desprition https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * 输入：s = "Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * 输入： s = "God Ding"
 * 输出："doG gniD"
 * 1 <= s.length <= 5 * 104
 * s包含可打印的 ASCII 字符。
 * s不包含任何开头或结尾空格。
 * s里 至少 有一个词。
 * s中的所有单词都用一个空格隔开。
 *@Author zhangshenming
 *@Date 2021/9/4 11:12
 *@Version 1.0
 */
public class ReverseString2V1 extends ReverseString2Super {
    /**
     *@Description 将一个整体的字符串根据空格拆成若干个字符单串，对每个字符串反向输出即可。
     *@Author zhangshenming
     *@Param s
     *@Date 2021/9/4 11:12
     *@Return java.lang.String
     */
    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String[]str = s.split(" ");
        for(int i = 0 ; i < str.length ; i++){
            for(int j = str[i].length()-1 ; j >= 0 ; j--){
                stringBuilder.append(str[i].charAt(j));
            }
            if (i != str.length-1) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        // "s'teL ekat edoCteeL tsetnoc"
        // "doG gniD"
        String[]strings = new String[]{"Let's take LeetCode contest","God Ding"};
        ReverseString2V1 reverseString2 = new ReverseString2V1();
        for (String ss:strings) {
            String s = reverseString2.reverseWords(ss);
            System.out.println(s);
        }
    }
}
