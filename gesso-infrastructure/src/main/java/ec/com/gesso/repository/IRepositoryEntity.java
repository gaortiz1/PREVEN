/**
 * 
 */
package ec.com.gesso.repository;

import java.io.Serializable;


/**
 * @author Gabriel
 *
 */
public interface IRepositoryEntity<Entity extends Serializable> {
	
	Entity add(Entity entity);
	
	Entity update(Entity entity);
	
	Entity addOrUpdate(Entity entity);
}
