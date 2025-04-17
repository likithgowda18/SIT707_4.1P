package sit707_week4;

/**
 * Encapsulates login status and message.
 * @author Ahsan Habib
 */
public class LoginStatus {
    private boolean status;
    private String message;

    public LoginStatus(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public boolean isLoginSuccess() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}