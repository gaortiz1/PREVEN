package ec.com.gesso.application.test.integration;

import java.util.ArrayList;

import org.junit.Test;

import ec.com.gesso.application.factory.GessoServiceFactory;
import ec.com.gesso.model.entity.Process;

public class TestIntegrationProcess {

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
		
		GessoServiceFactory.getInstance().getServiceProcess().register(process);
	}

}
