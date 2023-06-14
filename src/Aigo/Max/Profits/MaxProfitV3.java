package Aigo.Max.Profits;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 12:55
 * @Version 1.0.0
 */
public class MaxProfitV3 extends MaxProfitSuper{
    //数组遍历
    public int maxProfit(int[]prices){
        if(prices.length == 1){
            return 0;
        }
        int temp = 0;
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < prices.length ; i++){
            for(int j = prices.length - 1 ; j > 0 ; j--){
                if(j > i){
                    temp = prices[j]-prices[i];
                    set.add(temp);
                }
            }
        }
        for(int j:set){
            max = Math.max(j,max);
        }
        return max;
    }
    public static void main(String[] args) {
        MaxProfitV3 maxProfitV3 = new MaxProfitV3();
//        int[]prices = {1};
        int[]prices = {1,2};
//        int[]prices = {2,1};
//        int[]prices = {1,1};
//        int[]prices = {7,1,5,3,6,4};
//        int[]prices = {7,6,4,3,1};
        int result = maxProfitV3.maxProfit(prices);
        System.out.println(result);
    }
}
