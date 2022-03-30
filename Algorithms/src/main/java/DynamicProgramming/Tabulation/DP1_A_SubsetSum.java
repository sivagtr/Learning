package DynamicProgramming.Tabulation;

/**
 * Subset Sum problem similar to 0/1 Knapsack.
 * Here also we have sum as like bag. For Each element, we can either choose to include or exclude it.
 * So this is similar to knapsack.
 *
 * Here we are taking whether the subset sum will be possible or not.
 * So considering the values as boolean array.
 *
 * Initialization
 * ----------------
 * If there are NO numbers but sum is present then it is false since we can't achieve that sum
 * If numbers are empty but sum is 0, it's true
 *
 * Only exception case, (0,0) --> Where is true with empty set and sum 0;
 *
 * Choice Diagram
 * ----------------
 * Similar to knapsack, instead of getting MAX value we can do simple || condition to measure whether
 * subset can be formed with that sum or not.
 */
public class DP1_A_SubsetSum {
    public static void main(String[] args) {
        DP1_A_SubsetSum DP1ASubsetSum = new DP1_A_SubsetSum();
        int sum = 12;
        int[] values = {1, 3, 5, 6};
        boolean[][] dp = DP1ASubsetSum.containsValidSubset(sum, values);
        for (boolean[] dr : dp) {
            for (boolean d : dr) {
                System.out.print(d + " ");
            }
            System.out.println();
        }
	    System.out.println();
	    System.out.println();
		System.out.println("Final Choice -- Subset can be formed ? -- "+dp[dp.length-1][dp[0].length-1]);
    }

    private boolean[][] containsValidSubset(int sum, int[] values) {
        boolean[][] dp = new boolean[values.length + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                /**
                 * Initializations
                 */
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = false;
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                /**
                 * Choice Diagram
                 */
                if (values[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - values[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp;
    }
}
