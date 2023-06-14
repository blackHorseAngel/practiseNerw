package Aigo.Max.Profits;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 12:54
 * @Version 1.0.0
 */
public class MaxProfitV2 extends MaxProfitSuper{
    //动态规划
    public int maxProfit2(int[]prices){
        if(prices.length == 1){
            return 0;
        }
        int[]dp = new int[prices.length];
        int max = 0;
        int minPrice = prices[0];
        for(int i = 0 ; i < prices.length; i++){
            minPrice = Math.min(minPrice,prices[i]);
            dp[i] = Math.max(prices[i] - minPrice,max);
            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        MaxProfitV2 maxProfitV2 = new MaxProfitV2();
//        int[]prices = {1};
        int[]prices = {1,2};
//        int[]prices = {2,1};
//        int[]prices = {1,1};
//        int[]prices = {7,1,5,3,6,4};
//        int[]prices = {7,6,4,3,1};
        int result = maxProfitV2.maxProfit2(prices);
        System.out.println(result);
    }
}
