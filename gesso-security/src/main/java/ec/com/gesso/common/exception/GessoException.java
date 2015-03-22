package ec.com.gesso.common.exception;

/**
 * @author roberto
 *
 */
@SuppressWarnings("serial")
public class GessoException extends Exception{

	public GessoException() {
		super();
	}

	public GessoException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public GessoException(String message, Throwable cause) {
		super(message, cause);
	}

	public GessoException(String message) {
		super(message);
	}

	public GessoException(Throwable cause) {
		super(cause);
	}

}
