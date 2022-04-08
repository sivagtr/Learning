package DynamicProgramming.Tabulation.dp4;

public class DP4_A_Min_No_Delete_Convert_To_Palindrome {
	public static void main(String[] args) {
		DP4_A_Min_No_Delete_Convert_To_Palindrome dp4_a_min_no_delete_convert_to_palindrome = new DP4_A_Min_No_Delete_Convert_To_Palindrome();
		dp4_a_min_no_delete_convert_to_palindrome.solve();
	}

	private void solve() {
		String x = "aebcbda";

		/**
		 * Idea: Perform Longest Palindromic SubSequence(Take reverse and perform LCS) and delete the remaining characters.
		 */
		int[][] dp = new int[x.length() + 1][x.length() + 1];

		for(int i = 1; i < dp.length; i++) {
			for(int j = 1; j < dp[i].length; j++) {
				if(x.charAt(i - 1) == x.charAt(x.length() - j)) {
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
		System.out.println("Longest Palindromic SubSequence count is : " + dp[dp.length - 1][dp[0].length - 1]);
		System.out.println("Minimum No of Deletions to perform -- Palindromic is : " + (x.length() - dp[dp.length - 1][dp[0].length - 1]));
	}
}
