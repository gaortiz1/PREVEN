/**
 * 
 */
package ec.com.gesso.application.lang;

import java.io.Serializable;

/**
 * @author Gabriel
 *
 */
public interface IEntityBuilder<Entity extends Serializable> {
	
	public Entity build() ;

}
