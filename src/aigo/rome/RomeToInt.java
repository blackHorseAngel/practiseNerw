package aigo.rome;

import java.util.HashMap;
import java.util.Map;

import static aigo.rome.RomeToIntegerSuper.generateMap;

/**
 * @Description https://leetcode.cn/problems/roman-to-integer
 * 罗马数字包含以下七种字符:I，V，X，L，C，D和M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做II，即为两个并列的 1 。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给定一个罗马数字，将其转换成整数。
 * 输入: s = "III"
 * 输出: 3
 * 输入: s = "IV"
 * 输出: 4
 * 输入: s = "IX"
 * 输出: 9
 * 输入: s = "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 输入: s = "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * @Author Administrator
 * @Date 2023/5/18 23:15
 * @Version 1.0.0
 */
public class RomeToInt {
    /**
     *
     * @param s
     * @return
     */
    public int romeToInt(String s) {
        Map<String,Integer>romanMap = new HashMap<>();
        romanMap = generateMap();
        int result = 0;
        for(int i = 0 ; i < s.length() ; i++){
            String romanStr1 = String.valueOf(s.charAt(i));
            String romanStr2 = "";
            if(i+1 <= s.length()-1){
                romanStr2 = String.valueOf(s.charAt(i+1));
            }
            String newRomanStr = romanStr1 + romanStr2;
            if(romanMap.containsKey(newRomanStr)){
                result += romanMap.get(newRomanStr);
                i++;
            }else{
                result += romanMap.get(romanStr1);
            }
        }
        return result;
    }
    public static void main(String[] args) {
       //3
//        String s1 =  "III";
        //4
//        String s2 = "IV";
        //9
//        String s3 = "IX";
        //58
//        String s4 = "LVIII";
        //1994
//        String s5 = "MCMXCIV";
        //3045
//        String s6 = "MMMXLV";
//        RomeToInt romeToInt = new RomeToInt();
//        int a1 = romeToInt.romeToInt(s1);
//        System.out.println(a1);
//        int a2 = romeToInt.romeToInt(s2);
//        System.out.println(a2);
//        int a3 = romeToInt.romeToInt(s3);
//        System.out.println(a3);
//        int a4 = romeToInt.romeToInt(s4);
//        System.out.println(a4);
//        int a5 = romeToInt.romeToInt(s5);
//        System.out.println(a5);
//        int a6 = romeToInt.romeToInt(s6);
//        System.out.println(a6);

        String[]str = {"III","IV","IX","LVIII","MCMXCIV","MMMXLV"};
        for(int i = 0 ; i < str.length ; i++){
            RomeToInt romeToInt = new RomeToInt();
            System.out.println(romeToInt.romeToInt(str[i]));
        }
    }

}
