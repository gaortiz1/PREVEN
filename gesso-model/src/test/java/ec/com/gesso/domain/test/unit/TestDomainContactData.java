package ec.com.gesso.domain.test.unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ec.com.gesso.domain.IDomainEntity;
import ec.com.gesso.domain.impl.DomainContactData;
import ec.com.gesso.model.entity.ContactData;
import ec.com.gesso.repository.exception.ValidationEntity;

@RunWith(MockitoJUnitRunner.class)
public class TestDomainContactData extends BaseTestDomainEntity<ContactData>{
	
	@Override
	IDomainEntity<ContactData> getInstanceDomain() {
		final DomainContactData domainContactData = new DomainContactData();
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
		this.domainEntity.create(entity);
	}
}
