/**
 * 
 */
package ec.com.gesso.repository.impl;

import ec.com.gesso.model.entity.Address;
import ec.com.gesso.repository.IRepositoryEntity;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class RepositoryAddress implements IRepositoryEntity<Address> {

	private IRepositoryEntity<Address> repositoryEntity;

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

	/**
	 * @param repositoryEntity the repositoryEntity to set
	 */
	public void setRepositoryEntity(IRepositoryEntity<Address> repositoryEntity) {
		this.repositoryEntity = repositoryEntity;
	}

}
