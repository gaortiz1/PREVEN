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
	
	public void edit(Entity entity);
	
	public void saveOrUpdate(Entity entity);

}
