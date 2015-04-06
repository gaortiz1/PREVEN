package ec.com.gesso.application.test.integration;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import ec.com.gesso.application.service.IServiceEntity;
import ec.com.gesso.model.entity.Process;

public class TestIntegrationProcess extends AbstractApplicationIntegration {
	
	private IServiceEntity<Process> serviceProcess;

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
