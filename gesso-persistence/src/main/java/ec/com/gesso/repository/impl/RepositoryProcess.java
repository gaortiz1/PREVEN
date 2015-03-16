/**
 * 
 */
package ec.com.gesso.repository.impl;

import ec.com.gesso.model.entity.Process;
import ec.com.gesso.repository.IRepositoryEntity;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class RepositoryProcess implements IRepositoryEntity<ec.com.gesso.model.entity.Process> {

	private IRepositoryEntity<Process> repositoryEntity;

	/*
	 * (non-Javadoc)
	 * @see ec.com.gesso.repository.IRepositoryEntity#create(java.io.Serializable)
	 */
	public Process create(final Process process) {
		
		if (null == process) {
			throw new ValidationEntity("No se puede insert un valor null");
		}
		if (null == process.getName()) {
			throw new ValidationEntity("El campo name es null");
		}
		
		if (null == process.getDescription()) {
			throw new ValidationEntity("El campo Description es null");
		}
		
		process.setStatus(Boolean.TRUE);

		return repositoryEntity.create(process);
	}

	/**
	 * @param repositoryEntity the repositoryEntity to set
	 */
	public void setRepositoryEntity(IRepositoryEntity<Process> repositoryEntity) {
		this.repositoryEntity = repositoryEntity;
	}

}
