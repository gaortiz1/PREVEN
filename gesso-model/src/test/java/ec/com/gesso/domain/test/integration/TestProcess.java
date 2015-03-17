package ec.com.gesso.domain.test.integration;

import static org.junit.Assert.fail;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ec.com.gesso.domain.IDomainEntity;
import ec.com.gesso.model.entity.Process;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"geso-transactions.xml",
		"gesso-domain.xml",
		"gesso-persistencia.xml",
		"gesso-repository.xml"
		})
public class TestProcess {
	
	@Autowired private ApplicationContext applicationContext;
	private IDomainEntity<Process> domainProcess;

	@Before
	public void setUp() throws Exception {
		domainProcess = (IDomainEntity<Process>) applicationContext.getBean("domainProcess");
	}

	@Test()
	public void test() {
		Process process = new Process();
		process.setDescription(StringUtils.EMPTY);
		process.setName(StringUtils.EMPTY);
//		domainProcess.create(process);
	}

}
