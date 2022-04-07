package DynamicProgramming.Tabulation.dp3;

public class DP3_A_Longest_Common_SubString {
	public static void main(String[] args) {
		DP3_A_Longest_Common_SubString dp3_a_longest_common_subString = new DP3_A_Longest_Common_SubString();
		dp3_a_longest_common_subString.solve();
	}

	private void solve() {
		String x = "abcedfgshd";
		String y = "dcdcedfsh";
		int max = Integer.MIN_VALUE;
		int[][] dp = new int[x.length() + 1][y.length() + 1];
		for(int i = 1; i < dp.length; i++) {
			for(int j = 1; j < dp[i].length; j++) {
				if(x.charAt(i - 1) == y.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
					max = Math.max(max, dp[i][j]);
				} else {
					dp[i][j] = 0;
				}
			}
		}
		for(int[] d : dp) {
			for(int t : d) {
				System.out.print(t + " ");
			}
			System.out.println();
		}
		System.out.println("Longest Common SubString length is : " + max);
	}
}
