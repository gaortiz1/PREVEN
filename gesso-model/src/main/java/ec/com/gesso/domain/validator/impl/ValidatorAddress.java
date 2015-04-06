/**
 * 
 */
package ec.com.gesso.domain.validator.impl;

import ec.com.gesso.domain.validator.IValidatorEntity;
import ec.com.gesso.model.entity.Address;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class ValidatorAddress implements IValidatorEntity<Address> {

	@Override
	public void validate(final Address address) {
		
		if (null == address) {
			throw new ValidationEntity("No se puede insert un valor null");
		}
		
		if (null == address.getIdContactData()) {
			throw new ValidationEntity("El campo contact data es null");
		}
		
		if (null == address.getNameAddress()) {
			throw new ValidationEntity("El campo nombre es null");
		}
	}

}
