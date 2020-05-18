package Task15;

public class FolderException extends Exception {
    public FolderException() {
    }

    public FolderException(String message) {
        super(message);
    }

    public FolderException(String message, Throwable cause) {
        super(message, cause);
    }

    public FolderException(Throwable cause) {
        super(cause);
    }
}
