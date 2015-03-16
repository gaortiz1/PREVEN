/**
 * 
 */
package ec.com.gesso.repository;

import java.io.Serializable;


/**
 * @author Gabriel
 *
 */
public interface IRepositoryEntity<Entity extends Serializable>{
	
	public Entity create(Entity entity);

}
