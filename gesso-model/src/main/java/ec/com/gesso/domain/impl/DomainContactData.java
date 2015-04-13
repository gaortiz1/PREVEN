/**
 * 
 */
package ec.com.gesso.domain.impl;

import ec.com.gesso.domain.IDomainEntity;
import ec.com.gesso.model.entity.Address;
import ec.com.gesso.model.entity.ContactData;
import ec.com.gesso.model.entity.Email;
import ec.com.gesso.model.entity.Phone;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class DomainContactData extends BaseDomainEntity<ContactData> {
	
	private IDomainEntity<Email> domainEmail;
	private IDomainEntity<Address> domainAddress;
	private IDomainEntity<Phone> domainPhone;

	public ContactData create(final ContactData contactData) {
		
		if (null == contactData) {
			throw new ValidationEntity("No se puede insert un valor null");
		}
		
		if(contactData.getIdPerson() == null && contactData.getIdCompany() == null){
			throw new ValidationEntity("El dato de contaco debe tener a una persona o una empresa");
		}
		
		contactData.setState(Boolean.TRUE);
		
		this.repositoryEntity.create(contactData);
		
		if(contactData.getCollectionEmails() != null){
			
			for (final Email email : contactData.getCollectionEmails()){
				email.setIdContactData(contactData.getId());
				this.domainEmail.create(email);
			}
			
		}
		
		if(contactData.getCollectionAddress() != null){
			
			for (final Address address : contactData.getCollectionAddress()){
				address.setIdContactData(contactData.getId());
				this.domainAddress.create(address);
			}
		}
		
		if(contactData.getCollectionPhones() != null){
			
			for (final Phone phone: contactData.getCollectionPhones()) {
				phone.setIdContactData(contactData.getId());
				this.domainPhone.create(phone);
			}
		}
		
		return contactData;
	}

	/**
	 * @param domainEmail the domainEmail to set
	 */
	public final void setDomainEmail(final IDomainEntity<Email> domainEmail) {
		this.domainEmail = domainEmail;
	}

	/**
	 * @param domainAddress the domainAddress to set
	 */
	public final void setDomainAddress(final IDomainEntity<Address> domainAddress) {
		this.domainAddress = domainAddress;
	}

	/**
	 * @param domainPhone the domainPhone to set
	 */
	public final void setDomainPhone(final IDomainEntity<Phone> domainPhone) {
		this.domainPhone = domainPhone;
	}
}
