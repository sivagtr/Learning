package DynamicProgramming.Tabulation.dp1;
/**
 * Count of Subset Sum problem similar to 0/1 Knapsack.
 * Here also we have sum as like bag. For Each element, we can either choose to include or exclude it.
 * So this is similar to knapsack.
 *
 * Here we are taking whether the subset sum will be possible or not.
 * So considering the values as boolean array.
 *
 * Initialization
 * ----------------
 * If there are NO numbers but sum is present then it is false which is 0 since we can't achieve that sum
 * If numbers are empty but sum is 0, it's true which is 1
 *
 * Only exception case, (0,0) --> Where is true which is 1, with empty set and sum 0;
 *
 * Choice Diagram
 * ----------------
 * Similar to knapsack, instead of getting MAX value we can do simple '+' condition to get the count
 * of subset can be formed with that sum or not.
 */
public class DP1_C_CountOfSubsetSum {
	public static void main(String[] args) {
		DP1_C_CountOfSubsetSum DP1CCountOfSubsetSum = new DP1_C_CountOfSubsetSum();
		DP1CCountOfSubsetSum.perform();
	}

	private void perform() {
		int[] arr = {1, 2, 3, 5, 8, 6};
		int sum = 10;

		int[][] dp = new int[arr.length+1][sum+1];
		for(int i = 0; i<dp.length; i++){
			for(int j = 0; j<dp[i].length; j++){
				int val = 0;
				/**
				 * Base Condition
				 */
				if(j == 0){
					val = 1;
				}else if(i == 0){
					val = 0;
				}else if(arr[i-1]<=j){ // Choice Diagram (Exclude and Include)
					val = dp[i-1][j] + dp[i-1][j-arr[i-1]];
				}else{ // Choice Diagram
					val = dp[i-1][j];
				}
				dp[i][j] = val;
			}
		}
		System.out.println(dp[dp.length-1][dp[0].length-1]);
	}
}
