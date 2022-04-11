package DynamicProgramming.RecursiveApproach;

public class R3_Matrix_Chain_Multiplication_MCM {
	public static void main(String[] args) {
		R3_Matrix_Chain_Multiplication_MCM r3_matrix_chain_multiplication_mcm = new R3_Matrix_Chain_Multiplication_MCM();
		r3_matrix_chain_multiplication_mcm.solve();
	}

	private void solve() {
		int[] arr = {10, 30, 5, 60,4};
		int ans;
		ans = performMCM(arr, 1, arr.length - 1);
		System.out.println("Minimum value for Matrix Chain Multiplication is : " + ans);
	}

	private int performMCM(int[] arr, int i, int j) {
		System.out.printf("Before start i %d, j %d\n", i, j);
		if(i == j) return 0;
		int ans = Integer.MAX_VALUE;
		for(int k = i; k <= j - 1; k++) {
			int left = performMCM(arr, i, k);
			int right = performMCM(arr, k + 1, j);
			int multiplication = arr[i - 1] * arr[k] * arr[j];
			int tmp = left + right + multiplication;
			System.out.printf("i %d, k %d, j %d\n", i, k, j);
			System.out.printf("A %d, B %d, C %d [%d * %d * %d] -- Tmp %d\n", left, right, multiplication,arr[i - 1] , arr[k] , arr[j], tmp);
			ans = Math.min(ans, tmp);
		}
		return ans;
	}

}
