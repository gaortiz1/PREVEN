/**
 * 
 */
package ec.com.gesso.domain.impl;

import java.io.Serializable;

import ec.com.gesso.domain.IDomainEntity;
import ec.com.gesso.repository.IRepositoryEntity;

/**
 * @author Gabriel
 *
 */
public abstract class BaseDomainEntity<Entity extends Serializable> implements IDomainEntity<Entity> {
	
	protected IRepositoryEntity<Entity> repositoryEntity;
	
	/**
	 * @param repositoryEntity the repositoryEntity to set
	 */
	public final void setRepositoryEntity(final IRepositoryEntity<Entity> repositoryEntity) {
		this.repositoryEntity = repositoryEntity;
	}

}
