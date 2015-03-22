package ec.com.gesso.repository.test.unit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ec.com.gesso.model.entity.ScheduleWork;
import ec.com.gesso.model.entity.ScheduleWorkPK;
import ec.com.gesso.repository.exception.ValidationEntity;
import ec.com.gesso.repository.impl.RepositoryScheduleWork;

@RunWith(MockitoJUnitRunner.class)
public class TestRepositoryScheduleWork extends AbstractTestEntity<ScheduleWork>{
	
	private RepositoryScheduleWork repository;
	private final ScheduleWork entity = new ScheduleWork();

	@Before
	public void setUp() throws Exception {
		this.repository = new RepositoryScheduleWork();
		this.repository.setRepositoryEntity(repositoryWrapper);
		this.entity.setIdScheduleWork(new ScheduleWorkPK());
		this.entity.getIdScheduleWork().setIdBusinessHour("J8");
		this.entity.getIdScheduleWork().setIdCompany(2l);
	}

	@Test
	public void testCreateWithFielsNotNull() {
		this.repository.create(entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void testCreateWithFielsIdScheduleWorkNull() {
		this.entity.setIdScheduleWork(null);
		this.repository.create(this.entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void testCreateWithFielsIdBusinessNull() {
		this.entity.getIdScheduleWork().setIdBusinessHour(null);
		this.repository.create(this.entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void testCreateWithFielsIdCompanyNull() {
		this.entity.getIdScheduleWork().setIdCompany(null);
		this.repository.create(this.entity);
	}

}
