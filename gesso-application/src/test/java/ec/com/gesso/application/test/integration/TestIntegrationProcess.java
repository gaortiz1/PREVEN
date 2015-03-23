package ec.com.gesso.application.test.integration;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ec.com.gesso.application.service.IServiceEntity;
import ec.com.gesso.model.entity.Process;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"gesso-transactions.xml",
		"gesso-persistencia.xml",
		"gesso-repository.xml",
		"gesso-domain.xml",
		"gesso-application.xml" })

public class TestIntegrationProcess {
	
	private IServiceEntity<Process> serviceProcess;
	@Autowired private ApplicationContext applicationContext;

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		this.serviceProcess = (IServiceEntity<Process>) applicationContext.getBean("serviceProcess");
	}

	@Test
	public void testSubLevels() {
		Process process = new Process();
		process.setDescription("Process1");
		process.setName("Process1");
		process.setSubLevels(new ArrayList<Process>());
		
		Process subLevel = new Process();
		subLevel.setDescription("Process1");
		subLevel.setName("Process1");
		
		process.getSubLevels().add(subLevel);
		
		this.serviceProcess.create(process);
	}

}
