package DynamicProgramming.Tabulation.dp3;

public class DP3_E_Longest_Repeating_SubSequence {
	public static void main(String[] args) {
		DP3_E_Longest_Repeating_SubSequence dp3_e_longest_repeating_subSequence = new DP3_E_Longest_Repeating_SubSequence();
		dp3_e_longest_repeating_subSequence.solve();
	}

	private void solve() {

		String x = "aabbeccdff";
//		String x = "axxxf";

		/**
		 * Idea: abcf --> Should be repeated again in the same string.
		 * So, If we consider 'a' at 0 index, we should consider 'a' in 1 index. Not in 0 index.
		 * It shows there is a character that matches in another index. Means that can be considered and taken.
		 * Rest will be the the same as LCS.
		 */

		int[][] dp = new int[x.length() + 1][x.length() + 1];
		for(int i = 1; i < dp.length; i++) {
			for(int j = 1; j < dp[i].length; j++) {
				if(x.charAt(i - 1) == x.charAt(j - 1) && i != j) {
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

		System.out.println("Longest Repeating SubSequence Count is : " + dp[dp.length - 1][dp[0].length - 1]);
		int i = dp.length - 1;
		int j = dp[i].length - 1;
		String ans = "";
		while(i > 0 && j > 0) {
			if(x.charAt(i - 1) == x.charAt(j - 1) && i != j) {
				ans = x.charAt(i - 1) + ans;
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
		System.out.println("Longest Repeating SubSequence is : " + ans);
	}
}
