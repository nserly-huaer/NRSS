package Main.usetwoyinshu_api;


public class ZeroNumberException extends Exception {
    private final String ExceptionMessage;

    public ZeroNumberException(String ExceptionMessage) {
        super(ExceptionMessage);
        this.ExceptionMessage = ExceptionMessage;
    }
}
