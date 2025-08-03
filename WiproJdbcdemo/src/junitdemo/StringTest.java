package junitdemo;
import org.junit.Test;
import static org.junit.Assert.*;
public class StringTest {
	static class StringUtils {
        public static String reverse(String input) {
            if (input == null) {
                throw new IllegalArgumentException("Input cannot be null");
            }
            return new StringBuilder(input).reverse().toString();
        }
    }
	 @Test(expected = IllegalArgumentException.class)
	    public void testReverse_NullInput_ThrowsException() {
	        StringUtils.reverse(null);
	    }
	 @Test
	    public void testReverse_EmptyString_ReturnsEmpty() {
	        assertEquals("", StringUtils.reverse(""));
	    }
	 @Test
	    public void testReverse_NormalString() {
	        assertEquals("olleh", StringUtils.reverse("hello"));
	        assertEquals("321cba", StringUtils.reverse("abc123"));
	        assertEquals("!dlroW ,olleH", StringUtils.reverse("Hello, World!"));
	    }

}
