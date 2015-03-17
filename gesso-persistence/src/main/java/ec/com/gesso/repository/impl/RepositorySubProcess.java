/**
 * 
 */
package ec.com.gesso.repository.impl;

import ec.com.gesso.model.entity.SubProcess;
import ec.com.gesso.repository.IRepositoryEntity;
import ec.com.gesso.repository.exception.ValidationEntity;



/**
 * @author Gabriel
 *
 */
public class RepositorySubProcess implements IRepositoryEntity<SubProcess> {

	private IRepositoryEntity<SubProcess> repositoryEntity;

	/*
	 * (non-Javadoc)
	 * @see ec.com.gesso.repository.IRepositoryEntity#create(java.io.Serializable)
	 */
	public SubProcess create(SubProcess subProcess) {
		
		if (null == subProcess) {
			throw new ValidationEntity("No se puede insert un valor null");
		}
		if (null == subProcess.getName()) {
			throw new ValidationEntity("El campo name es null");
		}
		
		if (null == subProcess.getDescription()) {
			throw new ValidationEntity("El campo Description es null");
		}

		return this.repositoryEntity.create(subProcess);
	}

	/**
	 * @param repositoryEntity the repositoryEntity to set
	 */
	public void setRepositoryEntity(IRepositoryEntity<SubProcess> repositoryEntity) {
		this.repositoryEntity = repositoryEntity;
	}

}
