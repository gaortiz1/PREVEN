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
	
	void update(Entity entity);
	
	void saveOrUpdate(Entity entity);
}
