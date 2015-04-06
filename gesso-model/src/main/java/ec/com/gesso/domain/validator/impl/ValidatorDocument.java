/**
 * 
 */
package ec.com.gesso.domain.validator.impl;

import ec.com.gesso.domain.validator.IValidatorEntity;
import ec.com.gesso.model.entity.Document;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class ValidatorDocument implements IValidatorEntity<Document> {

	@Override
	public void validate(final Document document) {
		
		if (null == document) {
			throw new ValidationEntity("No se puede insert un valor null");
		}
		
		if (null == document.getIdDocument()) {
			throw new ValidationEntity("El id del es null");
		}
		
		if (null == document.getValue()) {
			throw new ValidationEntity("El campo value es null");
		}
		
		if (null == document.getIdDocument().getIdTypeDocument()) {
			throw new ValidationEntity("El type document es null");
		}
		
	}

}
