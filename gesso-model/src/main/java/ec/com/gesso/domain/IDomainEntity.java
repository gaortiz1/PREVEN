/**
 * 
 */
package ec.com.gesso.domain;

import java.io.Serializable;

/**
 * @author Gabriel
 *
 */
public interface IDomainEntity<Entity extends Serializable> {
	
	public Entity register(Entity entity);
	
}
