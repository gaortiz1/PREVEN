package ec.com.gesso.domain.test.unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ec.com.gesso.domain.IHandlerEntity;
import ec.com.gesso.domain.impl.HandlerScheduleWork;
import ec.com.gesso.model.entity.ScheduleWork;
import ec.com.gesso.model.entity.ScheduleWorkPK;
import ec.com.gesso.repository.exception.ValidationEntity;

@RunWith(MockitoJUnitRunner.class)
public class TestHandlerScheduleWork extends BaseTestHandlerEntity<ScheduleWork> {
	
	@Override
	IHandlerEntity<ScheduleWork> getInstanceHandler() {
		final HandlerScheduleWork domainScheduleWork = new HandlerScheduleWork();
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
