/**
 * 
 */
package ec.com.gesso.model.notification;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;

/**
 * @author Gabriel
 *
 */
public class Notification implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final Collection<Message> errors = new ArrayList<>();
	private final Collection<Message> warnings = new ArrayList<>();

	public void addError(String message, Exception cause) {
		this.errors.add(new Message(message, cause, TypeMessage.ERROR));
	}
	
	public void addWarning(String message) {
		this.errors.add(new Message(message, null, TypeMessage.WARNING));
	}

	public boolean hasErrors() {
		return !this.errors.isEmpty();
	}
	
	public boolean hasWarnings() {
		return !this.warnings.isEmpty();
	}

	public Collection<Message> getErrors() {
		return CollectionUtils.unmodifiableCollection(errors);
	}
	
	public Collection<Message> getWarnings() {
		return CollectionUtils.unmodifiableCollection(warnings);
	}

}