/**
 * 
 */
package ec.com.gesso.mail.notifier;

import ec.com.gesso.mail.model.IEmail;

/**
 * @author Gabriel
 *
 */
public interface IEmailNotifier {
	
	void send(IEmail email);

}
