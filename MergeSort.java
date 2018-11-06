import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}
		sort(arr, 0, arr.length - 1);
		for (int i : arr)
			System.out.print(i + " ");
	}

	static void sort(int[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int middleIndex = startIndex + (endIndex - startIndex) / 2;
            sort(array, startIndex, middleIndex);
            sort(array, middleIndex + 1, endIndex);
            merg(array, startIndex, middleIndex, endIndex);
        	}
    	}

    static void merg(int[] a, int startIndex, int middleIndex, int endIndex) {
        int leftPartLength = middleIndex - startIndex + 1;
        int rightPartLength = endIndex - middleIndex;
        int[] leftPart = new int[leftPartLength];
        int[] rightPart = new int[rightPartLength];
        for (int i = 0; i < leftPartLength; i++) {
            leftPart[i] = a[i + startIndex];
        }
        for (int i = 0; i < rightPartLength; i++) {
            rightPart[i] = a[i + middleIndex + 1];
        }
        int leftIndex = 0;
        int rightIndex = 0;
        int mainIdex = startIndex;
        while (leftIndex < leftPartLength && rightIndex < rightPartLength) {
            if (leftPart[leftIndex] < rightPart[rightIndex]) {
                a[mainIdex] = leftPart[leftIndex];
                leftIndex++;
                mainIdex++;
            } else {
                a[mainIdex] = rightPart[rightIndex];
                rightIndex++;
                mainIdex++;
            }
        }
        while (leftIndex < leftPartLength) {
            a[mainIdex] = leftPart[leftIndex];
            leftIndex++;
            mainIdex++;
        }
        while (rightIndex < rightPartLength) {
            a[mainIdex] = rightPart[rightIndex];
            rightIndex++;
            mainIdex++;
        }
    }
}
