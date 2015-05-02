package ec.com.gesso.domain.test.unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ec.com.gesso.domain.IDomainEntity;
import ec.com.gesso.domain.impl.DomainScheduleWork;
import ec.com.gesso.model.entity.ScheduleWork;
import ec.com.gesso.model.entity.ScheduleWorkPK;
import ec.com.gesso.repository.exception.ValidationEntity;

@RunWith(MockitoJUnitRunner.class)
public class TestDomainScheduleWork extends BaseTestDomainEntity<ScheduleWork> {
	
	@Override
	IDomainEntity<ScheduleWork> getInstanceDomain() {
		final DomainScheduleWork domainScheduleWork = new DomainScheduleWork();
		domainScheduleWork.setRepositoryEntity(mockRepositoryEntity);
		return domainScheduleWork;
	}

	@Override
	ScheduleWork getInstanceEntity() {
		final ScheduleWork scheduleWork = new ScheduleWork();
		scheduleWork.setIdScheduleWork(new ScheduleWorkPK());
		scheduleWork.getIdScheduleWork().setIdBusinessHour("J8");
		scheduleWork.getIdScheduleWork().setIdCompany(2l);
		return scheduleWork;
	}
	
	@Test(expected=ValidationEntity.class)
	public void shouldNotCreateWithFieldIdScheduleWorkNull() {
		this.entity.setIdScheduleWork(null);
		this.domainEntity.register(this.entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void shouldNotCreateWithFieldIdBusinessNull() {
		this.entity.getIdScheduleWork().setIdBusinessHour(null);
		this.domainEntity.register(this.entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void shouldNotCreateWithFieldIdCompanyNull() {
		this.entity.getIdScheduleWork().setIdCompany(null);
		this.domainEntity.register(this.entity);
	}
}
