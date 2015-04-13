/**
 * 
 */
package ec.com.gesso.domain.test.unit;

import java.io.Serializable;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import ec.com.gesso.domain.IDomainEntity;
import ec.com.gesso.repository.IRepositoryEntity;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
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
	public void shouldCreateWithFieldsNotNull() {
		this.domainEntity.create(entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void shouldNotCreateWithParameterNull() {
		this.domainEntity.create(null);
	}
}
