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
//		quickSort(arr, 0, arrLen - 1);
//		arr = radixSort(arr, arrLen);
//		selectionSort(arr, arrLen);
		shellSort(arr, arrLen);
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

	@SuppressWarnings({ "unchecked", "unused" })
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

	@SuppressWarnings("unused")
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

	@SuppressWarnings("unused")
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

	@SuppressWarnings("unused")
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

	@SuppressWarnings("unused")
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

	@SuppressWarnings("unused")
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

	@SuppressWarnings("unused")
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

	/**
	 * 
	 * @param arr is array
	 * @param len is length of array
	 * @return sorted array
	 * @apiNote sort LSB -> MSB by using internally counting sort
	 */

	private static int[] radixSort(int[] arr, int len) {
		int max = AlgoUtil.maxArrElem(arr);
		String s = Integer.toString(max);
		int divLen = s.length();
		int p = 1;
		while (divLen > 0) {
			int countArray[] = new int[len];
			for (int i = 0; i < arr.length; i++) {
				String number = String.valueOf(arr[i]);
				if ((number.length() - p >= 0) && number.charAt(number.length() - p) != -1) {
					countArray[i] = (Character.digit(number.charAt(number.length() - p), 10)) != -1
							? Character.digit(number.charAt(number.length() - p), 10)
							: 0;
				} else {
					countArray[i] = 0;
				}

			}
			// apply count sort
			countingSort(countArray, len);
			int tempArray[] = new int[len];
			int[] tArr = arr.clone();
			for (int i = 0; i < countArray.length; i++) {
				int countNum = countArray[i];
				inner: for (int j = 0; j < tArr.length; j++) {
					String n = String.valueOf(tArr[j]);
					int ch = ((n.length() - p >= 0) && (Character.digit(n.charAt(n.length() - p), 10)) != -1)
							? Character.digit(n.charAt(n.length() - p), 10)
							: 0;
					if (countNum == ch) {
						tempArray[i] = tArr[j];
						tArr = AlgoUtil.deleteElementAtIndex(tArr, j);
						break inner;
					}
				}
			}
			arr = tempArray.clone();
			divLen--;
			p++;
		}
		return arr;
	}

	/**
	 * 
	 * @param arr is array
	 * @param len is length of array
	 */

	private static void selectionSort(int[] arr, int len) {
		for (int i = 0; i < len; i++) {
			int pos = AlgoUtil.getSmallestElem(arr, len, i);
			if (pos != i) {
				AlgoUtil.swapCombElem(arr, i, pos);
			}
		}
	}

	/**
	 * 
	 * @param arr is array
	 * @param n   is length of array
	 * 
	 */

	private static void shellSort(int[] arr, int n) {
		int i, j, k;
		// pass loop half by half
		for (i = n / 2; i > 0; i = i / 2) {
			// loop to rightward direction from gap to last element 
			for (j = i; j < n; j++) {
//				loop from leftward direction from first element to gap 
				for (k = j - i; k >= 0; k = k - i) {
					if (arr[k + i] >= arr[k])
						break;
					else {
						AlgoUtil.swapCombElem(arr, k, k + i);
					}
				}
			}
		}
	}

}
