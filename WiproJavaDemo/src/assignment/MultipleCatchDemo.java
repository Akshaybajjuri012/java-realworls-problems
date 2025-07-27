package assignment;

public class MultipleCatchDemo {

	public static void main(String[] args) {
		
        try {
            int[] arr = new int[-5];
        } catch (NegativeArraySizeException e) {
            System.out.println("Caught NegativeArraySizeException:");
            e.printStackTrace();
        }

        System.out.println("--------------------------------------------------");

       
        try {
            int[] arr = new int[3];
            int value = arr[5]; // Invalid index
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException:");
            e.printStackTrace();
        }
        System.out.println("--------------------------------------------------");

     
        try {
            String str = "hello";
            char ch = str.charAt(10); // Invalid index
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException:");
            e.printStackTrace();
        }

        System.out.println("--------------------------------------------------");
        try {
            java.util.List<Integer> list = new java.util.ArrayList<>();
            list.add(1);
            int val = list.get(5); // Invalid index
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught IndexOutOfBoundsException:");
            e.printStackTrace();
        }

        System.out.println("--------------------------------------------------");
        try {
            String str = null;
            int len = str.length(); // Null reference
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException:");
            e.printStackTrace();
        }

        System.out.println("--------------------------------------------------");
        try {
            int a = 10;
            int b = 0;
            int result = a / b; // Division by zero
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException:");
            e.printStackTrace();
        }

        System.out.println("--------------------------------------------------");
        try {
            int[] arr = new int[3];
            int val = arr[10]; // ArrayIndexOutOfBoundsException
        } catch (NegativeArraySizeException e) {
            System.out.println("Caught in NegativeArraySizeException block");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught in ArrayIndexOutOfBoundsException block");
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught in IndexOutOfBoundsException block");
        } catch (Exception e) {
            System.out.println("Caught in generic Exception block");
        }

	}

}


