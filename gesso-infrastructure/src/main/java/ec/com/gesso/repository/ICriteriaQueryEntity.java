/**
 * 
 */
package ec.com.gesso.repository;

import java.io.Serializable;
import java.util.Collection;


/**
 * @author Gabriel
 *
 */
public interface ICriteriaQueryEntity<Entity extends Serializable> {
	
	/**
	 * 
	 * @param entity
	 * @return
	 */
	Entity find(Entity entity);
	
	/**
	 * 
	 * @param entity
	 * @return
	 */
	Collection<Entity> findAll(Entity entity);
}
