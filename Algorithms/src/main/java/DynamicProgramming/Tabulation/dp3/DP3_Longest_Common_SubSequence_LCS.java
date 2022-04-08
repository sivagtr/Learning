package DynamicProgramming.Tabulation.dp3;

public class DP3_Longest_Common_SubSequence_LCS {
	public static void main(String[] args) {
		DP3_Longest_Common_SubSequence_LCS dp3_longest_common_subSequence_lcs = new DP3_Longest_Common_SubSequence_LCS();
		dp3_longest_common_subSequence_lcs.solve();
	}

	private void solve() {
		String x = "abcdef";
		String y = "abefdeffe";

		int[][] dp = new int[x.length() + 1][y.length() + 1];

		for(int i = 1; i < dp.length; i++) {
			for(int j = 1; j < dp[i].length; j++) {
				if(x.charAt(i - 1) == y.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		for(int[] d : dp) {
			for(int t : d) {
				System.out.print(t + " ");
			}
			System.out.println();
		}
		System.out.println("Longest Common SubSequence count is : " + dp[dp.length - 1][dp[0].length - 1]);
	}
}
