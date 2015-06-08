package ec.com.gesso.application.lang;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.apache.commons.collections4.CollectionUtils;

import ec.com.gesso.model.entity.Address;
import ec.com.gesso.model.entity.ContactData;
import ec.com.gesso.model.entity.Email;
import ec.com.gesso.model.entity.Phone;

/**
 * 
 * @author Gabriel
 *
 */
public class ContactDataBuilder {
	
	private Collection<Address> addresses = new ArrayList<Address>();
	private Collection<Phone> phones = new ArrayList<Phone>();
	private Collection<Email> emails = new ArrayList<Email>();

	public ContactDataBuilder addEmail(Long id, String emailaddess) {
		final Email email = new Email();
		email.setId(id);
		email.setEmailaddess(emailaddess);
		this.emails.add(email);
		return this;
	}
	
	public ContactDataBuilder addAddress(Long id, String nameAddress) {
		final Address address = new Address();
		address.setId(id);
		address.setNameAddress(nameAddress);
		this.addresses.add(address);
		return this;
	}

	public ContactDataBuilder addPhone(Long id, String number, String idtypePhone) {
		final Phone phone = new Phone();
		phone.setId(id);
		phone.setNumber(number);
		phone.setIdtypePhone(idtypePhone);
		this.phones.add(phone);
		return this;
	}
	
	public ContactData build(){
		final ContactData contactData = new ContactData();
		
		if (CollectionUtils.isNotEmpty(this.emails)){
			contactData.setEmails(new HashSet<Email>());
			for (final Email email : this.emails) {
				contactData.getEmails().add(email);
			}
		}
		
		if (CollectionUtils.isNotEmpty(this.addresses)) {
			contactData.setAddresses(new HashSet<Address>());
			for (final Address address : this.addresses) {
				contactData.getAddresses().add(address);
			}
		}
		
		if (CollectionUtils.isNotEmpty(this.phones)) {
			contactData.setPhones(new HashSet<Phone>());
			for (final Phone phone : this.phones) {
				contactData.getPhones().add(phone);
			}
		}
		
		return contactData;
	}
	
}
