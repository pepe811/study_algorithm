package sorting;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
 * https://www.hackerrank.com/challenges/ctci-bubble-sort/problem?h_r=internal-search
 */
public class BubbleSort {

    static void countSwaps(int[] a) {
    	int swapCnt = 0;
    	//맨끝 요소에 제일 큰 값 <- 차례로 정렬됨
    	for(int i = a.length-1 ; i > 0 ; i--) {
    		for(int j = 0; j < i ; j++) {
    			if(a[j] > a[j+1]) {
    				swap(a,j,j+1);
    				swapCnt++;
    			}
    		}
    	}
    	System.out.println("Array is sorted in " + swapCnt + " swaps.");
    	System.out.println("First Element: " + a[0]);
    	System.out.println("Last Element: " + a[a.length-1]);
    }
    
    public static void swap(int arr[], int x ,int y) {
    	int temp = arr[x] ;
    	arr[x] = arr[y];
    	arr[y] = temp;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        countSwaps(a);

        scanner.close();
    }
}