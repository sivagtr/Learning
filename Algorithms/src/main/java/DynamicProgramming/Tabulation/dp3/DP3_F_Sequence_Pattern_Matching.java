package DynamicProgramming.Tabulation.dp3;

public class DP3_F_Sequence_Pattern_Matching {
	public static void main(String[] args) {
		DP3_F_Sequence_Pattern_Matching dp3_f_sequence_pattern_matching = new DP3_F_Sequence_Pattern_Matching();
		dp3_f_sequence_pattern_matching.solve();
	}

	private void solve() {
		String x = "abcd";
		String y = "xiwnaiwdfubvsdfincweihg";

		/**
		 * Find whether string x is a subsequence of string y
		 * Idea : Perform LCS and check the length should be same as the string x
		 */

		int[][] dp = new int[x.length() + 1][y.length() + 1];
		for(int i = 1; i < dp.length; i++) {
			for(int j = 1; j < dp[i].length; j++) {
				if(x.charAt(i - 1) == y.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		for(int[] d : dp) {
			for(int t : d) {
				System.out.print(t + " ");
			}
			System.out.println();
		}
		System.out.println("Is x subsequence of y : " + (x.length() == dp[dp.length - 1][dp[0].length - 1]));
	}
}
