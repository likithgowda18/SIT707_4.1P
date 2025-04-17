package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * @author Ahsan Habib
 */
public class LoginFormTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "223129079"; // Replace with your actual ID
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Likith"; // Replace with your name
        Assert.assertNotNull("Student name is null", studentName);
    }

    // TC1: Empty username and password
    @Test
    public void testEmptyUsernameAndEmptyPassword() {
        LoginStatus status = LoginForm.login(null, null);
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getMessage());
    }

    // TC2: Empty username, wrong password
    @Test
    public void testEmptyUsernameWrongPassword() {
        LoginStatus status = LoginForm.login(null, "wrongpass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getMessage());
    }

    // TC3: Empty username, correct password
    @Test
    public void testEmptyUsernameCorrectPassword() {
        LoginStatus status = LoginForm.login(null, "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getMessage());
    }

    // TC4: Wrong username, empty password
    @Test
    public void testWrongUsernameEmptyPassword() {
        LoginStatus status = LoginForm.login("wrong", null);
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Password", status.getMessage());
    }

    // TC5: Correct username, empty password
    @Test
    public void testCorrectUsernameEmptyPassword() {
        LoginStatus status = LoginForm.login("ahsan", null);
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Password", status.getMessage());
    }

    // TC6: Wrong username, wrong password
    @Test
    public void testWrongUsernameWrongPassword() {
        LoginStatus status = LoginForm.login("wrong", "wrongpass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getMessage());
    }

    // TC7: Correct username, wrong password
    @Test
    public void testCorrectUsernameWrongPassword() {
        LoginStatus status = LoginForm.login("ahsan", "wrongpass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getMessage());
    }

    // TC8: Wrong username, correct password
    @Test
    public void testWrongUsernameCorrectPassword() {
        LoginStatus status = LoginForm.login("wrong", "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getMessage());
    }

    // TC9: Valid login but empty validation code
    @Test
    public void testValidLoginButEmptyValidationCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertFalse(LoginForm.validateCode(null));
    }

    // TC10: Valid login but wrong validation code
    @Test
    public void testValidLoginButWrongValidationCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertFalse(LoginForm.validateCode("wrongcode"));
    }

    // TC11: Valid login and correct validation code
    @Test
    public void testValidLoginAndCorrectValidationCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertTrue(LoginForm.validateCode(status.getMessage())); // should return "123456"
    }
}