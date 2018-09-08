package sorting;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
/*
 * https://www.hackerrank.com/challenges/insertionsort2/problem
 * 1 4 3 5 6 2
 * 
 * 1. 1까지는 하나니까 이미 정렬됬으니 건너뛰기
 * 2. 1,4 까지 part1 정렬 방식으로 정렬되면 출력                             ->  1 4 / 3 5 6 2
 * 3. 1,4,3 까지 반복 후 출력 (1,4 정렬된 배열, 3 lastValue) -> 1 3 4 / 5 6 2
 * 4. 1,3,4,5 까지           -> 1 3 4 5 / 6 2
 * 5. 1,3,4,5,6 까지      -> 1 3 4 5 6 / 2
 * 6. 1,3,4,5,6,2 까지 -> 1 2 3 4 5 6
 */


public class InsertionSort_part2 {

    static void insertionSort2(int n, int[] arr) {
    	for (int i = 1; i < n; i++) {
    		insertionSort1(i+1, arr);
    		printValue(n, arr); //배열은 call by reference
    	}
    }
    

    static int[] insertionSort1(int n, int[] arr) {
    	int lastValue = arr[n-1];
    	boolean completSort = false;
    	
    	for (int i = n-2 ; i >= 0; i--) {
    		if(arr[i] < lastValue) {
    			arr[i+1] = lastValue;
    			completSort = true;
    		} else {
    			arr[i+1] = arr[i];
    			arr[i] = lastValue;
    		}
    		
    		if(completSort) break;
    	}
    	
    	//2 3 4 5 6 7 8 9 10 1 의 경우 추가 (lastValue가 젤 작은값이였을때)
    	if(!completSort) {
    		//arr[0] = lastValue;
    		
    	}
    	return arr;
    }
    
	static void printValue(int n, int[] arr) {
		for (int j = 0; j < n; j++) {
			System.out.print(arr[j] + " ");
		}
		System.out.println();
	}
	
	/*
	 * 반대로 시작하는 방법
    static void insertionSort2(int n, int[] arr) {
    	
	    for(int k = 1; k < arr.length; k++){
	        for(int i = 0; i <= k; i++){
	         int key = arr[k];           
	            if(key < arr[i]){
	                arr[k] = arr[i];
	                arr[i] = key;
	            }
	        }
	        for(int i = 0; i < arr.length ; i++)
	        {
	        	System.out.print(arr[i]+" ");
	     	} 
	        System.out.println();
	     }
	    
    }
	*/	
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

        insertionSort2(n, arr);

        scanner.close();
    }
}
