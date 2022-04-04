package DynamicProgramming.Tabulation.dp2;

public class DP2_A_RodCutting {
	public static void main(String[] args) {
		DP2_A_RodCutting dp2_a_rodCutting = new DP2_A_RodCutting();
		dp2_a_rodCutting.solve();
	}

	private void solve() {
		int[] length = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
		int n = 10;

		int[][] dp = new int[length.length + 1][n + 1];
		for(int i = 1; i < dp.length; i++) {
			for(int j = 1; j < dp[i].length; j++) {
				if(length[i - 1] <= j) {
					dp[i][j] = Math.max(price[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		System.out.println("Max Profit : " + dp[dp.length - 1][dp[0].length - 1]);
	}
}
