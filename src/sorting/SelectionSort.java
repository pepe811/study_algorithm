package sorting;

import java.util.*;

public class SelectionSort {
	
	static void selecttionSort(int[] a) {
		for(int i = 0; i < a.length - 1 ; i++) {
			int minIdx = i;
			//최소값 탐색해서
			for (int j = i+1 ; j < a.length; j++) {
				if(a[j] < a[minIdx]) {
					minIdx = j;
				}
			}
			//왼쪽부터 오름차순으로 정렬
			if(a[minIdx] < a[i]) {
				swap(a,minIdx,i);
			}
		}
		
		printArray(a);
	}
	
    public static void swap(int arr[], int x ,int y) {
    	int temp = arr[x] ;
    	arr[x] = arr[y];
    	arr[y] = temp;
    }
   
    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println();
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

        selecttionSort(a);

        scanner.close();
    }
}
