package Task13;

public class StudentWasFoundException extends Exception {
    public StudentWasFoundException() {
    }

    public StudentWasFoundException(String message) {
        super(message);
    }

    public StudentWasFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentWasFoundException(Throwable cause) {
        super(cause);
    }
}
