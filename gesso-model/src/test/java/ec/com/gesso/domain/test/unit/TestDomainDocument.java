package ec.com.gesso.domain.test.unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ec.com.gesso.domain.IDomainEntity;
import ec.com.gesso.domain.impl.DomainDocument;
import ec.com.gesso.model.entity.Document;
import ec.com.gesso.model.entity.DocumentPK;
import ec.com.gesso.repository.exception.ValidationEntity;

@RunWith(MockitoJUnitRunner.class)
public class TestDomainDocument extends BaseTestDomainEntity<Document>{
	
	@Override
	IDomainEntity<Document> getInstanceDomain() {
		final DomainDocument domainDocument = new DomainDocument();
		domainDocument.setRepositoryEntity(mockRepositoryEntity);
		return domainDocument;
	}

	@Override
	Document getInstanceEntity() {
		Document document = new Document();
		document.setValue("1717189235");;
		document.setIdDocument(new DocumentPK());
		document.getIdDocument().setIdTypeDocument("CI");
		return document;
	}
	
	@Test
	public void shouldCreateWithFieldsNotNull() {
		this.entity.setIdCompany(1l);
		this.domainEntity.create(entity);
	}

	@Test
	public void shouldCreateWithFieldIdPersonNotNull() {
		this.entity.setIdPerson(1l);
		this.domainEntity.create(entity);
	}
	
	@Test
	public void shouldCreateWithFieldIdCompanyNotNull() {
		this.entity.setIdCompany(1l);
		this.domainEntity.create(entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void shouldNotCreateWithFieldIdDocumentNull() {
		this.entity.setIdDocument(null);
		this.domainEntity.create(this.entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void shouldNotCreateWithFieldValueNull() {
		this.entity.setValue(null);
		this.domainEntity.create(this.entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void shouldNotCreateWithFieldIdTypeCompanyNull() {
		this.entity.getIdDocument().setIdTypeDocument(null);
		this.domainEntity.create(this.entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void shouldNotCreateWithOutFieldsIDCompanyAndIDPersonNull() {
		this.entity.setIdCompany(null);
		this.entity.setIdPerson(null);
		this.domainEntity.create(this.entity);
	}
	
}
