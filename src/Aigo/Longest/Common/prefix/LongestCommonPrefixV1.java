package Aigo.Longest.Common.prefix;

/**
 * @Description https://leetcode.cn/problems/longest-common-prefix
 * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串""。
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 * @Author Administrator
 * @Date 2023/7/4 13:59
 * @Version 1.0.0
 */
public class LongestCommonPrefixV1 extends LongestCommonPrefixSuper{
    @Override
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1){
            return strs[0];
        }
        int len = strs.length;
        int length = 400;
        char[][] chars = new char[len][];
        for (int i = 0; i < len; i++) {
            chars[i] = strs[i].toCharArray();
            length = Math.min(length, chars[i].length);
        }

        StringBuilder builder = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < length; i++) {
            int firstIndex = 0;
            int secondIndex = 1;
            while (secondIndex < len) {
                if (chars[firstIndex][i] == chars[secondIndex][i]) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
                secondIndex++;
            }
            if(flag){
                builder.append(chars[firstIndex][i]);
            }else{
                break;
            }
        }
        if(builder.length() == 0){
            return "";
        }else{
           return builder.toString();
        }
    }

    public static void main(String[] args) {
        LongestCommonPrefixV1 longestCommonPrefixV1 = new LongestCommonPrefixV1();
        //"fl"
//        String[]strs = {"flower","flow","flight"};
        //""
        String[]strs = {"dog","racecar","car"};
        String s = longestCommonPrefixV1.longestCommonPrefix(strs);
        System.out.println(s);
    }
}
