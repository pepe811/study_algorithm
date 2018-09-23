package sorting;

import java.io.*;
import java.util.*;

//해커랭크꺼 말고 https://gmlwjd9405.github.io/2018/05/10/algorithm-quick-sort.html 참고
public class Quicksort1 {

    static int[] quickSort(int[] arr, int left, int right) {       	
    	
    	//최종 리스트가 1이 될때까지
    	if(left < right) {
    		System.out.println("left:" + left +" right:"+ right);
	        int low = left+1;
	        int high = right;
	        int pivot = arr[left];
	        
	        System.out.println("pivot:" + left + " low:" + low +" high:"+ high + " start");
	        do{
	        	//피벗보다 작아야 하는 애들 건너뜀
	        	while(arr[low] < pivot && low < right){ //피벗이 젤 큰 경우 low 계속 가면 안됌
	        		low++;
	        	} 
	        	
	        	//피벗보다 커야 하는 애들 건너 뜀
	        	while(arr[high] > pivot) { //피벗 젤 작으면 high(0)랑 피벗 똑같아져서 멈춤
	        		high--; 
	        	} 
	        	
	        	if(low < high) { //low와 high가 교차 하지 않았을때 까지, 멈춘 당시의 low high교환 반복
	        		System.out.println("low "+ low +" high " + high +" change");
	        		swap(arr,low,high);
	        		printArray(arr);
	        	}
	        	
	        }while(low < high); //리스트 2,1 두개만 있을경우 실행 위해 do while
	        
	        //최종 low high 교차 했으면 피벗과 high 교환
	        System.out.println("pivot "+ left +" high " + high+ " change");
	        swap(arr,left,high); 
	        printArray(arr);

	        System.out.println("-----------------");
	        
	        //최종 피벗 위치 high 제외 재귀호출
	        quickSort(arr,left,high-1);
	        quickSort(arr,high+1,right);
    	}
        return arr;
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

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = quickSort(arr,0,n-1);

        System.out.print("최종 :");
        for (int i = 0; i < result.length; i++) {
        	System.out.print(String.valueOf(result[i]));

            if (i != result.length - 1) {
            	System.out.print(" ");
            }
        }

        scanner.close();
    }
}
