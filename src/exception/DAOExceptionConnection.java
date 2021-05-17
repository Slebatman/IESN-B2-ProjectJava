package exception;

public class DAOExceptionConnection extends RuntimeException {
    // Constructor 1
    public DAOExceptionConnection(String msg) {
        super(msg);
    }

    // Constructor 2
    public DAOExceptionConnection(String msg, Throwable reason) {
       super(msg, reason);
    }

    // Constructor 3
    public DAOExceptionConnection(Throwable reason) {
        super(reason);
    }
}
