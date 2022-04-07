package DynamicProgramming.Tabulation.dp3;

public class DP3_D_Minimum_No_Convert_String_A_To_String_B {
	public static void main(String[] args) {
		DP3_D_Minimum_No_Convert_String_A_To_String_B dp3_d_minimum_no_convert_string_a_to_string_b = new DP3_D_Minimum_No_Convert_String_A_To_String_B();
		dp3_d_minimum_no_convert_string_a_to_string_b.solve();
	}

	private void solve() {
		String x = "geekds";
		String y = "ekabcdefgeekedf";

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
		int lcsLength = dp[dp.length - 1][dp[0].length - 1];
		System.out.println("Deletion Count : " + (x.length() - lcsLength));
		System.out.println("Insertion Count : " + (y.length() - lcsLength));
	}
}
