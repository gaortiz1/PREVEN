/**
 * 
 */
package ec.com.gesso.domain.test.unit;

import org.junit.Test;

import ec.com.gesso.domain.validator.impl.ValidatorCompany;
import ec.com.gesso.model.entity.Company;

/**
 * @author Gabriel
 *
 */
public class TestValidationEntity {
	
	@Test
	public void validateEntity(){
		ValidatorCompany validatorCompany = new ValidatorCompany();
		validatorCompany.validate(new Company());
	}

}
