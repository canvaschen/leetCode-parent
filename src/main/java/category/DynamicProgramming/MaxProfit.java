package category.DynamicProgramming;

/**
 * @author yzchen
 * @create 2019-12-09
 * @desc
 *
 * 股票的最佳买卖时机
 *
 **/
public class MaxProfit {

    /** 我们需要找出给定数组中两个数字之间的最大差值（即，最大利润）。此外，第二个数字（卖出价格）必须大于第一个数字 **/
    public int maxProfit(int[] prices) {

        // 暴力法
        // 不太适合使用 动态规划 ... 重复的子循环
        int length = prices.length;
        int max=0;
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                if(prices[j]-prices[i] > max){
                    max = prices[j]-prices[i];
                }
            }
        }
        return max;
    }

}
