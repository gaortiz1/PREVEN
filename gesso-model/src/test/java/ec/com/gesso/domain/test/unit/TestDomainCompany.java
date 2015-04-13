package ec.com.gesso.domain.test.unit;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ec.com.gesso.domain.IDomainEntity;
import ec.com.gesso.domain.impl.DomainCompany;
import ec.com.gesso.model.entity.Company;
import ec.com.gesso.repository.exception.ValidationEntity;

@RunWith(MockitoJUnitRunner.class)
public class TestDomainCompany extends BaseTestDomainEntity<Company>{
	
	@Override
	IDomainEntity<Company> getInstanceDomain() {
		final DomainCompany domainCompany = new DomainCompany();
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
		this.domainEntity.create(this.entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void shouldNotCreateWithFielsIdProductiveSectorNull() {
		this.entity.setIdProductiveSector(null);
		this.domainEntity.create(this.entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void shouldNotCreateWithFielsIdTypeCompanyNull() {
		this.entity.setIdTypeCompany(null);
		this.domainEntity.create(this.entity);
	}
}
