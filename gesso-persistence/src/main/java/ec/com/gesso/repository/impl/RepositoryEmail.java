/**
 * 
 */
package ec.com.gesso.repository.impl;

import ec.com.gesso.model.entity.Email;
import ec.com.gesso.repository.IRepositoryEntity;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class RepositoryEmail implements IRepositoryEntity<Email> {

	private IRepositoryEntity<Email> repositoryEntity;

	/*
	 * (non-Javadoc)
	 * @see ec.com.gesso.repository.IRepositoryEntity#create(java.io.Serializable)
	 */
	public Email create(final Email email) {
		
		if (null == email) {
			throw new ValidationEntity("No se puede insert un valor null");
		}
		if (null == email.getEmailaddess()) {
			throw new ValidationEntity("El campo email es null");
		}
		
		email.setState(Boolean.TRUE);
		
		return this.repositoryEntity.create(email);
	}

	/**
	 * @param repositoryEntity the repositoryEntity to set
	 */
	public void setRepositoryEntity(IRepositoryEntity<Email> repositoryEntity) {
		this.repositoryEntity = repositoryEntity;
	}

}
