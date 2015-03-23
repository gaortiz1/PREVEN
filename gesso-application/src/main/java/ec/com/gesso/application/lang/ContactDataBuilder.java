package ec.com.gesso.application.lang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import ec.com.gesso.model.entity.Address;
import ec.com.gesso.model.entity.ContactData;
import ec.com.gesso.model.entity.Document;
import ec.com.gesso.model.entity.DocumentPK;
import ec.com.gesso.model.entity.Email;
import ec.com.gesso.model.entity.Phone;

/**
 * 
 * @author Gabriel
 *
 */
public class ContactDataBuilder {
	
	private Set<String> emails = new TreeSet<String>();
	private Set<String> address = new TreeSet<String>();
	private Map<String, String> phones = new HashMap<String, String>();

	public ContactDataBuilder addEmail(String email) {
		this.emails.add(email);
		return this;
	}
	
	public ContactDataBuilder addAddress(String address) {
		this.address.add(address);
		return this;
	}

	public ContactDataBuilder addPhone(String number, String idtypePhone) {
		this.phones.put(number, idtypePhone);
		return this;
	}
	
	public ContactData build(){
		final ContactData contactData = new ContactData();
		
		if (!this.emails.isEmpty()){
			contactData.setCollectionEmails(new ArrayList<Email>());
			for (final String nameEmail : this.emails) {
				Email email = new Email();
				email.setEmailaddess(nameEmail);
				contactData.getCollectionEmails().add(email);
			}
		}
		
		if (!this.address.isEmpty()) {
			contactData.setCollectionAddress(new ArrayList<Address>());
			for (final String nameAddress : this.address) {
				Address address = new Address();
				address.setNameAddress(nameAddress);
				contactData.getCollectionAddress().add(address);
			}
		}
		
		if (!this.phones.isEmpty()) {
			contactData.setCollectionPhones(new ArrayList<Phone>());
			for (final Map.Entry<String,String> entryPhone : this.phones.entrySet()) {
				final Phone phone = new Phone();
				phone.setIdtypePhone(entryPhone.getValue());
				phone.setNumber(entryPhone.getKey());
				contactData.getCollectionPhones().add(phone);
			}
		}
		
		return contactData;
	}
	
}
