package DynamicProgramming.Tabulation.dp4;

public class DP4_B_Min_No_Insertion_Convert_To_Palindrome {
	public static void main(String[] args) {
		DP4_B_Min_No_Insertion_Convert_To_Palindrome dp4_b_min_no_insertion_convert_to_palindrome = new DP4_B_Min_No_Insertion_Convert_To_Palindrome();
		dp4_b_min_no_insertion_convert_to_palindrome.solve();
	}

	private void solve() {

		String x = "aebcbda";

		/**
		 * Idea: Find the Longest Palindromic SubSequence (by checking with reverse string)
		 * Then length - lps gives min no of insertions.
		 */

		int[][] dp = new int[x.length() + 1][x.length() + 1];
		for(int i = 1; i < dp.length; i++) {
			for(int j = 1; j < dp[i].length; j++) {
				if(x.charAt(i - 1) == x.charAt(x.length() - i)) {
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
		System.out.println("Minimum no of Insertions to make the Palindrome is : " + (x.length() - dp[dp.length - 1][dp[0].length - 1]));
	}
}
