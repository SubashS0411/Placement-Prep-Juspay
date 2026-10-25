public class BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
    public static int maxProfit(int[] prices) {
        int buy=prices[0],profit=0;
        for (int price : prices) {
            if (price < buy) buy = price;
            profit = Math.max(profit, price - buy);
        }
        return profit;
    }
}
