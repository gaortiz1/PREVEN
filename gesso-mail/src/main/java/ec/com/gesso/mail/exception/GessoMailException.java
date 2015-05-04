/**
 * 
 */
package ec.com.gesso.mail.exception;


/**
 * @author Gabriel
 *
 */
public class GessoMailException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public GessoMailException() {
	}
	
	/**
	 * @param cause
	 */
	public GessoMailException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor for GessoMailException.
	 * @param msg the detail message
	 */
	public GessoMailException(String msg) {
		this(msg, null);
	}

	/**
	 * Constructor for GessoMailException.
	 * @param msg the detail message
	 * @param cause the root cause from the mail API in use
	 */
	public GessoMailException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
