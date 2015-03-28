package ec.com.gesso.repository.test.integration;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ec.com.gesso.model.entity.Company;
import ec.com.gesso.repository.IRepositoryEntity;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:ec/com/gesso/repository/test/integration/geso-transactions.xml",
		"classpath:ec/com/gesso/repository/test/integration/gesso-persistencia.xml",
		"classpath:ec/com/gesso/repository/test/integration/gesso-repository.xml" })
public class TestIntegrationCompany {

	private IRepositoryEntity<Company> repositoryProcess;
	@Autowired private ApplicationContext applicationContext;

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		repositoryProcess = (IRepositoryEntity<Company>) applicationContext.getBean("repositoryCompany");
	}

	@Test
	public void testCreate() {
		Company company = new Company();
		company.setName("Company");
		company.setIdProductiveSector("MR");
		company.setIdTypeCompany("PEQ");
		company.setIdDivgeoPol(1l);
		repositoryProcess.create(company);
	}

}
