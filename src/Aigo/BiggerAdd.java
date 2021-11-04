package Aigo;

import java.util.Arrays;
import java.util.LongSummaryStatistics;

/**
 *@desprition 大数加法
 *@author zhangshenming
 *@date 2021/9/25 20:58
 *@version 1.0
 */
public class BiggerAdd {
    /**
     *@Description 两个大数相加，末位依次相加，如果有进位，计入数组中
     *@Author zhangshenming
     *@Param str1, str2
     *@Date 2021/9/25 20:59
     *@Return java.lang.String
     */
    public static String add1(String str1, String str2){
        //入参中大数1的长度
        int len1 = str1.length();
        //入参中大数2的长度
        int len2 = str2.length();
        //用来判断特殊情况：1、大数1是空,返回大数2；2、大数2是空，返回大数1；3、两个数都是空，返回空；
        // 4、大数1是0，返回大数2；5、大数2是0,返回大数1；6、两个数都是0，返回字符串0；
        if(len1 == 0 || (len1 == 1 && str1.indexOf(0) == 0)){
            return str2;
        }
        if(len2 == 0 || (len2 == 1 && str2.indexOf(0) == 0)){
            return str1;
        }
        if(len1 == 0 && len2 == 0){
            return "";
        }
        if((len1 == 1 && Character.getNumericValue(str1.charAt(0)) == 0) && (len2 == 1 && Character.getNumericValue(str2.charAt(0)) == 0)){
            return "0";
        }
        //用于判断进位的数
        int a = 0;
        //进位用的数组
        int[]sum = null;
        //用以拼接加法完成之后的数字字符串
        StringBuilder builder = new StringBuilder();
        int k = 0;
        //临时字符串变量，处于一些突发事情
        String tempString = "";
        //两个大数相加的结果；
        StringBuilder result = new StringBuilder();
        //如果入参中第二个字符串长度大于第一个字符串长度，交换两个字符串的位置，永远保证第一个字符串的长度大于第二个字符串的长度
        if(len1 < len2){
            tempString = str2;
            str2 = str1;
            str1 = tempString;
        }
           //应该比较大的字符串的长度
            sum = new int[len1];
            for (int i = len1-1,j = len2-1;i >= 0 && j >= 0;i--,j--){
                if(k >= 1){
                    a = Character.getNumericValue(str1.charAt(i)) + Character.getNumericValue(str2.charAt(j)) + sum[k-1];
                }else{
                    a = Character.getNumericValue(str1.charAt(i)) + Character.getNumericValue(str2.charAt(j));
                }
                    if(a >= 10){
                        sum[k] = 1;
                        a -= 10;
                    }
                k++;
                builder.append(a);
            }
            for(int m = len1-len2-1;m >= 0;m--){
                if(sum[k-1] != 0){
                    a = Character.getNumericValue(str1.charAt(m)) + sum[k-1];
                    if(a >= 10){
                        sum[k] = 1;
                        a -= 10;
                    }
                    k++;
                }else{
                    a = Character.getNumericValue(str1.charAt(m));
                }
                builder.append(a);
            }
            if(sum[k-1] != 0){
                builder.append(1);
            }
        tempString = builder.toString();
        //由于得到的结果是反向的，反转得到的两数相加的结果
        for(int n = tempString.length()-1;n >= 0;n--){
            result.append(Character.getNumericValue(tempString.charAt(n)));
        }
        builder.setLength(0);
        return result.toString();
    }
    /**
     *@Description 改进版的大数加法
     *@Author zhangshenming
     *@Param str1, str2
     *@Date 2021/10/26 10:02
     *@Return java.lang.String
     */
    public static String add2(String str1,String str2){
        //入参中大数1的长度
        int len1 = str1.length();
        //入参中大数2的长度
        int len2 = str2.length();
        //用来判断特殊情况：1、大数1是空,返回大数2；2、大数2是空，返回大数1；3、两个数都是空，返回空；
        // 4、大数1是0，返回大数2；5、大数2是0,返回大数1；6、两个数都是0，返回字符串0；
        if(len1 == 0 || (len1 == 1 && Character.getNumericValue(str1.charAt(0)) == 0)){
            return str2;
        }
        if(len2 == 0 || (len2 == 1 && Character.getNumericValue(str2.charAt(0)) == 0)){
            return str1;
        }
        if(len1 == 0 && len2 == 0){
            return "";
        }
        if((len1 == 1 && Character.getNumericValue(str1.charAt(0)) == 0) && (len2 == 1 && Character.getNumericValue(str2.charAt(0)) == 0)){
            return "0";
        }
        //每位加法得到的数
        int a = 0;
        //用于判断进位的数
        int bit = 0;
        //入参中较长的字符串
        String longString = "";
        //入参中较短的字段串
        String shortString = "";
        //如果入参中第二个字符串长度大于第一个字符串长度，交换两个字符串的位置，永远保证第一个字符串的长度大于第二个字符串的长度
        if(len1 < len2){
            shortString = str1;
            longString = str2;
        }else{
            shortString = str2;
            longString = str1;
        }
        //两个大数相加的结果，用string数组表示
        String[]result = new String[longString.length()];
        //长字符串的实际长度
        int longLength = longString.length()-1;
        //短字符串的实际长度
        int shortLength = shortString.length()-1;
        //应该比较大的字符串的长度
        for(int i = 0;i <= longLength;i++){
            if(i > shortLength){
                a = Character.getNumericValue(longString.charAt(longLength - i)) + bit;
            }else{
                a = Character.getNumericValue(longString.charAt(longLength - i)) + Character.getNumericValue(shortString.charAt(shortLength - i)) + bit;
            }
            if(a >= 10){
                bit = 1;
                a -= 10;
            }else{
                bit = 0; 
            }
            result[longLength-i] = String.valueOf(a);
        }
        StringBuilder builder = new StringBuilder();
        if(bit == 1){
            builder.append(1);
        }
        for(String s:result){
            builder.append(s);
        }
        return builder.toString();
    }
    public static void main(String[] args) {
        //两个大数都“0”
        //第一个大数是“0”，第二个大数是”123“
        //第一个大数是”123“，第二个大数是“0”
        //两个大数都是“”
        //第一个大数是“123”，第二个大数是空
        //第一个大数是空，第二个大数是”123“
        //大数1和大数2的长度不相等，并且大数2的最高位和大数1的对应的位相加需要进位操作.
        //大数1和大数2的长度不相等，并且大数1的最高位需要进位，大数2的最高位和大数1的对应的位相加需要进位操作
        //大数1和大数2的长度相等，并且相加的时候最高位需要进位
        //大数1
        String[]str1 = {"0","0","123","","123","","54978214","99978214","99978214"};
        //大数2
        String[]str2 = {"0","123","0","","","123","43576","43576","99987896"};
        //结果
        String[]result = {"0","123","123","","123","123","55021790","100021790","199966110"};
        //用来接收大数1和大数2的相加的和，用于与结果result比较用的
        String str3 = null;
        for(int i = 0;i < str1.length-1;i++){
//            str3 = add1(str1[i],str2[i]);
            str3 = add2(str1[i],str2[i]);
            if(!result[i].equals(str3)){
                System.out.println("两数相加不是想要的结果"+"大数1，str1："+str1[i]+"大数2："+str2[i]+",结果是："+str3.toString());
            }
        }
    }
}
