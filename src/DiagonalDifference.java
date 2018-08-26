import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class DiagonalDifference {

    // https://www.hackerrank.com/challenges/diagonal-difference/problem
    static int diagonalDifference(int[][] arr) {
        int leftToRight = 0;
        int rightToLeft = 0;

        for (int i = 0; i < arr.length ; i++) {
            leftToRight += arr[i][i];
            rightToLeft += arr[(arr.length-1)-i][i];
        }
        
        return Math.abs(leftToRight-rightToLeft); 
        
        /*
        int leftToRight = 0;
        int rightToLeft = 0;
        int i = 0;
        
        for (int j = 0; j < arr.length ; j++) {
            leftToRight += arr[i][j];
            i++;
        }
        
        for (int j = 0; j < arr.length ; j++) {
            rightToLeft += arr[i-1][j];
            i--;
        }
        return Math.abs(leftToRight-rightToLeft);
        */
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < n; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = diagonalDifference(arr);
        
        System.out.println(result);
        scanner.close();
    }
}