/**
 * 
 */
package ec.com.gesso.repository.exception;

/**
 * @author Gabriel
 *
 */
public class ValidationEntity extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValidationEntity(String message) {
        super(message);
    }

}
