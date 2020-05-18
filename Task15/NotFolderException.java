package Task15;

public class NotFolderException extends Exception {
    public NotFolderException() {
    }

    public NotFolderException(String message) {
        super(message);
    }

    public NotFolderException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFolderException(Throwable cause) {
        super(cause);
    }
}
