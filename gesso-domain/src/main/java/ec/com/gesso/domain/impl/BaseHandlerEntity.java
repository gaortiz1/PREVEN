/**
 * 
 */
package ec.com.gesso.domain.impl;

import java.io.Serializable;

import ec.com.gesso.domain.IHandlerEntity;
import ec.com.gesso.repository.IRepositoryEntity;

/**
 * @author Gabriel
 *
 */
public abstract class BaseHandlerEntity<Entity extends Serializable> implements IHandlerEntity<Entity> {
	
	protected IRepositoryEntity<Entity> repositoryEntity;
	
	/**
	 * @param repositoryEntity the repositoryEntity to set
	 */
	public final void setRepositoryEntity(final IRepositoryEntity<Entity> repositoryEntity) {
		this.repositoryEntity = repositoryEntity;
	}

}
