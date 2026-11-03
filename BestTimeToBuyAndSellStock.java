public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null) {
            throw new IllegalArgumentException("Prices must not be null");
        }

        int lowestPrice = Integer.MAX_VALUE;
        int maximumProfit = 0;
        for (int price : prices) {
            if (price < 0) {
                throw new IllegalArgumentException("Prices must not be negative");
            }
            lowestPrice = Math.min(lowestPrice, price);
            maximumProfit = Math.max(maximumProfit, price - lowestPrice);
        }
        return maximumProfit;
    }
}
