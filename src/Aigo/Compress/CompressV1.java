package Aigo.Compress;

/**
 * @Description https://leetcode.cn/problems/string-compression
 * 给你一个字符数组 chars ，请使用下述算法压缩：
 * 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
 * 如果这一组长度为 1 ，则将字符追加到 s 中。
 * 否则，需要向 s 追加字符，后跟这一组的长度。
 * 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
 * 请在 修改完输入数组后 ，返回该数组的新长度。
 * 你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
 * 输入：chars = ["a","a","b","b","c","c","c"]
 * 输出：返回 6 ，输入数组的前 6 个字符应该是：["a","2","b","2","c","3"]
 * 解释："aa" 被 "a2" 替代。"bb" 被 "b2" 替代。"ccc" 被 "c3" 替代。
 * 输入：chars = ["a"]
 * 输出：返回 1 ，输入数组的前 1 个字符应该是：["a"]
 * 解释：唯一的组是“a”，它保持未压缩，因为它是一个字符。
 * 输入：chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * 输出：返回 4 ，输入数组的前 4 个字符应该是：["a","b","1","2"]。
 * 解释：由于字符 "a" 不重复，所以不会被压缩。"bbbbbbbbbbbb" 被 “b12” 替代。
 * 1 <= chars.length <= 2000
 * chars[i] 可以是小写英文字母、大写英文字母、数字或符号
 * @Author Administrator
 * @Date 2023/6/1 0:19
 * @Version 1.0.0
 */
public class CompressV1 extends CompressSuper {
    /**
     *
     * @param chars
     * @return
     */
    public int compress(char[] chars) {
        if(chars.length == 1){
            return 1;
        }
        int slowIndex = 0;
        int fastIndex = 0;
        int count = 0;
        while(fastIndex < chars.length){
            char temp1 = chars[slowIndex];
            char temp2 = chars[fastIndex];
            if(temp1 == temp2){
                count++;
                fastIndex++;
            }else{
                if(count == 0){
                    chars[slowIndex] = chars[fastIndex];
                    slowIndex++;
                    fastIndex++;
                }else if(count == 1){
                    slowIndex++;
                    chars[slowIndex] = chars[fastIndex];
                    count = 0;
                }else if(count > 1){
                    slowIndex++;
                    String countStr = String.valueOf(count);
                    for(int i = 0 ; i < countStr.length() ; i++,slowIndex++){
                       chars[slowIndex] = countStr.charAt(i);
                    }
                    chars[slowIndex] = chars[fastIndex];
                    count = 0;
                }
            }
        }
        if(count > 1){
            slowIndex++;
            String countStr = String.valueOf(count);
            for(int i = 0 ; i < countStr.length() ; i++,slowIndex++){
                chars[slowIndex] = countStr.charAt(i);
            }
        }else if(count == 1){
            slowIndex++;
        }
        return slowIndex;
    }

    public static void main(String[] args) {
       char[][]chars = new char[6][];
       char[]char1 =  {'a','a','b','b','c','c','c'};
       char[]char2 =  {'a'};
       char[]char3 =  {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
       char[]char4 = {'a','b','c'};
       char[]char5 = {'a','b','c','d','e','f','g','g','g','g','g','g','g','g','g','g','g','g','a','b','c'};
       char[]char6 = {'a','b','c','d','d','e','e','e','e','e','a','b','c','c','c','c','c','d'};
      //6
       chars[0] = char1;
       //1
       chars[1] = char2;
       //4
       chars[2] = char3;
       //3
        chars[3] = char4;
        //12
        chars[4] = char5;
        //12
        chars[5] = char6;
       CompressV1 compress = new CompressV1();
       for(int i = 0 ; i < chars.length ; i++){
          int count = compress.compress(chars[i]);
           System.out.println(count);
        }

    }
}
