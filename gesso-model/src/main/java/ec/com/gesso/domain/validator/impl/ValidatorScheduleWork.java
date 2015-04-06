/**
 * 
 */
package ec.com.gesso.domain.validator.impl;

import ec.com.gesso.domain.validator.IValidatorEntity;
import ec.com.gesso.model.entity.ScheduleWork;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class ValidatorScheduleWork implements IValidatorEntity<ScheduleWork> {

	@Override
	public void validate(ScheduleWork scheduleWork) {
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
