package Main.RunMainSoft;

public class CannotFindException extends Exception {
    private final String message;

    public CannotFindException(String message) {
        super(message);
        this.message = message;
    }
}
