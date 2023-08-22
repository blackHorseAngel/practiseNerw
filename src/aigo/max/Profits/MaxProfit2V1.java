package aigo.max.Profits;

/**
 * @Description  https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii
 * 给你一个整数数组 prices ，其中prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润。
 *输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
 *  总利润为 4 + 3 = 7 。
 *
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 * 总利润为 4 。
 *
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。
 * 1 <= prices.length <= 3 * 104
 * 0 <= prices[i] <= 104
 *
 * @Author Administrator
 * @Date 2023/5/18 14:42
 * @Version 1.0.0
 */
public class MaxProfit2V1 extends MaxProfitSuper {
    /**
     * 首先确认手上是否有股票，先进行上升或下降趋势的判断，如果是上升趋势且没有股票，那么第一个点即是买入点，找到买入点后，手上有股票了，马上再找卖出点；如果是下降趋势，那么直接寻找卖出点；如果有股票，那么寻找卖出点。
     * 刚一开始，假设手上没有股票
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        //如果只有一个数，直接返回0
        if(prices.length == 1){
            return 0;
        }
        //手上没有股票
        boolean hasStock = false;
        //买入价格
        int buyingPrice = -1;
        //卖出价格
        int sellingPrice = -1;
        //初始化利润
        int profit = 0;
        //用来接收判断趋势的结果：result[0]:上升/下降,如果是上升趋势，result[0] = 1,如果是下降趋势，result[0] = -1; result[1]:趋势变化开始的那天
        int[]result = new int[2];
        //判断当前股票的趋势
        result = findTendency(prices);
        if(result[0] > 0){
            buyingPrice = prices[result[1]];
            hasStock = true;
        }
        //初始化天数
        int day = result[1] + 1;
        while(day < prices.length){
            //有股票hasStock为true，寻找卖出点并卖出，计算利润，调整hasStock为false
            if(hasStock){
               int newDay = findSellingPoint(prices,day);
               if(newDay != -1){
                   sellingPrice = prices[newDay];
                   profit += sellingPrice - buyingPrice;
                   hasStock = false;
                   day = newDay;
               }else{
                   break;
               }
            //没有股票hasStock为false，寻找买入点并买入，计算利润，调整hasStock为true
            }else{
                int newDay = findBuyingPoint(prices,day);
                if(newDay != -1 ){
                    buyingPrice = prices[newDay];
                    hasStock = true;
                    day = newDay;
                }else{
                    break;
                }
            }
            day++;
        }
        return profit;
    }

    /**
     * 判断股票的上升或下降的趋势
     * @param prices
     * @return
     */

    private int[] findTendency(int[] prices) {
        //如果是上升趋势，result[0] = 1,如果是下降趋势，result[0] = -1;result[1]表示的是趋势变化的那个时间点对于的天数
        int[]result = new int[2];
        for(int i = 0 ; i < prices.length ; i++){
            if (i + 1 < prices.length) {
                //找到第一次下降趋势并记录返回
                if(prices[i] > prices[i + 1]){
                    result[0] = -1;
                    result[1] = i;
                    return result;
                 //找到第一次上升趋势并记录返回
                }else if(prices[i] < prices[i + 1]){
                    result[0] = 1;
                    result[1] = i;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * 寻找买入点，首先确定目前的股票走向趋势是下降趋势，然后找到后面的点的数据大于前面点的数据的那个点。
     * @param prices
     * @param day
     * @return
     */
    private int findBuyingPoint(int[] prices, int day) {
        for(int i = day ; i < prices.length ; i++){
            if(i + 1 < prices.length) {
                if (prices[i] < prices[i + 1]) {
                   return i;
                }
            }
        }
        return -1;
    }

    /**
     * 寻找卖出点，首先确定目前的股票走向趋势是上升趋势，然后找到后面的点的数据小于前面点的数据的那个点
     * @param prices
     * @return
     */
    private int findSellingPoint(int[] prices,int day) {
        for(int i = day ; i < prices.length ; i++){
            if(i + 1 < prices.length){
                if(prices[i] > prices[i + 1]){
                    //找到了卖出点
                    return i;
                 }
            }else{
                //没有找到卖出点，但是已经到最后的一个点了，所以需要卖出
                return i;
            }
        }
        //没有找到卖出点
        return -1;
    }

    public static void main(String[] args) {
        int[][]num = new int[][] {
                {1, 2, 3},
                {2, 3, 4},
                {3, 3, 3}
        };
        //7
        int[]prices1 = {7,1,5,3,6,4};
        num[0] =prices1;
        //4
        int[]prices2 = {1,2,3,4,5};
        //0
        int[]prices3 = {7,6,4,3,1};
        //15
        int[]prices4 = {8,6,4,3,3,2,3,5,8,3,8,2,6};
        MaxProfit2V1 maxProfit2V1 = new MaxProfit2V1();
        int maxProfit = maxProfit2V1.maxProfit(prices1);
        System.out.println(maxProfit);
    }
}
