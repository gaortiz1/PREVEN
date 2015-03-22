/**
 * 
 */
package ec.com.gesso.repository.impl;

import ec.com.gesso.model.entity.Phone;
import ec.com.gesso.repository.IRepositoryEntity;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class RepositoryPhone implements IRepositoryEntity<Phone> {

	private IRepositoryEntity<Phone> repositoryEntity;

	/*
	 * (non-Javadoc)
	 * @see ec.com.gesso.repository.IRepositoryEntity#create(java.io.Serializable)
	 */
	public Phone create(final Phone phone) {
		
		if (null == phone) {
			throw new ValidationEntity("No se puede insert un valor null");
		}
		
		if (null == phone.getTypePhone()) {
			throw new ValidationEntity("El campo type phone es null");
		}
		
		if (null == phone.getNumber()) {
			throw new ValidationEntity("El campo number es null");
		}
		
		phone.setState(Boolean.TRUE);
		
		return this.repositoryEntity.create(phone);
	}

	/**
	 * @param repositoryEntity the repositoryEntity to set
	 */
	public void setRepositoryEntity(IRepositoryEntity<Phone> repositoryEntity) {
		this.repositoryEntity = repositoryEntity;
	}

}
