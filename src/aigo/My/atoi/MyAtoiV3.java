package aigo.My.atoi;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/9 20:29
 * @Version 1.0.0
 */
public class MyAtoiV3 extends MyAtoiSuper{
    //开始状态
    public  static final int BEGIN = 0;
    //输入有效
    public static final int INPUT_VALID = 1;
    //输入无效
    public static final int INPUT_INVALID = 2;
    //整数的最大值的字符串形式“2147483647”
    public static final int MAXMINLENGTH = 10;
    //整数最大值的个位7
    public static final int MAXBIT = 7;
    //整数最大值除了个数的其他数字
    public static final int SECONDMAXMIN = 214748364;
    //整数的最小值的个位8
    public static final int MINBIT = 8;
    //TODO 如果整合状态
    public int myAtoi(String s) {
        if(s.length() == 0){
            return 0;
        }
        //符号位，1代表正数，-1代表负数
        int flag = 0;
        //状态码
        int state = BEGIN;
        StringBuilder builder = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            switch (state){
                case BEGIN:
                    if(Character.isWhitespace(c)){
                        state = INPUT_VALID;
                    } else if (Character.isDigit(c)) {
                        state = INPUT_VALID;
                        flag = 1;
                        handleDigitToString(c,builder);

                    } else if (c == '+') {
                        state = INPUT_VALID;
                        flag = 1;
                    } else if (c == '-') {
                        state = INPUT_VALID;
                        flag = -1;
                    }else{
                        state = INPUT_INVALID;
                    }
                    break;
                case INPUT_VALID:
                    break;
            }
            String resultStr = builder.toString();
            int result = 0;
            int len = builder.length();
            if(len == 0){
                return 0;
            } else {
                if(flag > 0){
                    if(len > MAXMINLENGTH){
                        return Integer.MAX_VALUE;
                    } else if (len < MAXMINLENGTH) {
                        result = Integer.parseInt(resultStr);
                        return result;
                    }else {
                        if(compareBuilderWithMax(resultStr)){
                            result = Integer.parseInt(resultStr);
                            return result;
                        }else {
                            return Integer.MAX_VALUE;
                        }
                    }
                } else if (flag < 0) {
                    if(len > MAXMINLENGTH){
                        return Integer.MIN_VALUE;
                    }else if(len < MAXMINLENGTH){
                        result = Integer.parseInt(resultStr);
                        return result;
                    }else {
                        if(compareBuilderWithMin(resultStr)){
                            result = Integer.parseInt(resultStr);
                            return result;
                        }else {
                            return Integer.MIN_VALUE;
                        }
                    }
                }
            }
        }
        return 0;
    }

    /**
     * 将有效的数字加入到stringBuilder中
     * @param c
     * @param builder
     */
    private void handleDigitToString(char c, StringBuilder builder) {
        if(builder.length() == 0){
            if(c != '0'){
                builder.append(c);
            }
        }else {
            builder.append(c);
        }
    }
    /**
     *
     * @param str
     * @return
     */
    private boolean compareBuilderWithMax(String str) {
        String actualStr = str.substring(0,str.length()-1);
        int actual = Integer.parseInt(actualStr);
        int actualBit = Integer.parseInt(String.valueOf(str.charAt(str.length()-1)));
        if(actual == SECONDMAXMIN){
            if(actualBit == MAXBIT){
                return false;
            }else if(actualBit > MAXBIT){
                return false;
            }else{
                return true;
            }
        } else if (actual > SECONDMAXMIN) {
            return false;
        }else {
            return true;
        }
    }
    /**
     *
     * @param str
     * @return
     */
    private boolean compareBuilderWithMin(String str) {
        int actualBit = Integer.parseInt(String.valueOf(str.charAt(str.length()-1)));
        String actualStr = str.substring(0,str.length()-1);
        int actual = Integer.parseInt(actualStr);
        if(actual == SECONDMAXMIN){
            if(actualBit == MINBIT){
                return false;
            }else if(actualBit > MINBIT){
                return false;
            }else{
                return true;
            }
        }else if(actual > SECONDMAXMIN){
            return false;
        }else{
            return true;
        }
    }

    public static void main(String[] args) {
        MyAtoiV3 myAtoiV3 = new MyAtoiV3();
        //一个字符
        String[]s = {""," ","1","+","-",".","A","a"};
        //二个字符
//        String[]s = {"  "," 2"," +"," -"," ."," A"," a","1 ","12","1+","2-","3.","4A","5a","+ ","- ",". ","+1","-2","++","--","+.","-.","+A","-a"};
        //三个字符
//        String[]s = {"   ","  1","  +","  -","  .","  A","  a"," 1 "," 12"," 1+"," 2-"," 3."," 4A"," 5a","+1 ","-2 ","+123","-234","+1+","-2-","+3A","-4a","+5.","-6."};
        //极限数
//        String[]s = {"2147483647","-2147483648","2147483648","-2147483649","21474836471","2147483657","-21474836481","-2147483668"};
        for(int i = 0 ; i < s.length ; i++){
            int num = myAtoiV3.myAtoi(s[i]);
            System.out.println("原始字符s：" + s[i] + "对应结果是：" + num);
        }
    }
}
