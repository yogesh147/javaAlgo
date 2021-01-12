package algo;

import java.util.Scanner;

public class DesignPattern {
	public static void main(String[] algo) {
		System.out.println(" Please Enter String ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();
		printSquareNameBoundary(str);
	}

	public static void printSquareNameBoundary(String str) {

		char[] ch = str.toCharArray();
		char[] revCh = new char[str.length()];
		int m = 0;
		for (int i = ch.length - 1; i >= 0; i--) {
			revCh[m++] = ch[i];
		}

		String arr[][] = new String[str.length()][str.length()];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {

				if (i == 0) {
					arr[i][j] = "" + ch[j];
				} else if (i == arr.length - 1) {
					arr[i][j] = "" + revCh[j];
				} else if (j == 0) {
					arr[i][j] = "" + ch[i];
				} else if (j == arr.length - 1) {
					arr[i][j] = "" + revCh[i];
				} else {
					arr[i][j] = " ";
				}
			}
		}
		AlgoUtil.print2DArray("Name pattern ", arr);
	}

}
