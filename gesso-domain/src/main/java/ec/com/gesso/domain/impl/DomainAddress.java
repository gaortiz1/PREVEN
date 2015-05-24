/**
 * 
 */
package ec.com.gesso.domain.impl;

import ec.com.gesso.model.entity.Address;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class DomainAddress extends BaseDomainEntity<Address> {
	
	/*
	 * (non-Javadoc)
	 * @see ec.com.gesso.domain.IDomainEntity#register(java.io.Serializable)
	 */
	public Address register(final Address address) {
		
		this.validarAddress(address);
		
		if (address.getId() == null) {
			address.setState(Boolean.TRUE);
			this.repositoryEntity.add(address);
		} else{
			this.repositoryEntity.update(address);
		}
		
		return address;
	}
	
	private void validarAddress(final Address address) {
		if (null == address) {
			throw new ValidationEntity("No se puede insert un valor null");
		}
		
		if (null == address.getIdContactData()) {
			throw new ValidationEntity("El campo contact data es null");
		}
		
		if (null == address.getNameAddress()) {
			throw new ValidationEntity("El campo nombre es null");
		}
	}
	
}
