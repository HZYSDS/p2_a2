package model.Exceptions;

public class InvalidCredentialsException extends Exception {

    // 默认构造函数
    public InvalidCredentialsException() {
        super("Invalid username or password.",new Throwable("nnnnnn"));
    }

    // 带有消息参数的构造函数
    public InvalidCredentialsException(String message) {
        super(message);
    }

    // 带有消息和原因的构造函数
    public InvalidCredentialsException(String message, Throwable cause) {
        super(message, cause);
    }

    // 带有原因的构造函数
    public InvalidCredentialsException(Throwable cause) {
        super(cause);
    }



}
