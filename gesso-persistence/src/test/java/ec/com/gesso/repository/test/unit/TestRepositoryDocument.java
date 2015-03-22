package ec.com.gesso.repository.test.unit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ec.com.gesso.model.entity.Document;
import ec.com.gesso.model.entity.DocumentPK;
import ec.com.gesso.repository.exception.ValidationEntity;
import ec.com.gesso.repository.impl.RepositoryDocument;

@RunWith(MockitoJUnitRunner.class)
public class TestRepositoryDocument extends AbstractTestEntity<Document>{
	
	private RepositoryDocument repository;
	private final Document entity = new Document();

	@Before
	public void setUp() throws Exception {
		this.repository = new RepositoryDocument();
		this.repository.setRepositoryEntity(repositoryWrapper);
		this.entity.setValue("1717189235");;
		this.entity.setIdDocument(new DocumentPK());
		this.entity.getIdDocument().setIdTypeDocument("CI");
	}

	@Test
	public void testCreateWithFielsNotNull() {
		this.repository.create(entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void testCreateWithFielsValueNull() {
		this.entity.setValue(null);
		this.repository.create(this.entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void testCreateWithFielsIdTypeCompanyNull() {
		this.entity.getIdDocument().setIdTypeDocument(null);
		this.repository.create(this.entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void testCreateWithFielsIdDocumentNull() {
		this.entity.setIdDocument(null);
		this.repository.create(this.entity);
	}
	

}
