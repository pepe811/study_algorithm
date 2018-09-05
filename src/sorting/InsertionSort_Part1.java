package sorting;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
 * https://www.hackerrank.com/challenges/insertionsort1/problem
 * 2 4 6 8 3
 * 1. 3<8 8이 더 크니까 8 뒤로 밀고 24688
 * 2. 3<6 6이 더 크니까 6 뒤로 밀고 24668
 * 3. 3<4 4가 더 크니까 4 뒤로 밀고 24468
 * 4. 3>2 3자리 찾기 완료 2 뒤에 3 넣기 23468 
 */

public class InsertionSort_Part1 {
	
	static void printValue(int n, int[] arr) {
		for (int j = 0; j < n; j++) {
			System.out.print(arr[j] + " ");
		}
		System.out.println();
	}

    static void insertionSort1(int n, int[] arr) {
    	int lastValue = arr[n-1];
    	boolean completSort = false;
    	
    	for (int i = n-2 ; i >= 0; i--) {
    		if(arr[i] < lastValue) {
    			arr[i+1] = lastValue;
    			completSort = true;
    		} else {
    			arr[i+1] = arr[i];
    		}
    		
    		printValue(n,arr);
    		
    		if(completSort) break;
    	}
    	
    	//2 3 4 5 6 7 8 9 10 1 의 경우 추가 (lastValue가 젤 작은값이였을때)
    	if(!completSort) {
    		arr[0] = lastValue;
    		printValue(n,arr);
    	}

    }

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

        insertionSort1(n, arr);

        scanner.close();
    }
}
