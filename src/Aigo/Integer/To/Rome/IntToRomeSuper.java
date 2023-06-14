package Aigo.Integer.To.Rome;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 9:44
 * @Version 1.0.0
 */
public class IntToRomeSuper {
    public Map generateRomeIntMap(){
        Map<Integer,String> map = new HashMap<Integer,String>();
        map.put(1,"I");
        map.put(4,"IV");
        map.put(5,"V");
        map.put(9,"VI");
        map.put(10,"X");
        map.put(40,"XL");
        map.put(50,"L");
        map.put(90,"XC");
        map.put(100,"C");
        map.put(400,"CD");
        map.put(500,"D");
        map.put(900,"DM");
        map.put(1000,"M");
        return map;
    }
    public String intToRoman(int num) {
        return "";
    }
}
