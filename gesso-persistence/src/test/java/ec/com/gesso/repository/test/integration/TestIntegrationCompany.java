package ec.com.gesso.repository.test.integration;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import ec.com.gesso.model.entity.Company;
import ec.com.gesso.repository.IRepositoryEntity;

@Ignore
public class TestIntegrationCompany extends AbstractPersistenceIntegration {

	private IRepositoryEntity<Company> repositoryProcess;

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
		repositoryProcess.create(company);
	}

}
