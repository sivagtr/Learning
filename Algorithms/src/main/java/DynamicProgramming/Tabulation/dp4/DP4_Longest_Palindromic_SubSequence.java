package DynamicProgramming.Tabulation.dp4;

public class DP4_Longest_Palindromic_SubSequence {
	public static void main(String[] args) {
		DP4_Longest_Palindromic_SubSequence dp4_longest_palindromic_subSequence = new DP4_Longest_Palindromic_SubSequence();
		dp4_longest_palindromic_subSequence.solve();
	}

	private void solve() {

		String x = "agbcderbacbgefjkle";
		/**
		 * Idea : Take reverse of the given string and find LCS between the two. Gives Palindromic Subsequence
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

		int i = dp.length - 1;
		int j = dp[i].length - 1;
		String ans = "";
		while(i > 0 && j > 0) {
			if(x.charAt(i - 1) == x.charAt(x.length() - j)) {
				ans += x.charAt(i - 1);
				i--;
				j--;
			} else {
				if(dp[i - 1][j] > dp[i][j - 1]) {
					i--;
				} else {
					j--;
				}
			}
		}
		System.out.println("Longest Palindromic SubSequence is : " + ans);
	}
}
