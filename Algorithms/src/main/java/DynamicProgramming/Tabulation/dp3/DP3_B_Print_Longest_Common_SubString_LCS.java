package DynamicProgramming.Tabulation.dp3;

public class DP3_B_Print_Longest_Common_SubString_LCS {
	public static void main(String[] args) {
		DP3_B_Print_Longest_Common_SubString_LCS dp3_b_print_longest_common_subString_lcs = new DP3_B_Print_Longest_Common_SubString_LCS();
		dp3_b_print_longest_common_subString_lcs.solve();
	}

	private void solve() {
		String x = "xabedef";
		String y = "babcfdeffe";

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
		String ans = "";
		int i = dp.length - 1;
		int j = dp[i].length - 1;
		while((i != 0 || j != 0) && dp[i][j] != 0) {
			if(x.charAt(i-1) == y.charAt(j-1)){
				ans = x.charAt(i - 1) + ans;
				i--;
				j--;
			}else{
				if(dp[i-1][j]>dp[i][j-1]){
					i--;
				}else{
					j--;
				}
			}
		}
		System.out.println("Longest SubString is : " + ans);
	}
}
