package ec.com.gesso.repository.test.integration;

import org.junit.Before;
import org.junit.Test;

import ec.com.gesso.model.entity.Process;
import ec.com.gesso.repository.IRepositoryEntity;

public class TestIntegrationProcess extends AbstractPersistenceIntegration {
	
	private IRepositoryEntity<Process> repositoryProcess;

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		repositoryProcess = (IRepositoryEntity<Process>) applicationContext.getBean("repositoryProcess");
	}

	@Test
	public void testCreate() {
		Process process = new Process();
		process.setDescription("Process1");
		process.setName("Process1");
		repositoryProcess.create(process);
	}

}
