package ec.com.gesso.repository.test.unit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ec.com.gesso.model.entity.ContactData;
import ec.com.gesso.repository.impl.RepositoryContactData;

@RunWith(MockitoJUnitRunner.class)
public class TestRepositoryContactData extends AbstractTestEntity<ContactData>{
	
	private RepositoryContactData repository;
	private final ContactData entity = new ContactData();

	@Before
	public void setUp() throws Exception {
		this.repository = new RepositoryContactData();
		this.repository.setRepositoryEntity(repositoryWrapper);
		this.entity.setIdCompany(1l);
	}

	@Test
	public void testCreateWithFielsNotNull() {
		this.repository.create(entity);
	}
}
