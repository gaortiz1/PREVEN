package ec.com.gesso.domain.test.unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ec.com.gesso.domain.IDomainEntity;
import ec.com.gesso.domain.impl.DomainActivityEconomicCompany;
import ec.com.gesso.model.entity.ActivityEconomicCompany;
import ec.com.gesso.repository.exception.ValidationEntity;

@RunWith(MockitoJUnitRunner.class)
public class TestDomainActivityEconomicCompany extends BaseTestDomainEntity<ActivityEconomicCompany>{
	
	IDomainEntity<ActivityEconomicCompany> getInstanceDomain(){
		final DomainActivityEconomicCompany domainActivityEconomicCompany = new DomainActivityEconomicCompany();
		domainActivityEconomicCompany.setRepositoryEntity(mockRepositoryEntity);
		return domainActivityEconomicCompany;
	}
	
	ActivityEconomicCompany getInstanceEntity(){
		final ActivityEconomicCompany activityEconomicCompany = new ActivityEconomicCompany();
		activityEconomicCompany.setName("Company");
		activityEconomicCompany.setIdCompany(1l);
		return activityEconomicCompany;
	}
	
	@Test(expected=ValidationEntity.class)
	public void shouldNotCreateWithFielsNameNull() {
		this.entity.setName(null);
		this.domainEntity.create(this.entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void shouldNotCreateWithFielsIdCompanyNull() {
		this.entity.setIdCompany(null);
		this.domainEntity.create(this.entity);
	}
	
}
