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
	 * @see ec.com.gesso.repository.IRepositoryEntity#create(java.io.Serializable)
	 */
	public Email create(final Email email) {
		
		if (null == email) {
			throw new ValidationEntity("No se puede insert un email null");
		}
		
		if (null == email.getIdContactData()) {
			throw new ValidationEntity("El campo id contact data es null");
		}
		
		if (null == email.getEmailaddess()) {
			throw new ValidationEntity("El campo email es null");
		}
		
		email.setState(Boolean.TRUE);
		
		return this.repositoryEntity.create(email);
	}

}
