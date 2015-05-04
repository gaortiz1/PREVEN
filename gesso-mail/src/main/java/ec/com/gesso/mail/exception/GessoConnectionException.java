/**
 * 
 */
package ec.com.gesso.mail.exception;


/**
 * @author Gabriel
 *
 */
public class GessoConnectionException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public GessoConnectionException() {
	}
	
	/**
	 * @param cause
	 */
	public GessoConnectionException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor for GessoMailException.
	 * @param msg the detail message
	 */
	public GessoConnectionException(String msg) {
		this(msg, null);
	}

	/**
	 * Constructor for GessoMailException.
	 * @param msg the detail message
	 * @param cause the root cause from the mail API in use
	 */
	public GessoConnectionException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
