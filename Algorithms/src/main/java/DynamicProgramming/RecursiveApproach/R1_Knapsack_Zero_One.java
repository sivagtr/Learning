package DynamicProgramming.RecursiveApproach;

import java.util.function.Supplier;

public class R1_Knapsack_Zero_One {

    Supplier<Knapsack> knapsackSupplier = () -> {
        Knapsack knapsack = new Knapsack();
        knapsack.weights = new int[]{1, 3, 4, 5};
        knapsack.profits = new int[]{1, 3, 8, 7};
        knapsack.bagCapacity = 7;
        return knapsack;
    };

    public static void main(String[] args) {
        R1_Knapsack_Zero_One r1Knapsack_zero_one = new R1_Knapsack_Zero_One();
        r1Knapsack_zero_one.performKnapsack();
    }

    public void performKnapsack() {
        Knapsack knapsack = knapsackSupplier.get();
        int maxProfit = findMaxProfitKnapsack(knapsack.weights, knapsack.profits, knapsack.bagCapacity, knapsack.weights.length);
        System.out.println("Max Profit is " + maxProfit);
    }

    private int findMaxProfitKnapsack(int[] weights, int[] profits, int bagCapacity, int length) {
        /**
         * Base Condition
         */
        if (length == 0 || bagCapacity == 0) return 0;
        /**
         * Choice Diagram
         */
        // Consider Since weight less than the bag capacity
        if (weights[length - 1] <= bagCapacity) {
            return Math.max(
                    // Consider that weight
                    profits[length - 1] + findMaxProfitKnapsack(weights, profits, bagCapacity - weights[length - 1], length - 1),
                    // Don't consider that weight
                    findMaxProfitKnapsack(weights, profits, bagCapacity, length - 1));
        } else {
            // Negative scenario
            return findMaxProfitKnapsack(weights, profits, bagCapacity, length - 1);
        }
    }

    private class Knapsack {
        public int[] weights;
        public int[] profits;
        public int bagCapacity;
    }
}
