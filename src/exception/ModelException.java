package exception;

public class ModelException extends Exception {
    // Constructor 1
    public ModelException(String msg) {
        super(msg);
    }

    // Constructor 2
    public ModelException(String msg, Throwable reason) {
        super(msg, reason);
    }

    // Constructor 3
    public ModelException(Throwable reason) {
        super(reason);
    }
}
