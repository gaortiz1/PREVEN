package ec.com.gesso.repository.test.integration;

import org.junit.Before;
import org.junit.Test;

import ec.com.gesso.model.entity.Email;
import ec.com.gesso.repository.IRepositoryEntity;

public class TestIntegrationEmail extends AbstractPersistenceIntegration {
	
	private IRepositoryEntity<Email> repositoryProcess;

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		repositoryProcess = (IRepositoryEntity<Email>) applicationContext.getBean("repositoryEmail");
	}

	@Test
	public void testCreate() {
		Email email = new Email();
		email.setIdContactData(1l);
		email.setEmailaddess("email");
		repositoryProcess.create(email);
	}

}
