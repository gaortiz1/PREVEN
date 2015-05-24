/**
 * 
 */
package ec.com.gesso.repository.exception;

/**
 * @author Gabriel
 *
 */
public class EntityDataValidationException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public EntityDataValidationException() {
        super();
    }
    
    public EntityDataValidationException(String message) {
        super(message);
    }
    
    public EntityDataValidationException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public EntityDataValidationException(Throwable cause) {
        super(cause);
    }

}
