/**
 * 
 */
package ec.com.gesso.domain.impl;

import ec.com.gesso.model.entity.Email;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class DomainEmail extends BaseDomainEntity<Email> {
	
	/*
	 * (non-Javadoc)
	 * @see ec.com.gesso.domain.IDomainEntity#register(java.io.Serializable)
	 */
	public Email register(final Email email) {
		
		this.validarEmail(email);
		
		if (email.getId() == null){
			email.setState(Boolean.TRUE);
			this.repositoryEntity.create(email);
		} else {
			this.repositoryEntity.edit(email);
		}
		
		return email;
	}
	
	private void validarEmail(final Email email) {
		if (null == email) {
			throw new ValidationEntity("No se puede insert un email null");
		}
		
		if (null == email.getIdContactData()) {
			throw new ValidationEntity("El campo id contact data es null");
		}
		
		if (null == email.getEmailaddess()) {
			throw new ValidationEntity("El campo email es null");
		}
	}
}
