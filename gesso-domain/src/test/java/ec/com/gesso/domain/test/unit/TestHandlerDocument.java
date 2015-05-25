package ec.com.gesso.domain.test.unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ec.com.gesso.domain.IHandlerEntity;
import ec.com.gesso.domain.impl.HandlerDocument;
import ec.com.gesso.model.entity.Document;
import ec.com.gesso.model.entity.DocumentPK;
import ec.com.gesso.repository.exception.ValidationEntity;

@RunWith(MockitoJUnitRunner.class)
public class TestHandlerDocument extends BaseTestHandlerEntity<Document>{
	
	@Override
	IHandlerEntity<Document> getInstanceHandler() {
		final HandlerDocument domainDocument = new HandlerDocument();
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
		this.domainEntity.register(entity);
	}

	@Test
	public void shouldCreateWithFieldIdPersonNotNull() {
		this.entity.setIdPerson(1l);
		this.domainEntity.register(entity);
	}
	
	@Test
	public void shouldCreateWithFieldIdCompanyNotNull() {
		this.entity.setIdCompany(1l);
		this.domainEntity.register(entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void shouldNotCreateWithFieldIdDocumentNull() {
		this.entity.setIdDocument(null);
		this.domainEntity.register(this.entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void shouldNotCreateWithFieldValueNull() {
		this.entity.setValue(null);
		this.domainEntity.register(this.entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void shouldNotCreateWithFieldIdTypeCompanyNull() {
		this.entity.getIdDocument().setIdTypeDocument(null);
		this.domainEntity.register(this.entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void shouldNotCreateWithOutFieldsIDCompanyAndIDPersonNull() {
		this.entity.setIdCompany(null);
		this.entity.setIdPerson(null);
		this.domainEntity.register(this.entity);
	}
	
	@Test
	public void shouldRegisterWithFieldsNotNull() {
		this.entity.setIdCompany(1l);
		this.domainEntity.register(entity);
	}
	
}
