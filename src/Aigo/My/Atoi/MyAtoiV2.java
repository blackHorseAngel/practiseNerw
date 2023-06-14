package Aigo.My.Atoi;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/8 16:21
 * @Version 1.0.0
 */
public class MyAtoiV2 extends MyAtoiSuper{
    //开始状态
    public static final int BEGIN = 0;
    //读取空格状态
    public static final int SPACE = 1;
    //读取符号状态
    public static final int SYMBOL = 2;
    //读取数字状态
    public static final int NUMBER = 3;

    //整数最大值的字符串2147483647
    public static final String MAX = String.valueOf(Integer.MAX_VALUE);
    //整数最小值的字符串22147483648
    public static final String MIN = String.valueOf(Integer.MIN_VALUE);
    @Override
    public int myAtoi(String s) {
        if(s.length() == 0){
            return 0;
        }
        int state = BEGIN;
        int flag= 0;
        int result = 0;
        StringBuilder builder = new StringBuilder();
        char[]chars = s.toCharArray();
        for(int i = 0 ; i < chars.length ; i++) {
            char c = chars[i];
            switch (state) {
                case BEGIN:
                case SPACE:
                    if(Character.isWhitespace(c)){
                        state = SPACE;
                        continue;
                    } else if (Character.isDigit(c)) {
                        flag = 1;
                        if(c != '0'){
                            builder.append(c);
                        }
                        state = NUMBER;
                        continue;
                    } else if (c == '+') {
                        flag = 1;
                        state = SYMBOL;
                        continue;
                    }else if(c == '-'){
                        flag = -1;
                        state = SYMBOL;
                        continue;
                    }else{
                        break;
                    }
                case SYMBOL:
                    if(Character.isDigit(c)){
                        state = NUMBER;
                        handleDigitToString(c,builder);
                        continue;
                    }else {
                        break;
                    }
                case NUMBER:
                  if (Character.isDigit(c)) {
                        handleDigitToString(c,builder);
                        state = NUMBER;
                        continue;
                    } else {
                      break;
                    }
            }
            break;
        }
        String resultStr = builder.toString();
        int length = resultStr.length();
        if(length == 0){
            return 0;
        }else{
            if (flag > 0){
                if(length > MAX.length()){
                    return Integer.MAX_VALUE;
                }else if(length < MAX.length()){
                    result = Integer.parseInt(resultStr);
                }else{
                    if(compareBuilderWithMax(resultStr)){
                        result = Integer.parseInt(resultStr);
                    }else{
                        return Integer.MAX_VALUE;
                    }
                }
            }else if(flag < 0){
                if(length > MIN.length() - 1){
                    return Integer.MIN_VALUE;
                } else if (length < MIN.length() - 1) {
                    result = Integer.parseInt(resultStr) * flag;
                }else{
                    if(compareBuilderWithMin(resultStr)){
                        result = Integer.parseInt(resultStr) * flag;
                    }else{
                        return Integer.MIN_VALUE;
                    }
                }
            }else{
                return 0;
            }
        }
        return result;
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
    private boolean compareBuilderWithMin(String str) {
        int secondMin = Integer.MIN_VALUE/10 * (-1);
        int minBit = 8;
        int actualBit = Integer.parseInt(String.valueOf(str.charAt(str.length()-1)));
        String actualStr = str.substring(0,str.length()-1);
        int actual = Integer.parseInt(actualStr);
        if(actual == secondMin){
            if(actualBit == minBit){
                return false;
            }else if(actualBit > minBit){
                return false;
            }else{
                return true;
            }
        }else if(actual > secondMin){
            return false;
        }else{
            return true;
        }
    }

    /**
     *
     * @param str
     * @return
     */
    private boolean compareBuilderWithMax(String str) {
        int secondMax = Integer.MAX_VALUE/10;
        int maxBit = 7;
        String actualStr = str.substring(0,str.length()-1);
        int actual = Integer.parseInt(actualStr);
        int actualBit = Integer.parseInt(String.valueOf(str.charAt(str.length()-1)));
        if(actual == secondMax){
            if(actualBit == maxBit){
                return false;
            }else if(actualBit > maxBit){
                return false;
            }else{
                return true;
            }
        } else if (actual > secondMax) {
            return false;
        }else {
            return true;
        }
    }

    public static void main(String[] args) {
        MyAtoiV2 myAtoiV2 = new MyAtoiV2();
        //一个字符
//        String[]s = {""," ","1","+","-",".","A","a"};
        //二个字符
//        String[]s = {"  "," 2"," +"," -"," ."," A"," a","1 ","12","1+","2-","3.","4A","5a","+ ","- ",". ","+1","-2","++","--","+.","-.","+A","-a"};
        //三个字符
//        String[]s = {"   ","  1","  +","  -","  .","  A","  a"," 1 "," 12"," 1+"," 2-"," 3."," 4A"," 5a","+1 ","-2 ","+123","-234","+1+","-2-","+3A","-4a","+5.","-6."};
        //极限数
//        String[]s = {"2147483647","-2147483648","2147483648","-2147483649","21474836471","2147483657","-21474836481","-2147483668"};
//        for(int i = 0 ; i < s.length ; i++){
//            int num = myAtoiV2.myAtoi(s[i]);
//            System.out.println("原始字符s：" + s[i] + "对应结果是：" + num);
//        }
        System.out.println(myAtoiV2.myAtoi("-000000000000001"));
    }
}
