/**
 * 
 */
package ec.com.gesso.domain.impl;

import ec.com.gesso.model.entity.ScheduleWork;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class HandlerScheduleWork extends BaseHandlerEntity<ScheduleWork> {
	
	/*
	 * (non-Javadoc)
	 * @see ec.com.gesso.domain.IHandlerEntity#register(java.io.Serializable)
	 */
	public ScheduleWork register(final ScheduleWork scheduleWork) {
		
		this.validarScheduleWork(scheduleWork);
		
		if (scheduleWork.getState() == null) {
			scheduleWork.setState(Boolean.TRUE);
		}
		
		return this.repositoryEntity.addOrUpdate(scheduleWork);
	}
	
	private void validarScheduleWork(final ScheduleWork scheduleWork) {
		
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
	}
}
