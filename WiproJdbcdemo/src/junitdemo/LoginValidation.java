package junitdemo;
import org.junit.Test;
import static org.junit.Assert.*;
public class LoginValidation {
	static class LoginValidator {
        private static final String VALID_USERNAME = "admin";
        private static final String VALID_PASSWORD = "1234";

        public static boolean login(String username, String password) {
            if (username == null || password == null) {
                throw new IllegalArgumentException("Username or password cannot be null");
            }
            if (username.isEmpty() || password.isEmpty()) {
                return false;
            }
            return username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD);
        }
    }
	@Test
    public void testLogin_ValidCredentials() {
        assertTrue(LoginValidator.login("admin", "1234"));
    }
	 @Test
	    public void testLogin_InvalidUsername() {
	        assertFalse(LoginValidator.login("user", "1234"));
	    }
	 @Test
	    public void testLogin_InvalidPassword() {
	        assertFalse(LoginValidator.login("admin", "wrong"));
	    }
	 @Test
	    public void testLogin_InvalidCredentials() {
	        assertFalse(LoginValidator.login("user", "wrong"));
	    }
	 @Test
	    public void testLogin_EmptyUsername() {
	        assertFalse(LoginValidator.login("", "1234"));
	    }

	    
	    @Test
	    public void testLogin_EmptyPassword() {
	        assertFalse(LoginValidator.login("admin", ""));
	    }

	   
	    @Test(expected = IllegalArgumentException.class)
	    public void testLogin_NullUsername() {
	        LoginValidator.login(null, "1234");
	    }
	    @Test(expected = IllegalArgumentException.class)
	    public void testLogin_NullPassword() {
	        LoginValidator.login("admin", null);
	    }

}
