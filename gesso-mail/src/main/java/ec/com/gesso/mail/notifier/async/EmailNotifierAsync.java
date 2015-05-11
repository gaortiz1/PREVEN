/**
 * 
 */
package ec.com.gesso.mail.notifier.async;

import org.springframework.scheduling.annotation.Async;

import ec.com.gesso.mail.model.IEmail;
import ec.com.gesso.mail.notifier.IEmailNotifier;

/**
 * @author Gabriel
 *
 */
public class EmailNotifierAsync implements IEmailNotifier {
	
	private IEmailNotifier emailNotifier;

	@Async
	public void send(final IEmail email) {
		this.emailNotifier.send(email);
	}

	/**
	 * @param emailNotifier the emailNotifier to set
	 */
	public void setEmailNotifier(IEmailNotifier emailNotifier) {
		this.emailNotifier = emailNotifier;
	}

}
