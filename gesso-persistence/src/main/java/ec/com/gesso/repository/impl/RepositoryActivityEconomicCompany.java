package ec.com.gesso.repository.impl;

import ec.com.gesso.model.entity.ActivityEconomicCompany;
import ec.com.gesso.repository.IRepositoryEntity;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * 
 * @author Gabriel
 *
 */
public class RepositoryActivityEconomicCompany implements IRepositoryEntity<ActivityEconomicCompany> {

	private IRepositoryEntity<ActivityEconomicCompany> repositoryEntity;

	/*
	 * (non-Javadoc)
	 * @see ec.com.gesso.repository.IRepositoryEntity#create(java.io.Serializable)
	 */
	public ActivityEconomicCompany create(final ActivityEconomicCompany activityEconomicCompany) {
		
		if (null == activityEconomicCompany) {
			throw new ValidationEntity("No se puede insert un valor null");
		}
		if (null == activityEconomicCompany.getName()) {
			throw new ValidationEntity("El campo name es null");
		}
		
		if (null == activityEconomicCompany.getIdCompany()) {
			throw new ValidationEntity("El campo id compania es null");
		}
		
		activityEconomicCompany.setState(Boolean.TRUE);
		
		return this.repositoryEntity.create(activityEconomicCompany);
	}

	/**
	 * @param repositoryEntity the repositoryEntity to set
	 */
	public void setRepositoryEntity(IRepositoryEntity<ActivityEconomicCompany> repositoryEntity) {
		this.repositoryEntity = repositoryEntity;
	}

}
