package ec.com.gesso.domain.test.unit;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ec.com.gesso.domain.IHandlerEntity;
import ec.com.gesso.domain.impl.HandlerPhone;
import ec.com.gesso.model.entity.Phone;
import ec.com.gesso.repository.exception.ValidationEntity;

@RunWith(MockitoJUnitRunner.class)
public class TestHandlerPhone extends BaseTestHandlerEntity<Phone>{
	
	@Override
	IHandlerEntity<Phone> getInstanceHandler() {
		final HandlerPhone domainPhone = new HandlerPhone();
		domainPhone.setRepositoryEntity(mockRepositoryEntity);
		return domainPhone;
	}

	@Override
	Phone getInstanceEntity() {
		final Phone phone = new Phone();
		phone.setIdtypePhone(StringUtils.EMPTY);
		phone.setIdContactData(1l);
		phone.setNumber(StringUtils.EMPTY);
		return phone;
	}
	
	@Test(expected=ValidationEntity.class)
	public void sholudNotCreateWithFieldIdtypePhoneNull() {
		this.entity.setIdtypePhone(null);
		this.domainEntity.register(this.entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void sholudNotCreateWithFieldsetIdContactDataNull() {
		this.entity.setIdContactData(null);
		this.domainEntity.register(this.entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void sholudNotCreateWithFieldNumberNull() {
		this.entity.setNumber(null);
		this.domainEntity.register(this.entity);
	}
}
