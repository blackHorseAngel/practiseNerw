package Aigo;

import java.util.*;

/**
 * @Description https://leetcode.cn/problems/letter-combinations-of-a-phone-number
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 输入：digits = ""
 * 输出：[]
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 * @Author Administrator
 * @Date 2023/3/24 10:07
 * @Version 1.0.0
 */
public class LetterCombinations {
    /**
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        int length = digits.length();
        List<String>resultList = new ArrayList<>();
        if(length == 0){
            return resultList;
        }
        //初始化数字->字母顺序表
        Map<Character,char[]>letterMap = generateLetters();

        //依次得到的每个字符
        char[]ch = new char[length];
        //对上面得到的字符串数字排序组合
        countIndex(ch,letterMap,digits,0,resultList);
        return resultList;
    }

    /**
     * 依次循环每一位，获取对应的字母，整理成字符串，
     * @param ch
     * @param letterMap
     * @param num
     * @param resultList
     */
    private static void countIndex(char[]ch,Map<Character,char[]> letterMap,String digits, int num,List<String> resultList) {
        // 根据当前数字， 找到对应的字符集合
        char[] lcs = letterMap.get(digits.toCharArray()[num]);

        for(char c : lcs){
            ch[num] = c;
            if(num == ch.length - 1){
                resultList.add(transferCharToString(ch));
                continue;
            }
            countIndex(ch,letterMap,digits,num+1,resultList);
        }
    }

    /**
     * 将组合好的字符数组转成字符串
     * @param ch
     * @return
     */
    private static String transferCharToString(char[] ch) {
        StringBuilder builder = new StringBuilder();
        for(char c : ch){
            builder.append(c);
        }
        return builder.toString();
    }

    /**
     * 初始化字符map集合
     * @return
     */
    private static Map<Character, char[]> generateLetters() {
        Map<Character,char[]>letterMap = new HashMap<>();
        letterMap.put('2',"abc".toCharArray());
        letterMap.put('3',"def".toCharArray());
        letterMap.put('4',"ghi".toCharArray());
        letterMap.put('5',"jkl".toCharArray());
        letterMap.put('6',"mno".toCharArray());
        letterMap.put('7',"pqrs".toCharArray());
        letterMap.put('8',"tuv".toCharArray());
        letterMap.put('9',"wxyz".toCharArray());
        return letterMap;
    }

    public static void main(String[] args) {
        //["ad","ae","af","bd","be","bf","cd","ce","cf"]
//        String digits = "23";
//        ["a","b","c"]
//        String digits = "2";
        //[]
//        String digits = ""
        //["ada","bda","cda","aea","bea","cea","afa","bfa","cfa","adb","bdb","cdb","adb","bdb","cdb","aeb","beb","ceb","afb","bfb","cfb","adc",
        // "bdc","cdc","aec","bec","cec","afc","bfc","cfc"]
        String digits = "232";
        List<String>list = letterCombinations(digits);
        for (int i = 0 ; i < list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
