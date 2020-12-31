package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AlgoUtil {

	/**
	 * 
	 * @param string is reference note
	 * @param arr    is array to print array
	 */

	public static void printArray(String string, int[] arr) {
		System.out.println("===========================================");
		System.out.println(string + " no of element is :: " + arr.length);
//		Arrays.stream(arr).forEach(System.out::println);
		System.out.println(Arrays.toString(arr));
		System.out.println("===========================================");
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
	 * @param gap, initially it is array length
	 * @return gap size
	 */

	public static int getGapSize(int gap) {
		double shrinkSize = 1.3;
		return (int) (Math.floor(gap / shrinkSize));
	}

	/*
	 * swap array elements where i and j are index of same array
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
		System.out.println();
		System.out.println();
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
		System.out.println();
		System.out.println();
	}

	/**
	 * 
	 * @param arr   is array
	 * @param first is first element of partition
	 * @param last  is lost element of partition
	 * @return partition sorted element for that index
	 */

	public static int partition(int[] arr, int first, int last) {
		int pivot = arr[last];
		int i = first - 1;
		for (int j = first; j < last; j++) {
			if (arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[last];
		arr[last] = temp;
		return i + 1;
	}

	/**
	 * 
	 * @param actualArr is actual array for sorting
	 * @param arr       is sorted array
	 * @return whether it have same element or different element
	 */

	public static boolean isArrayMatch(int[] actualArr, int[] arr) {
		if (actualArr != null && arr != null && actualArr.length == arr.length) {
			for (int i = 0; i < actualArr.length; i++) {
				int num = actualArr[i];
				arr = convertArrayToArrayListToArray(arr, num);
			}
		}
		if (arr.length == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param arr is array
	 * @param num is value to find arr index
	 * @return array after index element deleted if found
	 */

	private static int[] convertArrayToArrayListToArray(int[] arr, int num) {
		List<Integer> list = IntStream.of(arr).boxed().collect(Collectors.toList());
		int index = list.indexOf(num);
		if (index != -1) {
			list.remove(index);
		}
		return list.stream().mapToInt(Integer::intValue).toArray();
	}

	/**
	 * 
	 * @param arr is array
	 * @param index is index to delete element
	 * @return new array after delete element 
	 */
	
	public static int[] deleteElementAtIndex(int[] arr, int index) {
		return IntStream.range(0, arr.length).filter(i -> i != index).map(i -> arr[i]).toArray();
	}

	/**
	 * 
	 * @param arr is array
	 * @param len is length of array
	 * @param i is excluding array index
	 * @return smallest element position
	 */
	
	public static int getSmallestElem(int[] arr, int len, int i) {
		int pos = i;
		int small = arr[i];
		for (int j = i + 1; j < len; j++) {
			if (arr[j] < small) {
				small = arr[j];
				pos = j;
			}
		}
		return pos;
	}

}
