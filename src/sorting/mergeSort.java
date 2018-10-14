package sorting;

import java.util.*;

public class mergeSort {
	public static int[] sorted;
	
	public static void merge(int[] a, int left, int mid, int right) {
		System.out.println("combine -- left:" + left + " mid:" + mid + " right:"+ right);
		int i = left;     //정렬된 왼쪽 리스트 인덱스
		int j = mid + 1;  //정렬된 오른쪽 리스트 인덱스
		int k = left; 	  //정렬된 리스트에 대한 인덱스
		
		while(i <= mid && j <= right) {
			if(a[i] <= a[j]) {
				sorted[k++] = a[i++];
			} else {
				sorted[k++] = a[j++];
			}	
		}
		
		if(i > mid) {
			//남아있는 오른쪽 리스트 일괄 복사
			for(int l = j ; l <= right ; l++) {
				sorted[k++] = a[l];
			}
		} else {
			//남아있는 왼쪽 리스트 일괄 복사
			for(int l = i ; l <= mid ; l++) {
				sorted[k++] = a[l];
			}				
		}
		
		for(int l = left ; l <= right ; l++) {
			a[l] = sorted[l];		
		}
		System.out.println(left + " 에서  " + right + " 까지 정렬 후:");
		printArray(a);
	
	}
	
	public static void mergeSort(int[] a, int left, int right) {
		if(left < right) {
			int mid = (left + right)/2;
			System.out.println("divide --- left:" + left + " mid:" + mid + " right:"+ right);
			mergeSort(a,left,mid);
			mergeSort(a,mid+1,right);
			merge(a,left,mid,right);
		}
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
        sorted = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        mergeSort(a,0,n-1);

        scanner.close();
	}
}
