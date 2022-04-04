package DynamicProgramming.Tabulation.dp2;

public class DP2_B_CoinChange_Max_Ways_To_Get_Sum {
	public static void main(String[] args) {
		DP2_B_CoinChange_Max_Ways_To_Get_Sum dp2_b_coinChange_max_waysToGetSum = new DP2_B_CoinChange_Max_Ways_To_Get_Sum();
		dp2_b_coinChange_max_waysToGetSum.solve();
	}

	private void solve() {
		int coins[] = {1,2,3};
		int requiredSum = 5;

		int[][] dp = new int[coins.length+1][requiredSum+1];

		for(int i = 0; i<dp.length; i++){
			for(int j = 0; j<dp[i].length; j++){
				int result;
				if(j == 0){
					result = 1;
				}else if(i == 0){
					result = 0;
				}else if(coins[i-1]<=j){
					result = dp[i][j-coins[i-1]] + dp[i-1][j];
				}else {
					result = dp[i-1][j];
				}
				dp[i][j] = result;
			}
		}

		for(int[] d : dp){
			for(int x : d){
				System.out.print(x+" ");
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Maximum #Ways to get required total :: "+dp[dp.length-1][dp[0].length-1]);
	}
}
