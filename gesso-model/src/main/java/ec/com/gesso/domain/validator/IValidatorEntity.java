/**
 * 
 */
package ec.com.gesso.domain.validator;

import java.io.Serializable;

/**
 * @author Gabriel
 *
 */
public interface IValidatorEntity<Entity extends Serializable> {
	
	void validate(Entity entity);

}
