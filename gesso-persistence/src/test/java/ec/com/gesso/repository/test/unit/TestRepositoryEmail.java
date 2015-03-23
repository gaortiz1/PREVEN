package ec.com.gesso.repository.test.unit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ec.com.gesso.model.entity.Email;
import ec.com.gesso.repository.exception.ValidationEntity;
import ec.com.gesso.repository.impl.RepositoryEmail;

@RunWith(MockitoJUnitRunner.class)
public class TestRepositoryEmail extends AbstractTestEntity<Email>{
	
	private RepositoryEmail repository;
	private final Email entity = new Email();

	@Before
	public void setUp() throws Exception {
		this.repository = new RepositoryEmail();
		this.repository.setRepositoryEntity(repositoryWrapper);
		this.entity.setEmailaddess("asdasdsa");
		this.entity.setIdContactData(1l);
	}

	@Test
	public void testCreateWithFielsNotNull() {
		this.repository.create(entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void testCreateWithFielsEmailaddessNull() {
		this.entity.setEmailaddess(null);
		this.repository.create(this.entity);
	}
}
