package ec.com.gesso.repository.test.integration;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import ec.com.gesso.model.entity.ActivityEconomicCompany;
import ec.com.gesso.repository.IRepositoryEntity;
@Ignore
public class TestIntegrationActivity extends AbstractRepositoryIntegration {

	private IRepositoryEntity<ActivityEconomicCompany> repositoryProcess;

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		repositoryProcess = (IRepositoryEntity<ActivityEconomicCompany>) applicationContext.getBean("repositoryActivityEconomicCompany");
	}

	@Test
	public void testCreate() {
		ActivityEconomicCompany activityEconomicCompany = new ActivityEconomicCompany();
		activityEconomicCompany.setName("Company");
		activityEconomicCompany.setIdCompany(1l);
		repositoryProcess.create(activityEconomicCompany);
	}

}
