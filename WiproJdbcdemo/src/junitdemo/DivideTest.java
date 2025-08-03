package junitdemo;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


class Divider {
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divider cannot be zero");
        }
        return a / b;
    }
}
public class DivideTest {
	 @Test
	    public void testDivide_ValidInput() {
	        assertEquals(2, Divider.divide(10, 5));
	    }

	    @Test
	    public void testDivide_ByZero_ThrowsException() {
	        assertThrows(IllegalArgumentException.class, () -> Divider.divide(10, 0));
	    }

}
