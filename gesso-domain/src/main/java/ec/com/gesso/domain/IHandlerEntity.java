/**
 * 
 */
package ec.com.gesso.domain;

import java.io.Serializable;

/**
 * @author Gabriel
 *
 */
public interface IHandlerEntity<Entity extends Serializable> {
	
	public Entity register(Entity entity);
	
}
