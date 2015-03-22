/**
 * 
 */
package ec.com.gesso.repository.impl;

import ec.com.gesso.model.entity.ContactData;
import ec.com.gesso.repository.IRepositoryEntity;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class RepositoryContacData implements IRepositoryEntity<ContactData> {

	private IRepositoryEntity<ContactData> repositoryEntity;

	/*
	 * (non-Javadoc)
	 * @see ec.com.gesso.repository.IRepositoryEntity#create(java.io.Serializable)
	 */
	public ContactData create(final ContactData contactData) {
		
		if (null == contactData) {
			throw new ValidationEntity("No se puede insert un valor null");
		}
		
		contactData.setState(Boolean.TRUE);
		
		return this.repositoryEntity.create(contactData);
	}

	/**
	 * @param repositoryEntity the repositoryEntity to set
	 */
	public void setRepositoryEntity(IRepositoryEntity<ContactData> repositoryEntity) {
		this.repositoryEntity = repositoryEntity;
	}

}
