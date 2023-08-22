package aigo.max.Profits;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 12:58
 * @Version 1.0.0
 */
public class MaxProfit2V2 extends MaxProfitSuper{

    /**
     * 假设手上没有股票，无需先判断上升或下降趋势，直接寻找买入点，找到买入点后，即手上有股票了，马上寻找卖出点；如果手上有股票的时候，那么马上寻找卖出点
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
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
        //初始化天数
        int day = 0;
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
        MaxProfit2V2 maxProfit2V2 = new MaxProfit2V2();
        int maxProfit = maxProfit2V2.maxProfit(prices1);
        System.out.println(maxProfit);
    }
}
