package org.hryciuk.stayinshape.data_structures.array;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int maxPrice = prices[0];
        int minPrice = prices[0];
        int minPriceIndex = 0;

        int result = 0;

        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                minPriceIndex = i;
                maxPrice = prices[i];
            }
            if (prices[i] > minPrice && i >= minPriceIndex && prices[i] > maxPrice) {
                maxPrice = prices[i];
                result = Math.max(maxPrice - minPrice, result);
            }
        }

        return result == 0 ? maxPrice - minPrice : result;
    }

}
