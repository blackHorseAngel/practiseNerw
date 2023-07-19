package Aigo.Length;

/**
 * @Description https://leetcode.cn/problems/length-of-last-word
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * 输入：s = "Hello World"
 * 输出：5
 * 解释：最后一个单词是“World”，长度为5。
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 解释：最后一个单词是“moon”，长度为4。
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 * 解释：最后一个单词是长度为6的“joyboy”。
 * 1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 * s 中至少存在一个单词
 * @Author Administrator
 * @Date 2023/7/3 9:04
 * @Version 1.0.0
 */
public class LengthOfLastWordV1 extends LengthOfLastWordSuper {
    @Override
    public int lengthOfLastWord(String s) {
        if(s.trim().length() == 1){
            return 1;
        }
        char[] chars = s.trim().toCharArray();
        int count = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                count = i;
                break;
            }
        }
        if(count == 0){
            return chars.length;
        }
        return chars.length - 1 - count;
    }

    public static void main(String[] args) {
//        String[]strings = new String[]{"Hello World","   fly me   to   the moon  ","luffy is still joyboy"};
        LengthOfLastWordV1 lengthOfLastWordV1 = new LengthOfLastWordV1();
//        for (int i = 0; i < strings.length; i++) {

//        int len = lengthOfLastWordV1.lengthOfLastWord(strings[i]);
//        }
        String s = "   a";
        int len = lengthOfLastWordV1.lengthOfLastWord(s);
            System.out.println(len);
    }
}
