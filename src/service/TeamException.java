package service;

/**
 * @Description Custom exception
 */
public class TeamException extends Exception{

    static final long serialVersionUID = -3387514229948L;

    public TeamException() {
    }

    public TeamException(String message) {
        super(message);
    }
}
