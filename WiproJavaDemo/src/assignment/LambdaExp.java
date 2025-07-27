package assignment;
@FunctionalInterface
interface PerformOperation {
    boolean check(int a);
}
class MyMath {

   
    public static PerformOperation isOdd() {
        return a -> a % 2 != 0;
    }

   
    public static PerformOperation isPrime() {
        return a -> {
            if (a < 2) return false;
            for (int i = 2; i <= Math.sqrt(a); i++) {
                if (a % i == 0) return false;
            }
            return true;
        };
    }
    public static PerformOperation isPalindrome() {
        return a -> {
            String str = String.valueOf(a);
            return str.equals(new StringBuilder(str).reverse().toString());
        };
    }

   
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }
}
public class LambdaExp {
	public static void main(String[] args) {
        
        System.out.println("Is 5 odd? " + MyMath.checker(MyMath.isOdd(), 5));         
        System.out.println("Is 8 odd? " + MyMath.checker(MyMath.isOdd(), 8));          

        
        System.out.println("Is 7 prime? " + MyMath.checker(MyMath.isPrime(), 7));     
        System.out.println("Is 9 prime? " + MyMath.checker(MyMath.isPrime(), 9));      

        
        System.out.println("Is 121 a palindrome? " + MyMath.checker(MyMath.isPalindrome(), 121));  
        System.out.println("Is 123 a palindrome? " + MyMath.checker(MyMath.isPalindrome(), 123));  
    }

}


/*
Is 5 odd? true
Is 8 odd? false
Is 7 prime? true
Is 9 prime? false
Is 121 a palindrome? true
Is 123 a palindrome? false
*/