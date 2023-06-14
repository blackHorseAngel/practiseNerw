package Aigo.Letter.Combination;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 12:41
 * @Version 1.0.0
 */
public class LetterCombinationSuper {
    /**
     * 初始化字符map集合
     * @return
     */
    public static Map<Character, char[]> generateLetters() {
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

    public List<String> letterCombinations(String digits) {
        return Collections.emptyList();
    }
}
