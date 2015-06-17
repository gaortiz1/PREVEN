/**
 * 
 */
package ec.com.gesso.model.notification;

import java.io.Serializable;

/**
 * @author Gabriel
 *
 */
public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String message;
    private final Exception cause;
    private final TypeMessage typeMessage;
    
	/**
	 * @param message
	 * @param cause
	 * @param typeMessage
	 */
	public Message(String message, Exception cause, TypeMessage typeMessage) {
		this.message = message;
		this.cause = cause;
		this.typeMessage = typeMessage;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the cause
	 */
	public Exception getCause() {
		return cause;
	}

	/**
	 * @return the typeMessage
	 */
	public TypeMessage getTypeMessage() {
		return typeMessage;
	}
}
