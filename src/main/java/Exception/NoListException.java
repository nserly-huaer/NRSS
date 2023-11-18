package Exception;

public class NoListException extends Exception {
    private final String message;

    public NoListException(String message) {
        super(message);
        this.message = message;
    }
}

