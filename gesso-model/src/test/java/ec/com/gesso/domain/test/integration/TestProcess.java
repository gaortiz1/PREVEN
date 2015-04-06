package ec.com.gesso.domain.test.integration;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import ec.com.gesso.domain.IDomainEntity;
import ec.com.gesso.model.entity.Process;

public class TestProcess extends AbstractModelIntegration {
	
	private IDomainEntity<Process> domainProcess;

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		domainProcess = (IDomainEntity<Process>) applicationContext.getBean("domainProcess");
	}

	@Test()
	public void test() {
		Process process = new Process();
		process.setDescription(StringUtils.EMPTY);
		process.setName(StringUtils.EMPTY);
		domainProcess.create(process);
	}

}
