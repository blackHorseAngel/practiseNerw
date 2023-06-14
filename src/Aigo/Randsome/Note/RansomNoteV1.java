package Aigo.Randsome.Note;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description https://leetcode.cn/problems/ransom-note
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote 和 magazine 由小写英文字母组成
 * @Author Administrator
 * @Date 2023/3/3 17:14
 * @Version 1.0.0
 */
public class RansomNoteV1 extends RansomNoteSuper {
    //map存储
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> ransomNoteMap = new HashMap<>();
        Map<Character,Integer> magazineMap = new HashMap<>();
        for(int i = 0 ; i < ransomNote.length() ; i++){
            char c = ransomNote.charAt(i);
            if(ransomNoteMap.containsKey(c)){
                int value = ransomNoteMap.get(c);
                ransomNoteMap.put(c,++value);
            }else{
                ransomNoteMap.put(c,1);
            }
        }
        for(int j = 0 ; j < magazine.length() ; j++){
            char ch = magazine.charAt(j);
            if(magazineMap.containsKey(ch)){
                int value = magazineMap.get(ch);
                magazineMap.put(ch,++value);
            }else{
                magazineMap.put(ch,1);
            }
        }
        boolean flag = true;
        for(Character c : ransomNoteMap.keySet()){
            if(magazineMap.containsKey(c)){
                int ransomNoteMapValue = ransomNoteMap.get(c);
                int magazineMapValue = magazineMap.get(c);
                if( ransomNoteMapValue <= magazineMapValue){
                    flag = true;
                }else{
                    flag = false;
                    break;
                }
            }else{
                flag = false;
                break;
            }
        }
        if(flag){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        String ransomNote = "a";
//        String magazine = "b";
//        String ransomNote = "aa";
//        String magazine = "ab";
//        String ransomNote = "aa";
//        String magazine = "aab";
//        String ransomNote = "bg";
//        String magazine = "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj";
        String ransomNote = "bcb";
        String magazine = "cjjajdfaaeegig";
        RansomNoteV1 note = new RansomNoteV1();
        boolean flag = note.canConstruct(ransomNote,magazine);
        System.out.println(flag);

    }
}
