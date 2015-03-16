package ec.com.gesso.repository.test.integration;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ec.com.gesso.model.entity.Process;
import ec.com.gesso.repository.IRepositoryEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:ec/com/gesso/repository/test/integration/geso-transactions.xml",
		"classpath:ec/com/gesso/repository/test/integration/gesso-persistencia.xml",
		"classpath:ec/com/gesso/repository/test/integration/gesso-repository.xml" })
public class TestIntegrationPersistence {
	
	private IRepositoryEntity<Process> repositoryProcess;
	@Autowired private ApplicationContext applicationContext;

	@Before
	public void setUp() throws Exception {
		repositoryProcess = (IRepositoryEntity<Process>) applicationContext.getBean("repositoryProcess");
	}

	@Test
	public void testCreate() {
		Process process = new Process();
		process.setDescription(StringUtils.EMPTY);
		process.setName(StringUtils.EMPTY);
		//repositoryProcess.create(process);
	}

}
