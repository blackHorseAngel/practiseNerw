package Aigo;

/**
 *@Desprition https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *@Author zhangshenming
 *@Date 2021/9/4 11:12
 *@Version 1.0
 */
public class ReverseString2 {
    /**
     *@Description 将一个整体的字符串根据空格拆成若干个字符单串，对每个字符串反向输出即可。
     *@Author zhangshenming
     *@Param s
     *@Date 2021/9/4 11:12
     *@Return java.lang.String
     */
    public static String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String[]str = s.split(" ");
        for(int i = 0;i<str.length;i++){
            for(int j = str[i].length()-1;j >=0;j--){
                stringBuilder.append(str[i].charAt(j));
            }
            if (i != str.length-1) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        String str = "Let's take LeetCode contest";
        String s = reverseWords(str);
        System.out.println(s);
    }
}
