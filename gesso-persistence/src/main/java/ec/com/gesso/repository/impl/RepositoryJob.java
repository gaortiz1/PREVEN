/**
 * 
 */
package ec.com.gesso.repository.impl;

import ec.com.gesso.model.entity.Job;
import ec.com.gesso.repository.IRepositoryEntity;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class RepositoryJob implements IRepositoryEntity<Job> {

	private IRepositoryEntity<Job> repositoryEntity;

	/*
	 * (non-Javadoc)
	 * @see ec.com.gesso.repository.IRepositoryEntity#create(java.io.Serializable)
	 */
	public Job create(Job job) {
		
		if (null == job) {
			throw new ValidationEntity("No se puede insert un valor null");
		}
		if (null == job.getName()) {
			throw new ValidationEntity("El campo name es null");
		}
		
		if (null == job.getDescription()) {
			throw new ValidationEntity("El campo Description es null");
		}

		return repositoryEntity.create(job);
	}

	/**
	 * @param repositoryEntity the repositoryEntity to set
	 */
	public void setRepositoryEntity(IRepositoryEntity<Job> repositoryEntity) {
		this.repositoryEntity = repositoryEntity;
	}

}
