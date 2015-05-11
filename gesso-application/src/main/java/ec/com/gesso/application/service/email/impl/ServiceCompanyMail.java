/**
 * 
 */
package ec.com.gesso.application.service.email.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import ec.com.gesso.application.service.email.IServiceMail;
import ec.com.gesso.mail.model.impl.EmailDefaultFrom;
import ec.com.gesso.mail.model.impl.MessageNotifier;
import ec.com.gesso.mail.notifier.IEmailNotifier;
import ec.com.gesso.model.entity.Company;
import ec.com.gesso.model.entity.ContactData;

/**
 * @author Gabriel
 *
 */
public class ServiceCompanyMail implements IServiceMail<Company> {
	
	private IEmailNotifier emailNotifier;

	public void send(final Company company) {
		final EmailDefaultFrom email = new EmailDefaultFrom();
		email.setSubject("Registró exitoso");
		email.setTo(this.buildEmailaddess(company.getContactDataCollection()));
		
		final StringBuilder builderMessageEmail = new StringBuilder();
		builderMessageEmail.append("La compañia")
		.append(StringUtils.SPACE)
		.append(company.getName())
		.append(StringUtils.SPACE)
		.append("se registró exitosamente en nuestro sistema");
		
		email.setMessage(new MessageNotifier("Estimad@s...", builderMessageEmail.toString()));
		
		emailNotifier.send(email);
	}
	
	private String[] buildEmailaddess(Collection<ContactData> contactDatas){
		
		if (CollectionUtils.isNotEmpty(contactDatas)) {
			final Collection<String> emailsAddresses = new ArrayList<String>();
			for (ContactData contactData : contactDatas) {
				if (CollectionUtils.isNotEmpty(contactData.getCollectionEmails())) {
					for (ec.com.gesso.model.entity.Email entityMail : contactData.getCollectionEmails()) {
						emailsAddresses.add(entityMail.getEmailaddess());
					}
				}
			}
			return emailsAddresses.toArray(new String[]{});
		}
		return ArrayUtils.EMPTY_STRING_ARRAY;
	}

	/**
	 * @param emailNotifier the emailNotifier to set
	 */
	public void setEmailNotifier(IEmailNotifier emailNotifier) {
		this.emailNotifier = emailNotifier;
	}

}
