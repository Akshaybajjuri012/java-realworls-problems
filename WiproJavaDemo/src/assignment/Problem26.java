
package assignment;
import java.util.*;

public class Problem26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {2, 3, 54, 1, 6, 7, 7};
        Set<Integer> uniqueSet = new HashSet<>();
        for (int num : input) {
            uniqueSet.add(num);
        }
        int evenSum = 0;
        for (int num : uniqueSet) {
            if (num % 2 == 0) {
                evenSum += num;
            }
        }
        System.out.println("Sum of even numbers (unique only): " + evenSum);

	}

}

/*
Sum of even numbers (unique only): 62
*/