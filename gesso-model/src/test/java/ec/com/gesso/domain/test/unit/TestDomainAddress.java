package ec.com.gesso.domain.test.unit;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ec.com.gesso.domain.IDomainEntity;
import ec.com.gesso.domain.impl.DomainAddress;
import ec.com.gesso.model.entity.Address;
import ec.com.gesso.repository.exception.ValidationEntity;

@RunWith(MockitoJUnitRunner.class)
public class TestDomainAddress extends BaseTestDomainEntity<Address>{
	
	IDomainEntity<Address> getInstanceDomain(){
		final DomainAddress domainAddress = new DomainAddress();
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
		this.domainEntity.create(this.entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void shouldNotCreateWithFieldIdContactDataNull() {
		this.entity.setIdContactData(null);
		this.domainEntity.create(this.entity);
	}
	
}
