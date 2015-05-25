package ec.com.gesso.domain.test.unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ec.com.gesso.domain.IHandlerEntity;
import ec.com.gesso.domain.impl.HandlerContactData;
import ec.com.gesso.model.entity.ContactData;
import ec.com.gesso.repository.exception.ValidationEntity;

@RunWith(MockitoJUnitRunner.class)
public class TestHandlerContactData extends BaseTestHandlerEntity<ContactData>{
	
	@Override
	IHandlerEntity<ContactData> getInstanceHandler() {
		final HandlerContactData domainContactData = new HandlerContactData();
		domainContactData.setRepositoryEntity(mockRepositoryEntity);
		return domainContactData;
	}

	@Override
	ContactData getInstanceEntity() {
		ContactData contactData = new ContactData();
		contactData.setIdCompany(1l);
		contactData.setIdPerson(1l);
		return contactData;
	}
	
	@Test(expected=ValidationEntity.class)
	public void shouldNotCreateWithOutFieldIdCompanyAndIdPerson() {
		entity.setIdCompany(null);
		entity.setIdPerson(null);
		this.domainEntity.register(entity);
	}
}
