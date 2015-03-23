/**
 * 
 */
package ec.com.gesso.domain.impl;

import ec.com.gesso.domain.IDomainEntity;
import ec.com.gesso.model.entity.Address;
import ec.com.gesso.model.entity.ContactData;
import ec.com.gesso.model.entity.Email;
import ec.com.gesso.model.entity.Phone;
import ec.com.gesso.repository.IRepositoryEntity;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class DomainContactData implements IDomainEntity<ContactData> {
	
	private IRepositoryEntity<ContactData> repositoryContactData;
	private IRepositoryEntity<Email> repositoryEmail;
	private IRepositoryEntity<Address> repositoryAddress;
	private IRepositoryEntity<Phone> repositoryPhone;

	public ContactData create(ContactData contactData) {
		
		if(contactData.getIdPerson() == null && contactData.getIdCompany() == null){
			throw new ValidationEntity("El dato de contaco debe tener a una persona o una empresa");
		}
		
		this.repositoryContactData.create(contactData);
		
		if(contactData.getCollectionEmails() != null){
			
			for (final Email email : contactData.getCollectionEmails()){
				email.setIdContactData(contactData.getId());
				this.repositoryEmail.create(email);
			}
			
		}
		
		if(contactData.getCollectionAddress() != null){
			
			for (final Address address : contactData.getCollectionAddress()){
				address.setIdContactData(contactData.getId());
				this.repositoryAddress.create(address);
			}
		}
		
		if(contactData.getCollectionPhones() != null){
			
			for (final Phone phone: contactData.getCollectionPhones()) {
				phone.setIdContactData(contactData.getId());
				this.repositoryPhone.create(phone);
			}
		}
		
		return contactData;
	}

	/**
	 * @param repositoryContactData the repositoryContactData to set
	 */
	public void setRepositoryContactData(IRepositoryEntity<ContactData> repositoryContactData) {
		this.repositoryContactData = repositoryContactData;
	}

	/**
	 * @param repositoryEmail the repositoryEmail to set
	 */
	public void setRepositoryEmail(IRepositoryEntity<Email> repositoryEmail) {
		this.repositoryEmail = repositoryEmail;
	}

	/**
	 * @param repositoryAddress the repositoryAddress to set
	 */
	public void setRepositoryAddress(IRepositoryEntity<Address> repositoryAddress) {
		this.repositoryAddress = repositoryAddress;
	}

	/**
	 * @param repositoryPhone the repositoryPhone to set
	 */
	public void setRepositoryPhone(IRepositoryEntity<Phone> repositoryPhone) {
		this.repositoryPhone = repositoryPhone;
	}
}
