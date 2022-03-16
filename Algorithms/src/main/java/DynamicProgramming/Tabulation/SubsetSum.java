package DynamicProgramming.Tabulation;

public class SubsetSum {
    public static void main(String[] args) {
        SubsetSum subsetSum = new SubsetSum();
        int sum = 9;
        int[] values = {1, 3, 5, 6};
        boolean[][] dp = subsetSum.containsValidSubset(sum, values);
        for (boolean[] dr : dp) {
            for (boolean d : dr) {
                System.out.print(d + " ");
            }
            System.out.println();
        }
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
