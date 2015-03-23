package ec.com.gesso.repository.test.integration;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ec.com.gesso.model.entity.Phone;
import ec.com.gesso.repository.IRepositoryEntity;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:ec/com/gesso/repository/test/integration/geso-transactions.xml",
		"classpath:ec/com/gesso/repository/test/integration/gesso-persistencia.xml",
		"classpath:ec/com/gesso/repository/test/integration/gesso-repository.xml" })
public class TestIntegrationPhone {
	
	private IRepositoryEntity<Phone> repositoryPhone;
	@Autowired private ApplicationContext applicationContext;

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		repositoryPhone = (IRepositoryEntity<Phone>) applicationContext.getBean("repositoryPhone");
	}

	@Test
	public void testCreate() {
		Phone phone = new Phone();
		phone.setIdContactData(1l);
		phone.setNumber("009090809");
		phone.setIdtypePhone("CEL");
		repositoryPhone.create(phone);
	}

}
