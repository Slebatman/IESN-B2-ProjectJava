package dataAcces;

public class DAOException extends Exception {
    // Constructor 1
    public DAOException(String msg) {
        super(msg);
    }

    // Constructor 2
    public DAOException(String msg, Throwable reason) {
       super(msg, reason);
    }

    // Constructor 3
    public DAOException(Throwable reason) {
        super(reason);
    }
}
