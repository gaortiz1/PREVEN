/**
 * 
 */
package ec.com.gesso.application.service.email;

import java.io.Serializable;

/**
 * @author Gabriel
 *
 */
public interface IServiceMail<Entity extends Serializable> {
	
	public void send(Entity entity);

}
