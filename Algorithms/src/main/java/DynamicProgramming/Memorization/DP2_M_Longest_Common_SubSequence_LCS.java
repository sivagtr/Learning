package DynamicProgramming.Memorization;

import java.util.Arrays;

public class DP2_M_Longest_Common_SubSequence_LCS {
	public static void main(String[] args) {
		DP2_M_Longest_Common_SubSequence_LCS dp2_m_longest_common_subSequence_lcs = new DP2_M_Longest_Common_SubSequence_LCS();
		dp2_m_longest_common_subSequence_lcs.solve();
	}

	private void solve() {
		String x = "abcdef";
		String y = "abefdeffe";
//		String y = "abcdefgh";

		int[][] dp = new int[x.length()][y.length()];
		for(int[] d : dp)
			Arrays.fill(d, -1);
		int count = lcs(x, y, dp);
		for(int[] d: dp){
			for(int t: d){
				System.out.print(t+" ");
			}
			System.out.println();
		}

		System.out.println("Longest Common Subsequence Count is : " + count);
	}

	private int lcs(String x, String y, int[][] dp) {
		if(x.length() == 0 || y.length() == 0)
			return 0;
		int xLen = x.length() - 1;
		int yLen = y.length() - 1;

		if(dp[xLen][yLen] != -1){
			return dp[xLen][yLen];
		}
		if(x.charAt(xLen) == y.charAt(yLen)) {
			return dp[xLen][yLen] = 1 + lcs(x.substring(0, xLen), y.substring(0, yLen), dp);
		}
		return dp[xLen][yLen] = Math.max(lcs(x.substring(0, xLen), y, dp), lcs(x, y.substring(0, yLen), dp));
	}
}
