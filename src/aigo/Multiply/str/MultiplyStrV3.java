package aigo.Multiply.str;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/22 19:22
 * @Version 1.0.0
 */
public class MultiplyStrV3 extends MultiplyStrSuper{
    public String multiply(String num1, String num2) {
        //如果num1或者num2中有一个为0的话，直接返回0
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') {
            return "0";
        }
        //交换两个字符串长度
//        swapString(num1,num2);
        if (num2.length() > num1.length()) {
            String tempStr = num1;
            num1 = num2;
            num2 = tempStr;
        }
        //大字符串对应的数组array1
        int[] array1 = convertToArray(num1);
        //小字符串对应的数组array2
        int[] array2 = convertToArray(num2);
        //乘法结果数组
        int[][] result = new int[num2.length()][num1.length() + num2.length()];
        result = bigMultiply(array1, array2, result);
        //加法结果数组
        int[] sum = new int[result[0].length];
        sum = bigAdd(result, sum);
        return transferArrayToString(sum);
    }
    /**
     * 大数乘法
     * @param array1
     * @param array2
     * @return
     */
    private int[][] bigMultiply(int[] array1, int[] array2, int[][] result) {
        //两个数字乘积
        int multiplying = 0;
        //乘法进位数字
        int tempForMultiply = 0;
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array1.length; j++) {
                multiplying = array1[j] * array2[i];
                multiplying += tempForMultiply;
                if (multiplying >= 10) {
                    tempForMultiply = multiplying / 10;
                    multiplying = multiplying - 10 * tempForMultiply;
                } else {
                    tempForMultiply = 0;
                }
                result[i][i + j] = multiplying;
            }
            if (tempForMultiply != 0) {
                result[i][array1.length + i] = tempForMultiply;
                tempForMultiply = 0;
            }
        }
        if (tempForMultiply != 0) {
            result[array2.length - 1][array1.length + array2.length - 1] = tempForMultiply;
        }
        return result;
    }

    /**
     * 交换两个字符串，保证nums1得长度永远大于nums2
     * @param num1
     * @param num2
     */
    private void swapString(String num1, String num2) {
        //保证num1 >= num2
        if (num2.length() > num1.length()) {
            String tempStr = num1;
            num1 = num2;
            num2 = tempStr;
        }
    }

    /**
     * 大数加法
     * @param result
     * @return
     */
    private int[] bigAdd(int[][] result,int[]sum) {
        //加法进位数字
        int tempForAdd = 0;
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                sum[j] += result[i][j];
                if (sum[j] == 0) {
                    continue;
                }
            }
        }
        for(int  k = 0 ; k < sum.length ; k++){
            sum[k] += tempForAdd;
            if (sum[k] >= 10) {
                tempForAdd = sum[k] / 10;
                sum[k] = sum[k] % 10;
            } else {
                tempForAdd = 0;
            }
        }
        if (tempForAdd != 0) {
            sum[sum.length - 1] = sum[sum.length - 1] + tempForAdd;
        }
        return sum;
    }

    /**
     * 将结果数组转换成字符串并返回
     * @param sum
     * @return
     */
    private String transferArrayToString(int[] sum) {
        int index = 0;
        for (int i = sum.length - 1; i >= 0; i--) {
            if (sum[i] != 0) {
                index = i;
                break;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int j = index; j >= 0; j--) {
            builder.append(sum[j]);
        }
        return builder.toString();
    }

    /**
     * 将字符串转成数组并返回
     *
     * @param num
     * @return
     */
    private int[] convertToArray(String num) {
        int[] array = new int[num.length()];
        for (int i = num.length() - 1, index = 0; i >= 0; i--, index++) {
            array[index] = num.charAt(i) - '0';
        }
        return array;
    }

    public static void main(String[] args) {
        //"6"
//        String num1 = "2";
//        String num2 = "3";
        //"56088"
//        String num1 = "123";
//        String num2 = "456";
        //"891"
//        String num1 = "9";
//        String num2 = "99";
        //"0"
//        String num1 = "9133";
//        String num2 = "0";
        //"121932631112635269"
        String num1 = "123456789";
        String num2 = "987654321";
        //998001
//        String num1 = "999";
//        String num2 = "999";
        MultiplyStrV3 multiplyStringV3 = new MultiplyStrV3();
        String s = multiplyStringV3.multiply(num1, num2);
        System.out.println(s);
//        int[]array1 = multiplyStringV2.convertToArray(num1);
//        for (int i = 0 ; i < array1.length ; i++) {
//            System.out.println(array1[i]);
//        }
//        int[]array2 = multiplyStringV2.convertToArray(num2);
//        for (int i = 0; i < array2.length ; i++) {
//            System.out.println(array2[i]);
//        }
    }
}
