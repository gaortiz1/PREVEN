package ec.com.gesso.repository.test.integration;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import ec.com.gesso.model.entity.ContactData;
import ec.com.gesso.repository.IRepositoryEntity;
@Ignore
public class TestIntegrationContacData extends AbstractRepositoryIntegration {
	
	private IRepositoryEntity<ContactData> repositoryAddress;

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		repositoryAddress = (IRepositoryEntity<ContactData>) applicationContext.getBean("repositoryContactData");
	}

	@Test
	public void testCreate() {
		ContactData contactData = new ContactData();
		contactData.setIdCompany(1l);
		repositoryAddress.create(contactData);
	}

}
