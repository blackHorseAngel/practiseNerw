package aigo.Word.pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description https://leetcode.cn/problems/word-pattern
 * 给定一种规律 pattern和一个字符串s，判断 s是否遵循相同的规律。
 * 这里的遵循指完全匹配，例如，pattern里的每个字母和字符串s中的每个非空单词之间存在着双向连接的对应规律。
 * 输入: pattern = "abba", s = "dog cat cat dog"
 * 输出: true
 * 输入:pattern = "abba", s = "dog cat cat fish"
 * 输出: false
 * 输入: pattern = "aaaa", s = "dog cat cat dog"
 * 输出: false
 * 1 <= pattern.length <= 300
 * pattern只包含小写英文字母
 * 1 <= s.length <= 3000
 * s只包含小写英文字母和' '
 * s不包含 任何前导或尾随对空格
 * s中每个单词都被 单个空格 分隔
 * @Author Administrator
 * @Date 2023/7/3 12:58
 * @Version 1.0.0
 */
public class WordPatternV1 extends WordPatternSuper{
    @Override
    public boolean wordPattern(String pattern, String s) {
        char[]patternChars  = pattern.toCharArray();
        String[]sStrings = s.split(" ");
        if(patternChars.length != sStrings.length){
            return false;
        }
        Map<Character,String>patternToStringMap = new HashMap<>();
        Map<String,Character>StringToPatternMap = new HashMap<>();
        for (int i = 0; i < sStrings.length; i++) {
            char pc = patternChars[i];
            if(patternToStringMap.containsKey(pc)){
                if(patternToStringMap.get(pc).equals(sStrings[i])){
                    continue;
                }else{
                    return false;
                }
            }else{
                patternToStringMap.put(pc,sStrings[i]);
            }
            if(StringToPatternMap.containsKey(sStrings[i])){
                if(StringToPatternMap.get(sStrings[i]) == pc){
                    continue;
                }else {
                    return false;
                }
            }else{
                StringToPatternMap.put(sStrings[i],pc);
            }

        }
        return true;
    }

    public static void main(String[] args) {
        WordPatternV1 wordPatternV1 = new WordPatternV1();
        //true
        String pattern = "abba";
        String s = "dog cat cat dog";
        //false
//        String pattern = "abba";
//        String s = "dog cat cat fish";
        //false
//        String pattern = "aaaa";
//        String s = "dog cat cat dog";
        //false
//       ri String pattern = "abba";
//        Stng s = "dog dog dog dog";
        boolean flag = wordPatternV1.wordPattern(pattern,s);
        System.out.println(flag);
    }
}
