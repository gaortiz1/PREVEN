package ec.com.gesso.repository.test.integration;

import org.junit.Before;
import org.junit.Test;

import ec.com.gesso.model.entity.Address;
import ec.com.gesso.repository.IRepositoryEntity;


public class TestIntegrationAddress extends AbstractPersistenceIntegration {
	
	private IRepositoryEntity<Address> repositoryAddress;

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		repositoryAddress = (IRepositoryEntity<Address>) applicationContext.getBean("repositoryAddress");
	}

	@Test
	public void testCreate() {
		Address address = new Address();
		address.setIdContactData(1l);
		address.setNameAddress("address 1");
		repositoryAddress.create(address);
	}

}
