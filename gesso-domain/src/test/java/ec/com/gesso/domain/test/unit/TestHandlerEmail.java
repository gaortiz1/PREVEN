package ec.com.gesso.domain.test.unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ec.com.gesso.domain.IHandlerEntity;
import ec.com.gesso.domain.impl.HandlerEmail;
import ec.com.gesso.model.entity.Email;
import ec.com.gesso.repository.exception.ValidationEntity;

@RunWith(MockitoJUnitRunner.class)
public class TestHandlerEmail extends BaseTestHandlerEntity<Email>{
	
	@Override
	IHandlerEntity<Email> getInstanceHandler() {
		final HandlerEmail domainEmail = new HandlerEmail();
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
