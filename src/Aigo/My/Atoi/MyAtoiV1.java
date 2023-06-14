package Aigo.My.Atoi;

/**
 * @Description https://leetcode.cn/problems/string-to-integer-atoi
 * 请你来实现一个myAtoi(string s)函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * 函数myAtoi(string s) 的算法如下：
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231, 231− 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，
 * 大于 231− 1 的整数应该被固定为 231− 1 。
 * 返回整数作为最终结果。
 * 注意：
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 * 输入：s = "42"
 * 输出：42
 * 解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
 * 第 1 步："42"（当前没有读入字符，因为没有前导空格）
 *          ^
 * 第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 *          ^
 * 第 3 步："42"（读入 "42"）
 *            ^
 * 解析得到整数 42 。
 * 由于 "42" 在范围 [-231, 231 - 1] 内，最终结果为 42 。
 * 输入：s = "   -42"
 * 输出：-42
 * 解释：
 * 第 1 步："   -42"（读入前导空格，但忽视掉）
 *             ^
 * 第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
 *              ^
 * 第 3 步："   -42"（读入 "42"）
 *                ^
 * 解析得到整数 -42 。
 * 由于 "-42" 在范围 [-231, 231 - 1] 内，最终结果为 -42 。
 * 输入：s = "4193 with words"
 * 输出：4193
 * 解释：
 * 第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
 *          ^
 * 第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 *          ^
 * 第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
 *              ^
 * 解析得到整数 4193 。
 * 由于 "4193" 在范围 [-231, 231 - 1] 内，最终结果为 4193 。
 * 0 <= s.length <= 200
 * s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
 * @Author Administrator
 * @Date 2023/6/1 16:06
 * @Version 1.0.0
 */
public class MyAtoiV1 extends MyAtoiSuper {
    //2147483647
    public static String MAX = String.valueOf(Integer.MAX_VALUE);
    //-2147483648
    public static String MIN = String.valueOf(Integer.MIN_VALUE);

    /**
     *
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        if((s.charAt(0) != ' ') && (String.valueOf(s.charAt(0)).matches("[a-zA-Z]"))){
            return 0;
        }
        if(s.length() == 0){
            return 0;
        }
        //对原始字符串做处理，去掉头尾多余的部分
        s = deleteBeforeNumAndAfterNum(s);
        //+2147483647
        //-2147483648
        //符号位，如果被处理后的数字的首位是负号，那么flag是-1，如果是数字，那么flag是1
        int flag = 0;
        //结果数字
        int result = 0;
        StringBuilder builder = new StringBuilder();
        if(s.charAt(0) == '-'){
            flag= -1;
            if(s.length() > MIN.length()){
                return Integer.MIN_VALUE;
            }else{
                result = convertStringToForNegativeInteger(s,flag,builder);
            }
        }else{
            flag = 1;
            if(s.length() > MAX.length()){
                return Integer.MAX_VALUE;
            }else{
                result = convertStringToForPositiveInteger(s,flag,builder);
            }
        }
        return result;
    }

    /**
     *
     * @param s
     * @param flag
     * @return
     */
    private int convertStringToForNegativeInteger(String s, int flag,StringBuilder builder) {
        //结果数字
        int result = 0;
        for(int i = 1 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(c == '.'){
                return 0;
            }
           builder.append(c);
           //如果拿到的字符串等于int最小值的字符串的长度，那么它们相减，如果返回是true，说明没有越界，返回str转成整数再带上”-“；否则越界，那么返回整数最小值
           //如果str的长度小于int最小值的字符串的长度，那么继续循环
            if(builder.length() == MIN.length()){
                String str = builder.toString();

                if(minusStr(str,MIN,flag)){
                    result = Integer.valueOf(str);
                    result = result * flag;
                }else{
                  result = Integer.MIN_VALUE;
                }
            }else {
                continue;
            }
       }
       if(result == 0){
           result = Integer.valueOf(builder.toString());
           result = result * flag;
        }
       return result;
    }

    /**
     * standard - str的结果来判断是否越界，这里的两个数字都按照正数来计算
     * @param str
     * @param standard
     */
    private boolean minusStr(String str, String standard,int flag) {
        //用来计数借位
        int bit = 0;
        String resultStr = "";
        StringBuilder builder = new StringBuilder();
        for(int i = standard.length() - 1 ; i >= (0 > flag ? 1 : 0) ; i--){
            int standardBit = Integer.valueOf(standard.charAt(i));
            int actualBit = Integer.valueOf(str.charAt(i));
            int result= 0;
            if(standardBit >= actualBit){
                if(bit > 0){
                    standardBit = standardBit - bit;
                    bit = 0;
                }
                result = standardBit - actualBit;
                builder.append(result);

            }else if(standardBit < actualBit){
                if(bit > 0){
                    result = standardBit + 10 - bit - actualBit;
                }else{
                    bit = 1;
                    result = standardBit + 10 - actualBit;
                }

                builder.append(result);
            }
            if(i == 0 && bit > 0){
                builder.append("-");
            }
        }
       resultStr = builder.reverse().toString();
        if(resultStr.charAt(0) == '-'){
            return false;
        }else{
            return true;
        }
    }

    /**
     *
     * @param s
     * @param flag
     * @return
     */
    private int convertStringToForPositiveInteger(String s, int flag,StringBuilder builder) {
        //结果数字
        int result = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(c == '.'){
                return 0;
            }
            builder.append(c);
            //如果拿到的字符串等于int最小值的字符串的长度，那么它们相减，如果返回是true，说明没有越界，返回str转成整数再带上”-“；否则越界，那么返回整数最小值
            //如果str的长度小于int最小值的字符串的长度，那么继续循环
            if(builder.length() == MAX .length()){
                String str = builder.toString();

                if(minusStr(str,MAX,flag)){
                    result = Integer.valueOf(str);
                    result = result * flag;
                }else{
                    result = Integer.MIN_VALUE;
                }
            }else {
                continue;
            }
        }
        if(result == 0){
            result = Integer.valueOf(builder.toString());
            result = result * flag;
        }
        return result;
    }

    /**
     * 去掉数字或者-，+之前的空格和字母并且去掉数字之后的空格或字母
     * @param s
     * @return
     */
    private String deleteBeforeNumAndAfterNum(String s) {
        int start = 0;
        int end = 0;

        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) != ' '){
                start = i;
                break;
            }
        }
        String afterRegex = "[0-9]";
        for(int j = s.length() - 1 ; j >= 0 ; j--){
            if(String.valueOf(s.charAt(j)).matches(afterRegex)){
                end = j;
                break;
            }
        }
        s = s.substring(start,end + 1);
        return s;
    }

    public static void main(String[] args) {
//        MyAtoiV1 myAtoiV1 = new MyAtoiV1();
//        String[]s = {"words with 987","42","   -42","4193 with words"};
//        for(int i = 0 ; i < s.length ; i++){
//            int num = myAtoiV1.myAtoi(s[i]);
//            System.out.println(num);
//        }
        String s = "";
        System.out.println(s.length());
    }
}
