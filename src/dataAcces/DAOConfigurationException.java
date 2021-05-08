package dataAcces;

public class DAOConfigurationException extends RuntimeException {
    // Constructor 1
    public DAOConfigurationException(String msg) {
        super(msg);
    }

    // Constructor 2
    public DAOConfigurationException(String msg, Throwable reason) {
        super(msg, reason);
    }

    // Constructor 3
    public DAOConfigurationException(Throwable reason) {
        super(reason);
    }
}
