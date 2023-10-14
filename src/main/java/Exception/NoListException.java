package Exception;

public class NoListException extends Exception {
    private String message;

    public NoListException(String message) {
        super(message);
        this.message = message;
    }
}

