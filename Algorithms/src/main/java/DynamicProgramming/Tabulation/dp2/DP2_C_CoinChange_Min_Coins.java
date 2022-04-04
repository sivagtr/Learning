package DynamicProgramming.Tabulation.dp2;

public class DP2_C_CoinChange_Min_Coins {
	public static void main(String[] args) {
		DP2_C_CoinChange_Min_Coins dp2_c_coinChange_min_coins = new DP2_C_CoinChange_Min_Coins();
		dp2_c_coinChange_min_coins.solve();
	}

	private void solve() {
		int[] coins = {1, 2, 3};
		int requiredSum = 5;

		int[][] dp = new int[coins.length + 1][requiredSum + 1];

		for(int i = 0; i < dp[0].length; i++) {
			dp[0][i] = Integer.MAX_VALUE;
		}

		for(int i = 1; i < dp.length; i++) {
			for(int j = 1; j < dp[i].length; j++) {
				if(coins[i - 1] <= j) {
					dp[i][j] = Math.min(
							1 + (dp[i][j - coins[i - 1]] == Integer.MAX_VALUE ? 0 : dp[i][j - coins[i - 1]]),
							dp[i - 1][j]
					);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		for(int[] d : dp) {
			for(int x : d) {
				System.out.print(x + " ");
			}
			System.out.println();
			System.out.println();
		}
		System.out.println("Min #count is :: " + dp[dp.length - 1][dp[0].length - 1]);
	}
}
