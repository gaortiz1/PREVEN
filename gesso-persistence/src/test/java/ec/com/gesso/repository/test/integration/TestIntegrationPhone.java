package ec.com.gesso.repository.test.integration;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import ec.com.gesso.model.entity.Phone;
import ec.com.gesso.repository.IRepositoryEntity;
@Ignore
public class TestIntegrationPhone extends AbstractRepositoryIntegration {
	
	private IRepositoryEntity<Phone> repositoryPhone;

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
