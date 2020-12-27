package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SortingAlgo {
	public static void main(String[] algo) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no. of elements to be sort :: ");
		int arrLen = sc.nextInt();
		sc.close();

		long start = System.currentTimeMillis();
		try {
			if (arrLen < 2) {
				System.out.print("Array size must be greater than 1");
				return;
			}
			callDriverMethod(arrLen);
		} catch (Exception e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		long milli = end - start;
		long sec = TimeUnit.MILLISECONDS.toSeconds(milli);
		System.out.println();
		System.out.print("Total Time to execute " + milli + " millis or " + sec + " sec");
	}

	/**
	 * 
	 * @param arrLen is length of array
	 */

	public static void callDriverMethod(int arrLen) {

		Random rand = new Random();
		int actualArr[] = new int[arrLen];
		for (int i = 0; i < arrLen; i++) {
			actualArr[i] = rand.nextInt(100);
		}
		// deep copy of array
		int arr[] = actualArr.clone();
//		int arr[] = { 5, 2, 10, 8, 1 };
		AlgoUtil.printArray("Before sort", arr);
		AlgoUtil.getInversionCount(arr, arrLen);
//		bubbleSort(arr, arrLen);
//		bucketSort(arrLen);
//		combSort(arr, arrLen, arrLen);
//		countingSort(arr, arrLen);
//		heapSort(arr);
//		insertionSort(arr);
//		mergeSort(arr, 0, arrLen - 1);
		quickSort(arr, 0, arrLen - 1);
		
		AlgoUtil.printArray("After sort", arr);
		System.out.println("Is Sorted --> " + AlgoUtil.isSorted(arr));
		System.out.println("Is Element Matched --> " + AlgoUtil.isArrayMatch(actualArr, arr));
	}

	/**
	 * 
	 * @param arr is array
	 * @param len is length of array
	 * 
	 */

	public static void bubbleSort(int[] arr, int len) {
		boolean isAgainSort = false;
		for (int k = 0; k < len - 1; k++) {
			if (arr[k] > arr[k + 1]) {
				AlgoUtil.swapElem(arr, k);
				isAgainSort = true;
			}
		}
		if (isAgainSort) {
			bubbleSort(arr, len);
		}
	}

	/**
	 * 
	 * @param rand is array
	 * @param len  is length of array
	 * 
	 *             buck is array of array List
	 * 
	 */

	@SuppressWarnings("unchecked")
	private static void bucketSort(int len) {
		float arr[] = new float[len];
		for (int i = 0; i < len; i++) {
			arr[i] = (float) Math.random();
		}

		AlgoUtil.printArray("Before sort", arr);

		ArrayList<Float> buck[] = new ArrayList[len];

		// Create empty buckets
		for (int i = 0; i < len; i++) {
			buck[i] = new ArrayList<Float>();
		}

		// Add elements into the buckets
		for (int i = 0; i < len; i++) {
			int buckIndex = (int) arr[i] * len;
			buck[buckIndex].add(arr[i]);
		}

		// Sort the elements of each bucket
		for (int i = 0; i < len; i++) {
			Collections.sort(buck[i]);
		}

		// Get the sorted array
		int index = 0;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < buck[i].size(); j++) {
				arr[index++] = buck[i].get(j);
			}
		}
		AlgoUtil.printArray("After bucket sort:: ", arr);
	}

	/**
	 * 
	 * @param arr   is array
	 * @param len   is length of array
	 * @param gsize is gap size after shrink of array
	 */

	private static void combSort(int[] arr, int len, int gSize) {
		int gap = AlgoUtil.getGapSize(gSize);
		if (gap >= 1) {
			for (int i = 0; i < len - gap; i++) {
				int gapIndex = gap + i;
				if (gapIndex < len) {
					if (arr[i] > arr[gapIndex]) {
						arr = AlgoUtil.swapCombElem(arr, i, gapIndex);
					}
				}
			}
			combSort(arr, len, gap);
		} else {
			AlgoUtil.printArray("After comb sort:: ", arr);
		}
	}

	/**
	 * 
	 * @param arr  is array
	 * @param size is length of array
	 * @apiNote Not good for integer greater than size of array
	 * 
	 */

	private static void countingSort(int[] arr, int size) {

		// find max element if array
		int max = AlgoUtil.maxArrElem(arr);

		// Initialize count array with all zeros.
		int count[] = new int[max + 1];
		for (int i = 0; i < max; i++) {
			count[i] = 0;
		}

		// Store the count of each element
		for (int i = 0; i < size; i++) {
			count[arr[i]]++;
		}

		// Store the cumulative count of each array
		for (int i = 1; i <= max; i++) {
			count[i] += count[i - 1];
		}

		// Find the index of each element of the original array
		// for array index value , and that array value will be used as a index for
		// to find count
		// array value then count array value is decrement by 1 , which will be the
		// index of new
		// output array and finally add array index value to new output array

		int out[] = new int[size];

		for (int i = 0; i < size; i++) {
			out[count[arr[i]] - 1] = arr[i];
			count[arr[i]]--;
		}
		// Copy the sorted elements into original array
		for (int i = 0; i < size; i++) {
			arr[i] = out[i];
		}

	}

	/**
	 * 
	 * @param arr is array
	 */

	private static void heapSort(int[] arr) {
		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
			AlgoUtil.heapify(arr, n, i);
		}
		for (int i = n - 1; i > 0; i--) {
			AlgoUtil.swapCombElem(arr, i, 0);
			AlgoUtil.heapify(arr, i, 0);
		}
	}

	/**
	 * 
	 * @param arr is array
	 */

	private static void insertionSort(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int temp = arr[i];
			int j = i - 1;
			while (j >= 0 && temp <= arr[j]) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;
		}
	}

	/**
	 * 
	 * @param arr is array
	 * @param l   is leftmost element
	 * @param r   is rightmost element
	 */

	private static void mergeSort(int[] arr, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);
			AlgoUtil.divideConquer(arr, l, m, r);
		}
	}

	/**
	 * 
	 * @param arr   is array
	 * @param first is first element
	 * @param last  is last element
	 */

	private static void quickSort(int[] arr, int first, int last) {
		if (first < last) {
			// pi is partitioning index, arr[pi] is now at right place
			int pi = AlgoUtil.partition(arr, first, last);
			// Recursively sort elements before
			quickSort(arr, first, pi - 1);
			// partition and after partition
			quickSort(arr, pi + 1, last);
		}
	}

}
