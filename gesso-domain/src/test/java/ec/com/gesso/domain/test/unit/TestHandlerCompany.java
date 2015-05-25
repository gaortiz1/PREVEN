package ec.com.gesso.domain.test.unit;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ec.com.gesso.domain.IHandlerEntity;
import ec.com.gesso.domain.impl.HandlerCompany;
import ec.com.gesso.model.entity.Company;
import ec.com.gesso.repository.exception.ValidationEntity;

@RunWith(MockitoJUnitRunner.class)
public class TestHandlerCompany extends BaseTestHandlerEntity<Company>{
	
	@Override
	IHandlerEntity<Company> getInstanceHandler() {
		final HandlerCompany domainCompany = new HandlerCompany();
		domainCompany.setRepositoryEntity(mockRepositoryEntity);
		return domainCompany;
	}

	@Override
	Company getInstanceEntity() {
		final Company company = new Company();
		company.setName(StringUtils.EMPTY);
		company.setIdTypeCompany(StringUtils.EMPTY);
		company.setIdProductiveSector(StringUtils.EMPTY);
		return company;
	}
	
	@Test(expected=ValidationEntity.class)
	public void shouldNotCreateWithFielsNameNull() {
		this.entity.setName(null);
		this.domainEntity.register(this.entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void shouldNotCreateWithFielsIdProductiveSectorNull() {
		this.entity.setIdProductiveSector(null);
		this.domainEntity.register(this.entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void shouldNotCreateWithFielsIdTypeCompanyNull() {
		this.entity.setIdTypeCompany(null);
		this.domainEntity.register(this.entity);
	}
}
