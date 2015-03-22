/**
 * 
 */
package ec.com.gesso.repository.impl;

import ec.com.gesso.model.entity.ScheduleWork;
import ec.com.gesso.repository.IRepositoryEntity;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class RepositoryScheduleWork implements IRepositoryEntity<ScheduleWork> {

	private IRepositoryEntity<ScheduleWork> repositoryEntity;

	/*
	 * (non-Javadoc)
	 * @see ec.com.gesso.repository.IRepositoryEntity#create(java.io.Serializable)
	 */
	public ScheduleWork create(final ScheduleWork scheduleWork) {
		
		if (null == scheduleWork) {
			throw new ValidationEntity("No se puede insert un valor null");
		}
		if (null == scheduleWork.getIdScheduleWork()) {
			throw new ValidationEntity("El campo id ScheduleWork es null");
		}
		
		if (null == scheduleWork.getIdScheduleWork().getIdCompany()) {
			throw new ValidationEntity("El campo id company es null");
		}
		
		if (null == scheduleWork.getIdScheduleWork().getIdBusinessHour()) {
			throw new ValidationEntity("El campo id business hours es null");
		}
		
		scheduleWork.setState(Boolean.TRUE);
		
		return this.repositoryEntity.create(scheduleWork);
	}

	/**
	 * @param repositoryEntity the repositoryEntity to set
	 */
	public void setRepositoryEntity(IRepositoryEntity<ScheduleWork> repositoryEntity) {
		this.repositoryEntity = repositoryEntity;
	}

}
