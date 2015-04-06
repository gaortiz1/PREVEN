/**
 * 
 */
package ec.com.gesso.domain.validator.impl;

import ec.com.gesso.domain.validator.IValidatorEntity;
import ec.com.gesso.model.entity.Job;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class ValidatorJob implements IValidatorEntity<Job> {

	@Override
	public void validate(final Job job) {
		
		if (null == job) {
			throw new ValidationEntity("No se puede insert un valor null");
		}
		if (null == job.getName()) {
			throw new ValidationEntity("El campo name es null");
		}
		
		if (null == job.getDescription()) {
			throw new ValidationEntity("El campo Description es null");
		}
		
	}

}
