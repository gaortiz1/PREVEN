package ec.com.gesso.repository.test.unit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ec.com.gesso.model.entity.Company;
import ec.com.gesso.repository.exception.ValidationEntity;
import ec.com.gesso.repository.impl.RepositoryCompany;

@RunWith(MockitoJUnitRunner.class)
public class TestRepositoryCompany extends AbstractTestEntity<Company>{
	
	private RepositoryCompany repository;
	private final Company entity = new Company();

	@Before
	public void setUp() throws Exception {
		this.repository = new RepositoryCompany();
		this.repository.setRepositoryEntity(repositoryWrapper);
		this.entity.setName("Company");
		this.entity.setIdProductiveSector("BR");
		this.entity.setIdTypeCompany("MICRO");
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
	public void testCreateWithFielsIdProductiveSectorNull() {
		this.entity.setIdProductiveSector(null);
		this.repository.create(this.entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void testCreateWithFielsIdTypeCompanyNull() {
		this.entity.setIdTypeCompany(null);
		this.repository.create(this.entity);
	}
	

}
