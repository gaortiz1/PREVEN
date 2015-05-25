package ec.com.gesso.domain.test.unit;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ec.com.gesso.domain.IHandlerEntity;
import ec.com.gesso.domain.impl.HandlerSubProcess;
import ec.com.gesso.model.entity.SubProcess;
import ec.com.gesso.repository.exception.ValidationEntity;

@RunWith(MockitoJUnitRunner.class)
public class TestHandlerSubProcess extends BaseTestHandlerEntity<SubProcess> {
	
	@Override
	IHandlerEntity<SubProcess> getInstanceHandler() {
		final HandlerSubProcess domainSubProcess = new HandlerSubProcess();
		domainSubProcess.setRepositoryEntity(this.mockRepositoryEntity);
		return domainSubProcess;
	}

	@Override
	SubProcess getInstanceEntity() {
		final SubProcess subProcess = new SubProcess();
		subProcess.setId(1L);
		subProcess.setIdProcess(1l);
		subProcess.setName(StringUtils.EMPTY);
		subProcess.setDescription(StringUtils.EMPTY);
		return subProcess;
	}
	
	@Test(expected=ValidationEntity.class)
	public void shouldNotCreateWithFieldIdProcessNull() {
		this.entity.setIdProcess(null);
		this.domainEntity.register(this.entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void shouldNotCreateWithFieldNameNull() {
		this.entity.setName(null);
		this.domainEntity.register(this.entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void shouldNotCreateWithFieldDescriptionNull() {
		this.entity.setDescription(null);
		this.domainEntity.register(this.entity);
	}

}
