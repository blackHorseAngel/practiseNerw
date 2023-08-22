package aigo.count.Vowel.Strings;

/**
 * @Description https://leetcode.cn/problems/count-sorted-vowel-strings
 * 给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
 * 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。
 * 输入：n = 1
 * 输出：5
 * 解释：仅由元音组成的 5 个字典序字符串为 ["a","e","i","o","u"]
 * 输入：n = 2
 * 输出：15
 * 解释：仅由元音组成的 15 个字典序字符串为
 * ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
 * 注意，"ea" 不是符合题意的字符串，因为 'e' 在字母表中的位置比 'a' 靠后
 *输入：n = 33
 * 输出：66045
 * 1 <= n <= 50
 * @Author Administrator
 * @Date 2023/3/31 12:41
 * @Version 1.0.0
 */
public class CountVowelStringsV1 extends CountVowelStringsSuper {
    //
    public int countVowelStrings(int n) {
        /**
         * n=1     5 = 1 + 1 + 1 + 1  + 1
         * n=2    15 = 1 + 2 + 3 + 4  + 5
         * n=3    35 = 1 + 3 + 6 + 10 + 15
         * n=4    70 = 1 + 4 + 10 + 20 + 35
         */
        //保留中间值的数组
        int[]sum = new int[]{1,1,1,1,1};
        //最终结果数组
        int[]result = new int[5];
        if(n == 1){
            result = sum;
        }else{
            for(int j = 1 ; j < n ; j++){
                result[0] = sum[0];
                for(int i = 1 ; i < 5 ; i++){
                    result[i] = sum[i] + result[i-1];
                }
                sum = result;
            }
        }
        int count = 0;
        for(int i:result){
            count += i;
        }
        return count;
    }

    public static void main(String[] args) {
        CountVowelStringsV1 countVowelStringsV1 = new CountVowelStringsV1();
        //5
//        int num = countVowelStringsV1.countVowelStrings(1);
        //15
//        int num = countVowelStringsV1.countVowelStrings(2);
//        35
//        int num = countVowelStringsV1.countVowelStrings(3);
        //70
//        int num = countVowelStringsV1.countVowelStrings(4);
         //33
          int num = countVowelStringsV1.countVowelStrings(33);
        System.out.println(num);
    }
}
