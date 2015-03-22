package ec.com.gesso.repository.test.unit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ec.com.gesso.model.entity.ActivityEconomicCompany;
import ec.com.gesso.repository.exception.ValidationEntity;
import ec.com.gesso.repository.impl.RepositoryActivityEconomicCompany;

@RunWith(MockitoJUnitRunner.class)
public class TestRepositoryActivityEconomicCompany extends AbstractTestEntity<ActivityEconomicCompany>{
	
	private RepositoryActivityEconomicCompany repository;
	private final ActivityEconomicCompany entity = new ActivityEconomicCompany();

	@Before
	public void setUp() throws Exception {
		this.repository = new RepositoryActivityEconomicCompany();
		this.repository.setRepositoryEntity(repositoryWrapper);
		this.entity.setName("Company");
		this.entity.setIdCompany(1l);
	}

	@Test
	public void testCreateWithFielsNotNull() {
		this.repository.create(entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void testCreateWithFielsNameNull() {
		this.entity.setName(null);
		this.repository.create(this.entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void testCreateWithFielsIdCompanyNull() {
		this.entity.setIdCompany(null);
		this.repository.create(this.entity);
	}
	

}
