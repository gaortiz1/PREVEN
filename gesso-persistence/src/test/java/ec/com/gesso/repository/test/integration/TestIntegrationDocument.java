package ec.com.gesso.repository.test.integration;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import ec.com.gesso.model.entity.Document;
import ec.com.gesso.model.entity.DocumentPK;
import ec.com.gesso.repository.IRepositoryEntity;
@Ignore
public class TestIntegrationDocument extends AbstractRepositoryIntegration {

	private IRepositoryEntity<Document> repositoryProcess;

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		repositoryProcess = (IRepositoryEntity<Document>) applicationContext.getBean("repositoryDocument");
	}

	@Test
	public void testCreate() {
		Document document = new Document();
		document.setValue("1717189235");;
		document.setIdDocument(new DocumentPK());
		document.getIdDocument().setIdTypeDocument("CI");
		document.getIdDocument().setIdDocument(1l);
		repositoryProcess.create(document);
	}

}
