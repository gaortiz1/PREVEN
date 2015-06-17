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
public class HandlerPhone extends BaseHandlerEntity<Phone> {
	
	/*
	 * (non-Javadoc)
	 * @see ec.com.gesso.domain.IHandlerEntity#register(java.io.Serializable)
	 */
	public Phone register(final Phone phone) {
		
		this.validarPhone(phone);
		phone.setState(Boolean.TRUE);
		if (phone.getId() == null) {
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
