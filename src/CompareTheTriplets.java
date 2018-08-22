import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CompareTheTriplets {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
    	List<Integer> result = new ArrayList<>();
    	int aSum = 0;
    	int bSum = 0;
    	
    	for (int i = 0; i < 3; i++) {
    		if (a.get(i) > b.get(i)) {
    			aSum++;
    		}
    		else if (a.get(i) < b.get(i)) {
    			bSum++;
    		}
    	}
    	
    	result.add(aSum);
    	result.add(bSum);
    	
    	return result;
    }

    public static void main(String[] args) throws IOException {
    	
    	List<Integer> a = new ArrayList<Integer>(Arrays.asList(17, 28, 30));
    	List<Integer> b = new ArrayList<Integer>(Arrays.asList(99, 16, 8));

        List<Integer> result = compareTriplets(a, b);

        for (int i = 0; i < result.size(); i++) {
        	System.out.print(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
            	System.out.print(" ");
            }
        }
    }
}