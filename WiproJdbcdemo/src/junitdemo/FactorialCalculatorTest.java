package junitdemo;
import org.junit.Test;
import static org.junit.Assert.*;
public class FactorialCalculatorTest {
	static class FactorialCalculator {
        public static long factorial(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Negative numbers not allowed");
            }
            long result = 1;
            for (int i = 2; i <= n; i++) {
                result *= i;
            }
            return result;
        }
    }
	@Test
    public void testFactorialValidInputs() {
        assertEquals(1, FactorialCalculator.factorial(0));
        assertEquals(1, FactorialCalculator.factorial(1));
        assertEquals(2, FactorialCalculator.factorial(2));
        assertEquals(6, FactorialCalculator.factorial(3));
        assertEquals(24, FactorialCalculator.factorial(4));
        assertEquals(120, FactorialCalculator.factorial(5));
        assertEquals(3628800, FactorialCalculator.factorial(10));
    }
	@Test(expected = IllegalArgumentException.class)
    public void testFactorialNegativeInputThrowsException() {
        FactorialCalculator.factorial(-1);
    }

}
