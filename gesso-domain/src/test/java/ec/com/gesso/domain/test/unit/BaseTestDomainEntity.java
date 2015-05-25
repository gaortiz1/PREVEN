/**
 * 
 */
package ec.com.gesso.domain.test.unit;

import java.io.Serializable;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ec.com.gesso.domain.IDomainEntity;
import ec.com.gesso.repository.IRepositoryEntity;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
@RunWith(MockitoJUnitRunner.class) 
public abstract class BaseTestDomainEntity<Entity extends Serializable> {
	
	protected IDomainEntity<Entity> domainEntity;
	protected Entity entity;
	@Mock protected IRepositoryEntity<Entity> mockRepositoryEntity;
	
	@Before
	public void setUp() throws Exception {
		this.domainEntity = this.getInstanceDomain();
		this.entity = this.getInstanceEntity();
	}
	
	abstract IDomainEntity<Entity> getInstanceDomain();
	abstract Entity getInstanceEntity();
	
	@Test
	public void shouldRegisterWithFieldsNotNull() {
		this.domainEntity.register(entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void shouldNotRegisterWithParameterNull() {
		this.domainEntity.register(null);
	}
}
