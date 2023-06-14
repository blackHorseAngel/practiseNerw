package Aigo.Randsome.Note;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 13:34
 * @Version 1.0.0
 */
public class RansomNoteV2 extends RansomNoteSuper{
    /**
     * 小写字母集遍历
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote,String magazine){
        int[] charIndex = new int[26];
        for (char c : ransomNote.toCharArray()) {
            int index = magazine.indexOf(c, charIndex[c - 'a']);
            if (index == -1) {
                return false;
            }
            charIndex[c - 'a'] = index + 1;
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
        RansomNoteV2 note2 = new RansomNoteV2();
        boolean flag = note2.canConstruct(ransomNote,magazine);
        System.out.println(flag);

    }
}
