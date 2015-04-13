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
	 * @see ec.com.gesso.repository.IRepositoryEntity#create(java.io.Serializable)
	 */
	public Address create(final Address address) {
		
		if (null == address) {
			throw new ValidationEntity("No se puede insert un valor null");
		}
		
		if (null == address.getIdContactData()) {
			throw new ValidationEntity("El campo contact data es null");
		}
		
		if (null == address.getNameAddress()) {
			throw new ValidationEntity("El campo nombre es null");
		}
		
		address.setState(Boolean.TRUE);
		
		return this.repositoryEntity.create(address);
	}

}
