/**
 * 
 */
package ec.com.gesso.repository.test.unit;

import java.io.Serializable;

import org.mockito.Mock;

import ec.com.gesso.repository.IRepositoryEntity;

/**
 * @author Gabriel
 *
 */
public abstract class AbstractTestEntity<Entity extends Serializable> {
	
	@Mock protected IRepositoryEntity<Entity> repositoryWrapper;

}
