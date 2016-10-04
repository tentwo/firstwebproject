package despina.general.exceptions;

/**
 * Created by ASUS on 9/14/2016.
 */
public class ExceptionORM extends Exception {

    public ExceptionORM() {
        super();
    }

    public ExceptionORM(String message) {
        super(message);
    }

    public ExceptionORM(Throwable throwable) {
        super(throwable.getMessage());
    }
}
