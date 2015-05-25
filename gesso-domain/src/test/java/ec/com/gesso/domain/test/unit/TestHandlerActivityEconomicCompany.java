package ec.com.gesso.domain.test.unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ec.com.gesso.domain.IHandlerEntity;
import ec.com.gesso.domain.impl.HandlerActivityEconomicCompany;
import ec.com.gesso.model.entity.ActivityEconomicCompany;
import ec.com.gesso.repository.exception.ValidationEntity;

@RunWith(MockitoJUnitRunner.class)
public class TestHandlerActivityEconomicCompany extends BaseTestHandlerEntity<ActivityEconomicCompany>{
	
	IHandlerEntity<ActivityEconomicCompany> getInstanceHandler(){
		final HandlerActivityEconomicCompany domainActivityEconomicCompany = new HandlerActivityEconomicCompany();
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
	public void shouldNotRegisterWithFielsNameNull() {
		this.entity.setName(null);
		this.domainEntity.register(this.entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void shouldNotRegisterWithFielsIdCompanyNull() {
		this.entity.setIdCompany(null);
		this.domainEntity.register(this.entity);
	}
	
}
