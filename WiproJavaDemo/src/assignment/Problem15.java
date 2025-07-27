package assignment;

public class Problem15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5, 3, 5, 2, 8, 3, 9, 2, 5, 8};
        int n = arr.length;
        int[] counted = new int[n];;
        System.out.println("Element : Occurrences");
        for (int i = 0; i < n; i++) {
        	if (counted[i] == 0) {  
                int count = 1;
                for (int j = i + 1; j < n; j++) {
                    if (arr[i] == arr[j]) {
                        count++;
                        counted[j] = 1; 
                    }
                }

                System.out.println(arr[i] + " : " + count);
            }
        }

	}

}

/*
Element : Occurrences
5 : 3
3 : 2
2 : 2
8 : 2
9 : 1
*/