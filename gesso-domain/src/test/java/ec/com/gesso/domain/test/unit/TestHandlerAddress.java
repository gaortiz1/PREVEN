package ec.com.gesso.domain.test.unit;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ec.com.gesso.domain.IHandlerEntity;
import ec.com.gesso.domain.impl.HandlerAddress;
import ec.com.gesso.model.entity.Address;
import ec.com.gesso.repository.exception.ValidationEntity;

@RunWith(MockitoJUnitRunner.class)
public class TestHandlerAddress extends BaseTestHandlerEntity<Address>{
	
	IHandlerEntity<Address> getInstanceHandler(){
		final HandlerAddress domainAddress = new HandlerAddress();
		domainAddress.setRepositoryEntity(mockRepositoryEntity);
		return domainAddress;
	}
	
	Address getInstanceEntity(){
		final Address address = new Address();
		address.setIdContactData(1l);
		address.setNameAddress(StringUtils.EMPTY);
		return address;
	}
	
	@Test(expected=ValidationEntity.class)
	public void shouldNotCreateWithFieldNameAddress() {
		this.entity.setNameAddress(null);
		this.domainEntity.register(this.entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void shouldNotCreateWithFieldIdContactDataNull() {
		this.entity.setIdContactData(null);
		this.domainEntity.register(this.entity);
	}
	
}
