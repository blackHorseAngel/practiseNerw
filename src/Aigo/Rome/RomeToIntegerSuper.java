package Aigo.Rome;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 14:10
 * @Version 1.0.0
 */
public class RomeToIntegerSuper {
    /**
     *
     * @return
     */
    public static Map<String, Integer> generateMap() {
        Map<String,Integer>map = new HashMap<>();
        map.put("I",1);
        map.put("IV",4);
        map.put("V",5);
        map.put("IX",9);
        map.put("X",10);
        map.put("XL",40);
        map.put("L",50);
        map.put("XC",90);
        map.put("C",100);
        map.put("CD",400);
        map.put("D",500);
        map.put("CM",900);
        map.put("M",1000);
        return map;
    }
    public int romanToInt(String s) {
        return 0;
    }
}
