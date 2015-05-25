package ec.com.gesso.domain.test.unit;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ec.com.gesso.domain.IDomainEntity;
import ec.com.gesso.domain.impl.DomainJob;
import ec.com.gesso.model.entity.Job;
import ec.com.gesso.repository.exception.ValidationEntity;

@RunWith(MockitoJUnitRunner.class)
public class TestDomainJob extends BaseTestDomainEntity<Job>{
	
	@Override
	IDomainEntity<Job> getInstanceDomain() {
		final DomainJob domainJob = new DomainJob();
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
