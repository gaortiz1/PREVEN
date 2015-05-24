package ec.com.gesso.domain.test.unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ec.com.gesso.domain.IDomainEntity;
import ec.com.gesso.domain.impl.DomainEmail;
import ec.com.gesso.model.entity.Email;
import ec.com.gesso.repository.exception.ValidationEntity;

@RunWith(MockitoJUnitRunner.class)
public class TestDomainEmail extends BaseTestDomainEntity<Email>{
	
	@Override
	IDomainEntity<Email> getInstanceDomain() {
		final DomainEmail domainEmail = new DomainEmail();
		domainEmail.setRepositoryEntity(this.mockRepositoryEntity);
		return domainEmail;
	}

	@Override
	Email getInstanceEntity() {
		final Email email = new Email();
		email.setEmailaddess("asdasdsa");
		email.setIdContactData(1l);
		return email;
	}
	
	@Test(expected=ValidationEntity.class)
	public void shouldNotCreateWithFieldIdContactDataNull() {
		this.entity.setIdContactData(null);
		this.domainEntity.register(this.entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void shouldNotCreateWithFieldEmailAddessNull() {
		this.entity.setEmailaddess(null);
		this.domainEntity.register(this.entity);
	}
}
