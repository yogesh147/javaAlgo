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
		System.out.println(string + " no of element is :: " + arr.length);
//		Arrays.stream(arr).forEach(System.out::println);
        System.out.println(Arrays.toString(arr));

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
	 * swap elements for comb Sort
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

}
