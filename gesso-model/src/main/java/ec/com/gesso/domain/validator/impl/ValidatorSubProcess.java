/**
 * 
 */
package ec.com.gesso.domain.validator.impl;

import ec.com.gesso.domain.validator.IValidatorEntity;
import ec.com.gesso.model.entity.SubProcess;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class ValidatorSubProcess implements IValidatorEntity<SubProcess> {

	@Override
	public void validate(final SubProcess subProcess) {
		
		if (null == subProcess) {
			throw new ValidationEntity("No se puede insert un valor null");
		}
		if (null == subProcess.getName()) {
			throw new ValidationEntity("El campo name es null");
		}
		
		if (null == subProcess.getDescription()) {
			throw new ValidationEntity("El campo Description es null");
		}
		
	}

}
