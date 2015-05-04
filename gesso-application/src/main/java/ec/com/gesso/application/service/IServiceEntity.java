/**
 * 
 */
package ec.com.gesso.application.service;

import java.io.Serializable;

/**
 * @author Gabriel
 *
 */
public interface IServiceEntity<Entity extends Serializable> {
	
	public Entity register(Entity entity);
}
