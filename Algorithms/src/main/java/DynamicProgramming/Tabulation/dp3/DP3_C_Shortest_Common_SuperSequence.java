package DynamicProgramming.Tabulation.dp3;

public class DP3_C_Shortest_Common_SuperSequence {
	public static void main(String[] args) {
		DP3_C_Shortest_Common_SuperSequence dp3_c_shortest_common_superSequence = new DP3_C_Shortest_Common_SuperSequence();
		dp3_c_shortest_common_superSequence.solve();
	}

	private void solve() {
		String x = "bygedgekqaaecbj";
		String y = "aggekekyx";

//		String x = "geek";
//		String y = "eke";
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

		int count = x.length() + y.length() - dp[dp.length - 1][dp[0].length - 1];
		System.out.println("Shortest Common SuperSequence length : " + count);

		int i = dp.length - 1;
		int j = dp[i].length - 1;
		String lcs = "";
		while((i != 0 || j != 0) && dp[i][j] != 0) {
			if(x.charAt(i-1) == y.charAt(j-1)){
				lcs = x.charAt(i - 1) + lcs;
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
		System.out.println("Longest Common SubSequence : " + lcs);
		i = j = 0;
		int k = 0;
		String ans = "";
		while(i < x.length() && j < y.length() && k<lcs.length()) {
			char xc = x.charAt(i);
			char yc = y.charAt(j);
			char lc = lcs.charAt(k);
			if(xc != yc && xc != lc && yc != lc) {
				ans += xc +""+ yc;
				i++;
				j++;
			} else if(xc == lc && yc != lc){
				ans += yc;
				j++;
			} else if(xc != lc && yc == lc){
				ans += xc;
				i++;
			} else{
				ans+= lc;
				i++;
				j++;
				k++;
			}
		}
		while(i < x.length()) {
			ans += x.charAt(i++);
		}
		while(j < y.length()) {
			ans += y.charAt(j++);
		}
		System.out.println("Shortest Common SuperSequence is : " + ans);
	}
}
