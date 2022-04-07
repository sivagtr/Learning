package DynamicProgramming.RecursiveApproach;

public class R2_Longest_Common_SubSequence_LCS {
	public static void main(String[] args) {
		R2_Longest_Common_SubSequence_LCS r2_longest_common_subSequence_lcs = new R2_Longest_Common_SubSequence_LCS();
		r2_longest_common_subSequence_lcs.solve();
	}

	private void solve() {
		String x = "abcdefgh";
		String y = "abedfgfhvvvvvv";

		int count = lcs(x, y);
		System.out.println("LCS (Longest Common Subsequence length is : " + count);
	}

	private int lcs(String x, String y) {
		if(x.length() == 0 || y.length() == 0)
			return 0;
		if(x.charAt(x.length() - 1) == y.charAt(y.length() - 1)) {
			return 1 + lcs(x.substring(0, x.length() - 1), y.substring(0, y.length() - 1));
		} else {
			return Math.max(lcs(x.substring(0, x.length() - 1), y), lcs(x, y.substring(0, y.length() - 1)));
		}
	}
}
