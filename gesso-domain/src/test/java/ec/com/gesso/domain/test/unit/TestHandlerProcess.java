package ec.com.gesso.domain.test.unit;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ec.com.gesso.domain.IHandlerEntity;
import ec.com.gesso.domain.impl.HandlerProcess;
import ec.com.gesso.model.entity.Process;
import ec.com.gesso.repository.exception.ValidationEntity;

@RunWith(MockitoJUnitRunner.class)
public class TestHandlerProcess extends BaseTestHandlerEntity<Process>{
	
	@Override
	IHandlerEntity<Process> getInstanceHandler() {
		final HandlerProcess domainProcess = new HandlerProcess();
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
		this.domainEntity.register(this.entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void sholudNotCreateWithFieldDescriptionNull() {
		this.entity.setDescription(null);
		this.domainEntity.register(this.entity);
	}
}
