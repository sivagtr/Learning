package DynamicProgramming.Tabulation;

/**
 * Unbounded Knapsack --> Allow to choose the same element multiple times.
 *
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
 *
 * For Unbounded Knapsack, we need to re-process even if we consider the choice to include.
 * If not included, then we don't need to reprocess it again.
 * This is similar to wanting a Item --> Yes means we can consider it for round 2
 *                                       No means there is no point in asking again the same item.
 *
 * For including the same element again we just need to provide it from {i} instead of {i-1}
 *
 */
public class DP2_UnBoundedKnapsack {
	public static void main(String[] args) {
		DP2_UnBoundedKnapsack dp2_unBoundedKnapsack = new DP2_UnBoundedKnapsack();
		dp2_unBoundedKnapsack.solve();
	}

	private void solve() {

		int[] weight = {1, 3, 2, 4, 5, 2};
		int[] profit = {1, 3, 13, 8, 7, 11};
		int bagCapacity = 9;

		int[][] dp = new int[weight.length + 1][bagCapacity + 1];
		for(int i = 1; i < dp.length; i++) {
			for(int j = 1; j < dp[i].length; j++) {
				if(weight[i - 1] <= j) {
					dp[i][j] = Math.max(profit[i - 1] + dp[i][j - weight[i - 1]], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		for(int i = 0; i < dp.length; i++) {
			for(int j = 0; j < dp[i].length; j++)
				System.out.print(dp[i][j] + " ");
			System.out.println();
		}
		System.out.println();
		System.out.println("Max Profit : " + dp[dp.length - 1][dp[0].length - 1]);
	}
}
