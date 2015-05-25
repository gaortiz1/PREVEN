/**
 * 
 */
package ec.com.gesso.domain.impl;

import ec.com.gesso.domain.IHandlerEntity;
import ec.com.gesso.model.entity.Address;
import ec.com.gesso.model.entity.ContactData;
import ec.com.gesso.model.entity.Email;
import ec.com.gesso.model.entity.Phone;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class HandlerContactData extends BaseHandlerEntity<ContactData> {
	
	private IHandlerEntity<Email> handlerEmail;
	private IHandlerEntity<Address> handlerAddress;
	private IHandlerEntity<Phone> handlerPhone;
	
	public ContactData register(final ContactData contactData) {
		
		this.validarContactData(contactData);
		
		if (contactData.getId() == null) {
			contactData.setState(Boolean.TRUE);
			this.repositoryEntity.add(contactData);
		} else {
			this.repositoryEntity.update(contactData);
		}
		
		if(contactData.getCollectionEmails() != null){
			
			for (final Email email : contactData.getCollectionEmails()){
				email.setIdContactData(contactData.getId());
				this.handlerEmail.register(email);
			}
			
		}
		
		if(contactData.getCollectionAddress() != null){
			
			for (final Address address : contactData.getCollectionAddress()){
				address.setIdContactData(contactData.getId());
				this.handlerAddress.register(address);
			}
		}
		
		if(contactData.getCollectionPhones() != null){
			
			for (final Phone phone: contactData.getCollectionPhones()) {
				phone.setIdContactData(contactData.getId());
				this.handlerPhone.register(phone);
			}
		}
		return contactData;
	}
	
	private void validarContactData(final ContactData contactData){
		if (null == contactData) {
			throw new ValidationEntity("No se puede insert un valor null");
		}
		
		if(contactData.getIdPerson() == null && contactData.getIdCompany() == null){
			throw new ValidationEntity("El dato de contaco debe tener a una persona o una empresa");
		}
	}

	/**
	 * @param handlerEmail the handlerEmail to set
	 */
	public void setHandlerEmail(IHandlerEntity<Email> handlerEmail) {
		this.handlerEmail = handlerEmail;
	}

	/**
	 * @param handlerAddress the handlerAddress to set
	 */
	public void setHandlerAddress(IHandlerEntity<Address> handlerAddress) {
		this.handlerAddress = handlerAddress;
	}

	/**
	 * @param handlerPhone the handlerPhone to set
	 */
	public void setHandlerPhone(IHandlerEntity<Phone> handlerPhone) {
		this.handlerPhone = handlerPhone;
	}
}
