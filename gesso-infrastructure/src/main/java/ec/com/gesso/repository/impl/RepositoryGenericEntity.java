package ec.com.gesso.repository.impl;

import java.io.Serializable;
import java.util.Collection;

import ec.com.gesso.criteria.QueryCriteria;
import ec.com.gesso.repository.IOperationEntity;
import ec.com.gesso.repository.IRepositoryEntity;

/**
 * 
 * @author Gabriel
 *
 */
public class RepositoryGenericEntity<Entity extends Serializable> implements IRepositoryEntity<Entity> {
	
	private final IOperationEntity<Entity> operationEntity;
	private final QueryCriteria queryCriteria;

	/**
	 * @param repositoryEntity
	 * @param queryCriteria
	 */
	public RepositoryGenericEntity(final IOperationEntity<Entity> operationEntity, final QueryCriteria queryCriteria) {
		this.operationEntity = operationEntity;
		this.queryCriteria = queryCriteria;
	}

	public final Entity add(Entity entity) {
		return this.operationEntity.add(entity);
	}

	public final Entity update(Entity entity) {
		return this.operationEntity.update(entity);
	}
	
	public final Entity addOrUpdate(Entity entity) {
		return this.operationEntity.addOrUpdate(entity);
	}

	public final Entity find(Entity entity) {
		return this.queryCriteria.find(entity);
	}

	public final Collection<Entity> findAll(Entity entity) {
		return this.queryCriteria.findAll(entity);
	}
}
