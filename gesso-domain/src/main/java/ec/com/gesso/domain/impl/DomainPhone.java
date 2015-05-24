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
	 * @see ec.com.gesso.domain.IDomainEntity#register(java.io.Serializable)
	 */
	public Phone register(final Phone phone) {
		
		this.validarPhone(phone);
		
		if (phone.getId() == null) {
			phone.setState(Boolean.TRUE);
			this.repositoryEntity.add(phone);
		} else{
			this.repositoryEntity.update(phone);
		}
		
		return phone;
	}
	
	private void validarPhone(final Phone phone){
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
	}

}
