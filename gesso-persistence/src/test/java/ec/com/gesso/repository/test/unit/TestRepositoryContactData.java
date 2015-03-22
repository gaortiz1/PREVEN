package ec.com.gesso.repository.test.unit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ec.com.gesso.model.entity.ContactData;
import ec.com.gesso.repository.impl.RepositoryContacData;

@RunWith(MockitoJUnitRunner.class)
public class TestRepositoryContactData extends AbstractTestEntity<ContactData>{
	
	private RepositoryContacData repository;
	private final ContactData entity = new ContactData();

	@Before
	public void setUp() throws Exception {
		this.repository = new RepositoryContacData();
		this.repository.setRepositoryEntity(repositoryWrapper);
		this.entity.setIdAddress(1l);
		this.entity.setIdCompany(1l);
		this.entity.setIdEmail(1l);
		this.entity.setIdAddress(2l);
	}

	@Test
	public void testCreateWithFielsNotNull() {
		this.repository.create(entity);
	}
}
