package DynamicProgramming.Tabulation.dp1;

import java.util.function.Supplier;

/**
 * Choice Diagram for 0/1 Knapsack
 *
 *                      i element
 *                      /\
 *                     /  \
 *                    /    \
 *                 i <= W  i > W
 *                    /\     |
 *                   √  X    X
 *         (Include) (Not Include)  (Not Include)
 *
 * Here, for entire choice diagram we just process element once by passing {n-1} or to say {i-1}
 */
public class DP1_Knapsack_Zero_One {

    Supplier<Knapsack> knapsackSupplier = () -> {
        Knapsack knapsack = new Knapsack();
        knapsack.weights = new int[]{1, 3, 4, 5};
        knapsack.profits = new int[]{1, 3, 8, 7};
        knapsack.bagCapacity = 8;
        return knapsack;
    };
    private int[][] dp;

    public static void main(String[] args) {
        DP1_Knapsack_Zero_One knapsack_zero_one = new DP1_Knapsack_Zero_One();
        knapsack_zero_one.performKnapsack();
    }

    public void performKnapsack() {
        Knapsack knapsack = knapsackSupplier.get();
        dp = new int[knapsack.weights.length + 1][knapsack.bagCapacity + 1];
        findMaxProfitKnapsack(knapsack.weights, knapsack.profits);

        /**
         * Printing the matrix
         */
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++)
                System.out.print(dp[i][j] + " ");
            System.out.println();
        }
    }

    private void findMaxProfitKnapsack(int[] weights, int[] profits) {

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                /**
                 * Base Condition -- To Initialization
                 */
                if (i == 0 || j == 0) {
                    continue;
                }
                /**
                 * Choice Diagram -- Iterative Approach
                 */
                // Consider Since weight less than the bag capacity
                if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(
                            // Consider that weight
                            (profits[i - 1] + dp[i - 1][j - weights[i - 1]]),
                            // Don't consider that weight
                            dp[i - 1][j]);
                } else {
                    // Negative scenario
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
    }

    private class Knapsack {
        public int[] weights;
        public int[] profits;
        public int bagCapacity;
    }
}
