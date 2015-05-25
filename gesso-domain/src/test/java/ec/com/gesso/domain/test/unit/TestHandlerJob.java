package ec.com.gesso.domain.test.unit;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ec.com.gesso.domain.IHandlerEntity;
import ec.com.gesso.domain.impl.HandlerJob;
import ec.com.gesso.model.entity.Job;
import ec.com.gesso.repository.exception.ValidationEntity;

@RunWith(MockitoJUnitRunner.class)
public class TestHandlerJob extends BaseTestHandlerEntity<Job>{
	
	@Override
	IHandlerEntity<Job> getInstanceHandler() {
		final HandlerJob domainJob = new HandlerJob();
		domainJob.setRepositoryEntity(mockRepositoryEntity);
		return domainJob;
	}

	@Override
	Job getInstanceEntity() {
		final Job job = new Job();
		job.setId(1L);
		job.setName(StringUtils.EMPTY);
		job.setDescription(StringUtils.EMPTY);
		return job;
	}
	
	@Test(expected=ValidationEntity.class)
	public void shouldCreateWithFieldNameNull() {
		this.entity.setName(null);
		this.domainEntity.register(this.entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void shouldNotCreateWithFieldDescriptionNull() {
		this.entity.setDescription(null);
		this.domainEntity.register(this.entity);
	}
	
}
