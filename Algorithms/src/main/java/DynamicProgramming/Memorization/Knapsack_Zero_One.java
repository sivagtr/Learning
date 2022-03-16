package DynamicProgramming.Memorization;

import java.util.function.Supplier;

public class Knapsack_Zero_One {
    Supplier<Knapsack> knapsackSupplier = () -> {
        Knapsack knapsack = new Knapsack();
        knapsack.weights = new int[]{1, 3, 4, 5};
        knapsack.profits = new int[]{1, 3, 8, 7};
        knapsack.bagCapacity = 7;
        return knapsack;
    };

    private int[][] dp;

    public static void main(String[] args) {
        Knapsack_Zero_One knapsack_zero_one = new Knapsack_Zero_One();
        knapsack_zero_one.performKnapsack();
    }

    public void performKnapsack() {
        Knapsack knapsack = knapsackSupplier.get();
        dp = new int[knapsack.weights.length + 1][knapsack.bagCapacity + 1];
        int maxProfit = findMaxProfitKnapsack(knapsack.weights, knapsack.profits, knapsack.bagCapacity, knapsack.weights.length);
        System.out.println("Max Profit is " + maxProfit);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    private int findMaxProfitKnapsack(int[] weights, int[] profits, int bagCapacity, int length) {
        if (length == 0 || bagCapacity == 0) return 0;
        if (weights[length - 1] <= bagCapacity) {
            return dp[length][bagCapacity] = Math.max(
                    profits[length - 1] + findMaxProfitKnapsack(weights, profits, bagCapacity - weights[length - 1], length - 1),
                    findMaxProfitKnapsack(weights, profits, bagCapacity, length - 1)
            );
        } else {
            return dp[length][bagCapacity] = findMaxProfitKnapsack(weights, profits, bagCapacity, length - 1);
        }
    }

    private class Knapsack {
        public int[] weights;
        public int[] profits;
        public int bagCapacity;
    }
}
