package ec.com.gesso.repository.test.integration;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ec.com.gesso.model.entity.ContactData;
import ec.com.gesso.repository.IRepositoryEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:ec/com/gesso/repository/test/integration/geso-transactions.xml",
		"classpath:ec/com/gesso/repository/test/integration/gesso-persistencia.xml",
		"classpath:ec/com/gesso/repository/test/integration/gesso-repository.xml" })
public class TestIntegrationContacData {
	
	private IRepositoryEntity<ContactData> repositoryAddress;
	@Autowired private ApplicationContext applicationContext;

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		repositoryAddress = (IRepositoryEntity<ContactData>) applicationContext.getBean("repositoryContacData");
	}

	@Test
	public void testCreate() {
		ContactData contactData = new ContactData();
		contactData.setIdAddress(1l);
		contactData.setIdCompany(1l);
		contactData.setIdEmail(1l);
		contactData.setIdAddress(3l);
		repositoryAddress.create(contactData);
	}

}
