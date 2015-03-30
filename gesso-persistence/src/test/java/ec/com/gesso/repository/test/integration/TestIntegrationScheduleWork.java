package ec.com.gesso.repository.test.integration;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import ec.com.gesso.model.entity.ScheduleWork;
import ec.com.gesso.model.entity.ScheduleWorkPK;
import ec.com.gesso.repository.IRepositoryEntity;
@Ignore
public class TestIntegrationScheduleWork extends AbstractPersistenceIntegration {

	private IRepositoryEntity<ScheduleWork> repositoryProcess;

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		repositoryProcess = (IRepositoryEntity<ScheduleWork>) applicationContext.getBean("repositoryScheduleWork");
	}

	@Test
	public void testCreate() {
		ScheduleWork scheduleWork = new ScheduleWork();
		scheduleWork.setIdScheduleWork(new ScheduleWorkPK());
		scheduleWork.getIdScheduleWork().setIdBusinessHour("J8");
		scheduleWork.getIdScheduleWork().setIdCompany(1l);
		repositoryProcess.create(scheduleWork);
	}

}
