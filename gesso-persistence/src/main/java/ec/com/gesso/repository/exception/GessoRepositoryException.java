/**
 * 
 */
package ec.com.gesso.repository.exception;

/**
 * @author Gabriel
 *
 */
public class GessoRepositoryException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public GessoRepositoryException() {
        super();
    }
    
    public GessoRepositoryException(String message) {
        super(message);
    }
    
    public GessoRepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public GessoRepositoryException(Throwable cause) {
        super(cause);
    }

}
