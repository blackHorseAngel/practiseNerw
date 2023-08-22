package aigo.N.convert;

/**
 * @Description https://leetcode.cn/problems/zigzag-conversion
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 * @Author Administrator
 * @Date 2023/5/19 15:48
 * @Version 1.0.0
 */
public class NConvertV1 extends NConvertSuper {
    /**
     * 采用numRows个数组来接收，然后再做拼接，每个数组采用走到numRows之后往返走，利用direction做方向变量
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        String[]strs = new String[numRows];
        for(int i = 0 ; i < strs.length ; i++){
                strs[i] = "";
        }
        int step = 0;
        int direction = 1;
        for(int i = 0 ; i < s.length() ; i++){
            strs[step] += String.valueOf(s.charAt(i));
            if(direction > 0){
                if(step + 1 < numRows){
                    step++;
                }else{
                    direction = -1;
                    step--;
                }
            }else{
                if(step - 1 >= 0){
                    step--;
                }else{
                    direction = 1;
                    step++;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for(String ss : strs){
            builder.append(ss);
        }
        return builder.toString();
    }

    /**
     * 尝试走下一步，判断边界
     * @param step
     * @param numRows
     * @param direction
     * @return
     */
    private boolean tryNext(int step,int numRows,int direction) {
        if(direction > 0){
            if(step + 1 >= numRows){
                return false;
            }else{
                return true;
            }
        }else{
           if(step - 1 < 0){
               return false;
           }else{
               return true;
           }
        }
    }

    public static void main(String[] args) {
        //PAHNAPLSIIGYIR
        String s = "PAYPALISHIRING";
//        int numRows1 = 3;
//        String result1 = convert(s,numRows1);
//        System.out.println(result1);
        //PINALSIGYAHRPI
        int numRows2 = 4;
        NConvertV1 nConvert = new NConvertV1();
        String result2 = nConvert.convert(s,numRows2);
        System.out.println(result2);
    }

}
