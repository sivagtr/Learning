package DynamicProgramming.Tabulation.dp1;

import java.util.Arrays;
/**
 * Count Subset Sum with Difference problem similar to 0/1 Knapsack.
 * Here also we have sum as like bag. For Each element, we can either choose to include or exclude it.
 * So this is similar to knapsack.
 * <p>
 * The problem here is to have two subsets with sum as minimum, All the elements should be included.
 * Should return output is the count value;
 * <p>
 * Idea:
 * <br>-----
 * <p>
 * For Equal Sum Partition, we considered -- Sum should be equal, So tested the subset with sum/2.
 * Here, we need to consider that the sum is given as input.
 * Total = S1 + S2
 * S1 - S2 = diff
 * so, S = (Total + Diff)/2
 *
 * Subset count should be taken with calculated sum.
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
public class DP1_E_CountOfSubsetWithDifference {
	public static void main(String[] args) {
		DP1_E_CountOfSubsetWithDifference dp1_e_countOfSubsetWithDifference = new DP1_E_CountOfSubsetWithDifference();
		dp1_e_countOfSubsetWithDifference.solve();
	}

	private void solve() {
		int[] arr = { 1,1,2,3 };
		int diff = 8;
		int total = Arrays.stream(arr).sum();
		int sum = ((total + diff) / 2);

		int[][] dp = new int[arr.length + 1][sum + 1];
		for(int i = 0; i < dp.length; i++) {
			for(int j = 0; j < dp[i].length; j++) {
				int result;
				if(j == 0) {
					result = 1;
				} else if(i == 0) {
					result = 0;
				} else if(arr[i - 1] <= j) {
					result = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
				} else {
					result = dp[i - 1][j];
				}
				dp[i][j] = result;
			}
		}
		System.out.println("Count of subsets that can be formed with Difference is " + dp[dp.length - 1][dp[0].length - 1]);
	}
}
