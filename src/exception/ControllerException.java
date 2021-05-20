package exception;

public class ControllerException extends Exception {
    // Constructor 1
    public ControllerException(String msg) {
        super(msg);
    }

    // Constructor 2
    public ControllerException(String msg, Throwable reason) {
        super(msg, reason);
    }

    // Constructor 3
    public ControllerException(Throwable reason) {
        super(reason);
    }
}
