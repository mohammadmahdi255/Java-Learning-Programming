package exceptions;

// checked -> Exceptions
// unchecked (runtime) -> RuntimeExceptions

public class InsufficientFundsException extends Exception {

    public InsufficientFundsException() {
        super("Insufficient funds in your account");
    }

    public InsufficientFundsException(String message) {
        super(message);
    }

}
