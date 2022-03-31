package DynamicProgramming.Tabulation;

import java.util.Arrays;
/**
 * Minimum Subset Sum problem similar to 0/1 Knapsack.
 * Here also we have sum as like bag. For Each element, we can either choose to include or exclude it.
 * So this is similar to knapsack.
 * <p>
 * The problem here is to have two subsets with sum as minimum, All the elements should be included.
 * Should return output is the minimum value;
 * <p>
 * Idea:
 * <br>-----
 * <p>
 * For Equal Sum Partition, we considered -- Sum should be equal, So tested the subset with sum/2.
 * Here, we need to consider that the sum should be near equal for a subset.
 * This intern will ensure that the other subset will be (Total Sum - Subset1 Sum) --> Gives Subset2 Sum.
 * To calculate the difference --> Sum1 - Sum2 or Sum2 - Sum1.
 * Optimization further, (Total Sum - 2* sum1) --> Gives minimum difference.
 *
 * <p>
 * Since we know how subset sums can be formed with boolean array, each row will give whether the subset max possible value --> True or False.
 * If we apply the same with, Sums with Mid --> Total Sum /2 and trace the last row from right to left.
 * This gives nearest possible subset sum to the mid value.
 * <p>
 * So considering the values as boolean array.
 * <p>
 * Initialization
 * ----------------
 * <p>
 * Find the total --> Find the mid = (total/2).
 * Create space matrix with Mid + 1 and input array + 1
 * <p>
 * If there are NO numbers but sum is present then it is false since we can't achieve that sum
 * If numbers are empty but sum is 0, it's true
 * <p>
 * Only exception case, (0,0) --> Where is true with empty set and sum 0;
 * <p>
 * Choice Diagram
 * ----------------
 * Similar to knapsack, instead of getting MAX value we can do simple || condition to measure whether
 * subset can be formed with that sum or not.
 *
 * Upon running the choice diagram and filling the matrix, need to derive the minimum difference.
 * Traverse the last row from right to left --> This gives the max possible sum that is near to mid.
 *
 * Return (total - 2 * sum)
 */
public class DP1_D_MinimumSubsetSum {
	public static void main(String[] args) {
		DP1_D_MinimumSubsetSum dp1_d_minimumSubsetSum = new DP1_D_MinimumSubsetSum();
		dp1_d_minimumSubsetSum.solve();
	}

	private void solve() {

		int[] arr = {1, 2, 3, 8, 3, 2};

		int total = Arrays.stream(arr).sum();
		int mid = (int) Math.ceil(total / 2);

		boolean[][] dp = new boolean[arr.length + 1][mid + 1];

		for(int i = 0; i < dp.length; i++) {
			for(int j = 0; j < dp[i].length; j++) {
				boolean result;
				if(j == 0) {
					result = true;
				} else if(i == 0) {
					result = false;
				} else if(arr[i - 1] <= j) {
					result = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
				} else {
					result = dp[i - 1][j];
				}
				dp[i][j] = result;
			}
		}

		int possibleSum = 0;
		for(int i = dp[0].length - 1; i >= 0; i--) {
			if(dp[dp.length - 1][i]) {
				possibleSum = i;
				break;
			}
		}
		System.out.println("Minimum Difference for Subset is " + (total - (2 * possibleSum)));
	}
}
