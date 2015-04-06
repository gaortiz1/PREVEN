/**
 * 
 */
package ec.com.gesso.domain.validator.impl;

import ec.com.gesso.domain.validator.IValidatorEntity;
import ec.com.gesso.model.entity.Process;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class ValidatorProcess implements IValidatorEntity<Process> {

	@Override
	public void validate(final Process process) {
		
		if(null == process) {
			throw new ValidationEntity("No se puede insert un valor null");
		}
		if(null == process.getName()) {
			throw new ValidationEntity("El campo name es null");
		}
		
		if(null == process.getDescription()) {
			throw new ValidationEntity("El campo Description es null");
		}
		
	}

}
