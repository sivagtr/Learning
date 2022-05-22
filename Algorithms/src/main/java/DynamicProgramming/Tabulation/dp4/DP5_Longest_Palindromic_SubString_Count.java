package DynamicProgramming.Tabulation.dp4;

public class DP5_Longest_Palindromic_SubString_Count {
	public static void main(String[] args) {
		DP5_Longest_Palindromic_SubString_Count dp5_longest_palindromic_subStringCount = new DP5_Longest_Palindromic_SubString_Count();
		dp5_longest_palindromic_subStringCount.solve();
	}

	private void solve() {
		String x = "xabax";
		int[][] dp = new int[x.length()][x.length()];
		int counter = 0;
		// Gap Matrix
		for(int g = 0; g < x.length(); g++) {
			for(int i = 0, j = g; j < dp.length; i++, j++) {
				if(g == 0) {
					dp[i][j] = 1;
					counter++;
				} else {
					boolean sameChar = x.charAt(i) == x.charAt(j);
					if(sameChar){
						if(g == 1 || dp[i+1][j-1] == 1){
							dp[i][j] = 1;
							counter++;
						}
					}
				}
			}
		}
		System.out.println("Total count of Palindromic SubString is " + counter);
	}
}
