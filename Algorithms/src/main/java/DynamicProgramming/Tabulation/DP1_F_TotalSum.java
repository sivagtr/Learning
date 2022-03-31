package DynamicProgramming.Tabulation;

import java.util.Arrays;
/**
 * Count Subset Sum with Difference problem similar to 0/1 Knapsack.
 * Here also we have sum as like bag. For Each element, we can either choose to include or exclude it.
 * So this is similar to knapsack.
 * <p>
 * Problem Description:
 * <br>----------------------
 * Input array is given --> Add a sign (+/-) for each number and total sum should be the given sum.
 * Return the count, how many satisfies the condition.
 *
 * Example:
 *              arr: [1,1,2,3], sum: 1
 *
 *              So, [+1, -1, -2, +3] --> Forms sum - 1
 *                  [-1, +1, -2, +3] --> Forms sum - 1
 *                  [+1, +1, +2, -3] --> Forms sum - 1
 *
 *              O/P: Count is 3
 *
 *
 * <p>
 * Idea:
 * <br>-----
 * <p>
 *  This can be derived in this format.
 *              [+1, -1, -2, +3]
 *              [+3, +1]  [-1,-2] ==> [3,1] - [1,2]
 *
 *       This is similar to Subset sum with a given difference
 *              S1 - S2 = diff
 *
 *       Now the problem falls like Count of Subset with Difference [DP1_E_CountOfSubsetWithDifference]
 *
 *       So, calculate the required sum that should be achieved. S = (total + diff)/2
 *
 *       Return the count.
 *
 * <p>
 *
 * Initialization
 * ----------------
 * <p>
 * Find the total --> Find the calculated sum = (total + diff)/2.
 * Create space matrix with input array + 1 and sum + 1
 * <p>
 * If there are NO numbers but sum is present then it is false since we can't achieve that sum, which is 0
 * If numbers are empty but sum is 0, it's true which is 1
 * <p>
 * Only exception case, (0,0) --> Where is true with empty set and sum 0 which is 1
 * <p>
 * Choice Diagram
 * ----------------
 * Similar to knapsack, instead of getting MAX value we can do simple + condition to get the sum for the count
 *
 * Return last element
 */
public class DP1_F_TotalSum {
	public static void main(String[] args) {
		DP1_F_TotalSum dp1_f_totalSum = new DP1_F_TotalSum();
		dp1_f_totalSum.solve();
	}

	private void solve() {
		int[] arr = {1,1,2,3};
		int targetSum = 1;

		int total = Arrays.stream(arr).sum();
		int sum = (total + targetSum)/2;

		int[][] dp = new int[arr.length+1][sum+1];
		for(int i = 0; i<dp.length; i++){
			for(int j = 0; j<dp[i].length; j++){
				int result;
				if(j == 0){
					result = 1;
				}else if(i == 0){
					result = 0;
				}else if(arr[i-1]<=j){
					result = dp[i-1][j] + dp[i-1][j-arr[i-1]];
				}else{
					result = dp[i-1][j];
				}
				dp[i][j] = result;
			}
		}
		System.out.println("Count of Total sum with target is "+dp[dp.length-1][dp[0].length-1]);
	}
}
