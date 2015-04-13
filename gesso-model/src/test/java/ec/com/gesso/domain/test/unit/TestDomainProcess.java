package ec.com.gesso.domain.test.unit;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ec.com.gesso.domain.IDomainEntity;
import ec.com.gesso.domain.impl.DomainProcess;
import ec.com.gesso.model.entity.Process;
import ec.com.gesso.repository.exception.ValidationEntity;

@RunWith(MockitoJUnitRunner.class)
public class TestDomainProcess extends BaseTestDomainEntity<Process>{
	
	@Override
	IDomainEntity<Process> getInstanceDomain() {
		final DomainProcess domainProcess = new DomainProcess();
		domainProcess.setRepositoryEntity(mockRepositoryEntity);
		return domainProcess;
	}

	@Override
	Process getInstanceEntity() {
		final Process process = new Process();
		process.setId(1L);
		process.setName(StringUtils.EMPTY);
		process.setDescription(StringUtils.EMPTY);
		return process;
	}
	
	@Test(expected=ValidationEntity.class)
	public void sholudNotCreateWithFieldNameNull() {
		this.entity.setName(null);
		this.domainEntity.create(this.entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void sholudNotCreateWithFieldDescriptionNull() {
		this.entity.setDescription(null);
		this.domainEntity.create(this.entity);
	}
}
