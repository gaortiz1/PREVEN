/**
 * 
 */
package ec.com.gesso.mail.notifier;

import ec.com.gesso.mail.model.IModelEmail;

/**
 * @author Gabriel
 *
 */
public interface IEmailNotifier {
	
	void send(IModelEmail modelEmail);

}
