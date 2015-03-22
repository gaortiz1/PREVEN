/**
 * 
 */
package ec.com.gesso.repository.impl;

import ec.com.gesso.model.entity.Company;
import ec.com.gesso.repository.IRepositoryEntity;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class RepositoryCompany implements IRepositoryEntity<Company> {

	private IRepositoryEntity<Company> repositoryEntity;

	/*
	 * (non-Javadoc)
	 * @see ec.com.gesso.repository.IRepositoryEntity#create(java.io.Serializable)
	 */
	public Company create(final Company company) {
		
		if (null == company) {
			throw new ValidationEntity("No se puede insert un valor null");
		}
		if (null == company.getName()) {
			throw new ValidationEntity("El campo name es null");
		}
		
		if (null == company.getIdTypeCompany()) {
			throw new ValidationEntity("El campo TypeCompany es null");
		}
		
		if (null == company.getIdProductiveSector()) {
			throw new ValidationEntity("El campo ProductiveSector es null");
		}
		
		company.setState(Boolean.TRUE);
		
		return this.repositoryEntity.create(company);
	}

	/**
	 * @param repositoryEntity the repositoryEntity to set
	 */
	public void setRepositoryEntity(IRepositoryEntity<Company> repositoryEntity) {
		this.repositoryEntity = repositoryEntity;
	}

}
