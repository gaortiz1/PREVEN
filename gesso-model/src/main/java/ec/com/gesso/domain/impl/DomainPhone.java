/**
 * 
 */
package ec.com.gesso.domain.impl;

import ec.com.gesso.model.entity.Phone;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class DomainPhone extends BaseDomainEntity<Phone> {

	/*
	 * (non-Javadoc)
	 * @see ec.com.gesso.repository.IRepositoryEntity#create(java.io.Serializable)
	 */
	public Phone create(final Phone phone) {
		
		if (null == phone) {
			throw new ValidationEntity("No se puede insert un valor null");
		}
		
		if (null == phone.getIdtypePhone()) {
			throw new ValidationEntity("El campo type phone es null");
		}
		
		if (null == phone.getIdContactData()) {
			throw new ValidationEntity("El campo contact data es null");
		}
		
		if (null == phone.getNumber()) {
			throw new ValidationEntity("El campo number es null");
		}
		
		phone.setState(Boolean.TRUE);
		
		return this.repositoryEntity.create(phone);
	}

}
