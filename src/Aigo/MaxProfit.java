package Aigo;

import java.util.*;

/**
 * @Description https://leetcode.cn/problems/best-time-to-buy-and-sell-stock
 * 给定一个数组 prices ，它的第i个元素prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 *
 * @Author Administrator
 * @Date 2023/2/27 22:12
 * @Version 1.0.0
 */
public class MaxProfit {
    //二维数组
    public static int maxProfit(int[] prices) {
        if(prices.length == 1){
            return 0;
        }
        int[][]matrix = getPriceMatrix(prices);
        int max = matrix[0][1];
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = i + 1 ; j < matrix.length ; j++){
                max = Math.max(matrix[i][j],max);
            }
        }
        return max > 0 ? max : 0;
    }
    public static int[][]getPriceMatrix(int[]prices){
        int length = prices.length;
        int[][]matrix = new int[length][length];
        for(int i = 0 ; i < prices.length ; i++){
            for(int j = i + 1 ; j < prices.length ; j++){
                matrix[i][j] = prices[j] - prices[i];
                }
            }
        return matrix;
        }
        //动态规划
    public static int maxProfit2(int[]prices){
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
    //数组遍历
    public static int maxProfit3(int[]prices){
        if(prices.length == 1){
            return 0;
        }
        int temp = 0;
        int max = 0;
        Set<Integer>set = new HashSet<>();
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
//        int[]prices = {1};
        int[]prices = {1,2};
//        int[]prices = {2,1};
//        int[]prices = {1,1};
//        int[]prices = {7,1,5,3,6,4};
//        int[]prices = {7,6,4,3,1};
        int result = maxProfit2(prices);
        System.out.println(result);
    }
}
