package Sorting;

import java.util.Arrays;

public class QuickSortAdjacent {
	public static void main(String[] args) {
		int nums[] = {100, 1, 2, 55, 7, 9, 0, 3, 10, 10, 10, 80, 30, 90, 40, 10, 50, 70};
		quickSort(0, nums.length - 1, nums);
		Arrays.stream(nums).forEach(System.out::println);
	}

	private static void quickSort(int start, int end, int nums[]) {
		if(start >= end) return;
		int partitionIndex = partition(nums, start, end);
		quickSort(start, partitionIndex - 1, nums);
		quickSort(partitionIndex + 1, end, nums);
	}

	private static int partition(int nums[], int start, int end) {
		int i = start - 1, j = start;
		int pivot = nums[end];
		while(j < end) {
			if(nums[j] <= pivot) {
				i++;
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
			}
			j++;
		}
		i++;
		int tmp = nums[i];
		nums[i] = nums[end];
		nums[end] = tmp;
		return i;
	}
}
