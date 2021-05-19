package exception;

public class BusinessException extends Exception {
    // Constructor 1
    public BusinessException(String msg) {
        super(msg);
    }

    // Constructor 2
    public BusinessException(String msg, Throwable reason) {
        super(msg, reason);
    }

    // Constructor 3
    public BusinessException(Throwable reason) {
        super(reason);
    }
}
