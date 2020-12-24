package algo;

import java.util.ArrayList;
import java.util.Arrays;

public class AlgoUtil {

	/**
	 * 
	 * @param string is reference note
	 * @param arr    is array to print array
	 */

	public static void printArray(String string, int[] arr) {
		System.out.println();
		System.out.println(string + " no of element is :: " + arr.length);
		System.out.println();
//		Arrays.stream(arr).forEach(System.out::println);
		System.out.println(Arrays.toString(arr));
		System.out.println();
	}

	/**
	 * 
	 * @param arr is array
	 * @param k   is index
	 */

	public static void swapElem(int[] arr, int k) {
		arr[k] = arr[k] + arr[k + 1];
		arr[k + 1] = arr[k] - arr[k + 1];
		arr[k] = arr[k] - arr[k + 1];
	}

	/**
	 * 
	 * @param string is reference note
	 * @param buck   is array to print array list
	 * 
	 */

	public static void printArrayList(String string, ArrayList<Integer>[] buck) {
		System.out.println(string + " no of element is :: " + buck.length);
		Arrays.stream(buck).forEach(System.out::println);
	}

	/**
	 * 
	 * @param string is reference note
	 * @param arr    is array to print array
	 */

	public static void printArray(String string, float[] arr) {
		System.out.println(string + " no of element is :: " + arr.length);

		for (float i : arr)
			System.out.print(i + "  ");
	}

	/**
	 * 
	 * @param gap , intially it is array length
	 * @return gap size
	 */

	public static int getGapSize(int gap) {
		double shrinkSize = 1.3;
		return (int) (Math.floor(gap / shrinkSize));
	}

	/*
	 * swap array elements
	 * 
	 */

	public static int[] swapCombElem(int[] arr, int i, int j) {
		arr[i] = arr[i] + arr[j];
		arr[j] = arr[i] - arr[j];
		arr[i] = arr[i] - arr[j];
		return arr;
	}

	/**
	 * 
	 * @param arr is array
	 * @return max element in array
	 */

	public static int maxArrElem(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	/**
	 * 
	 * @param arr is array
	 * @param n   is length of array
	 * @param i   is starting node
	 */

	public static void heapify(int[] arr, int n, int i) {
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // find left node
		int r = 2 * i + 2; // find right node
		if (l < n && arr[l] > arr[largest]) {
			largest = l;
		}
		if (r < n && arr[r] > arr[largest]) {
			largest = r;
		}
		if (largest != i) {
			swapCombElem(arr, i, largest);
			// Recursively heapify the affected sub-tree
			heapify(arr, n, largest);
		}
	}

	/**
	 * 
	 * @param arr is array
	 * @return true or false to check whether array is sorted or not
	 */

	public static boolean isSorted(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @param arr is array
	 * @param l   is left
	 * @param m   is middle index
	 * @param r   is right index
	 */

	public static void divideConquer(int[] arr, int l, int m, int r) {

		// Find sizes of two sub arrays
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}

	}

	/**
	 * 
	 * @param arr is array
	 * @param n   in length of array
	 * @apiNote find how far or close the array to be sort
	 */
	public static void getInversionCount(int[] arr, int n) {
		int inv_count = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (arr[i] > arr[j]) {
					inv_count++;
				}
			}
		}
		System.out.println("Inversion Count is :: " + inv_count);
	}

}
