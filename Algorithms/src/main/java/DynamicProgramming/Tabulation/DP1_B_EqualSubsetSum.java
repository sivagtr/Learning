package DynamicProgramming.Tabulation;

import java.util.Arrays;

/**
 * EqualSubset Sum problem similar to 0/1 Knapsack.
 * Here also we have sum as like bag. For Each element, we can either choose to include or exclude it.
 * So this is similar to knapsack.
 * <p>
 * The problem here is to have two subsets with equal sum, All the elements should be included.
 * Should return output whether that can be formed or not (True or False)
 * <p>
 * So considering the values as boolean array.
 * <p>
 * Initialization
 * ----------------
 * <p>
 * How do we know the whether two equal sets or not
 * 1. If total sum is ODD, we can't divide the subset's. Since we are considering only int type.
 * 2. If total sum is EVEN, the sum should be total/2. This falls as subset sum with sum as total/2.
 * So other subset will be automatically equal to the total/2.
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
 */
public class DP1_B_EqualSubsetSum {
	public static void main(String[] args) {
		DP1_B_EqualSubsetSum DP1BEqualSubsetSum = new DP1_B_EqualSubsetSum();
		DP1BEqualSubsetSum.canFormEqualSubsetSum();
	}

	private void canFormEqualSubsetSum() {
//		int arr[] = {1, 2, 4, 6, 8, 3,10};
		int arr[] = {2,4,8};
		int total = Arrays.stream(arr).sum();
		if(total % 2 != 0) {
			System.out.println("Equal Subset Sum can't be formed since the total of the given input is ODD");
			return;
		}
		int sum = total / 2;
		boolean dp[][] = new boolean[arr.length + 1][sum + 1];
		for(int i = 0; i < dp.length; i++) {
			for(int j = 0; j < dp[i].length; j++) {
				if(j == 0) {
					dp[i][j] = true;
				} else if(i == 0) {
					dp[i][j] = false;
				} else if(arr[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j] || dp[i][j - arr[i - 1]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		for(boolean[] d : dp) {
			for(boolean i : d)
				System.out.print(i + " ");
			System.out.println();
		}
		System.out.println();
		System.out.println();
		System.out.println("Final Choice whether equal sum partition can be done ? -- " + dp[dp.length - 1][dp[0].length - 1]);
	}
}
