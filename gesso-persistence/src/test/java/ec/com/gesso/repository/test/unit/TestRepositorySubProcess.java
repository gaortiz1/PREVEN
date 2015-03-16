package ec.com.gesso.repository.test.unit;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ec.com.gesso.model.entity.SubProcess;
import ec.com.gesso.repository.IRepositoryEntity;
import ec.com.gesso.repository.exception.ValidationEntity;
import ec.com.gesso.repository.impl.RepositorySubProcess;

@RunWith(MockitoJUnitRunner.class)
public class TestRepositorySubProcess{
	
	private RepositorySubProcess repositoryProcess;
	@Mock private IRepositoryEntity<SubProcess> repositoryWrapper;
	private final SubProcess entity = new SubProcess();

	@Before
	public void setUp() throws Exception {
		this.repositoryProcess = new RepositorySubProcess();
		this.repositoryProcess.setRepositoryEntity(repositoryWrapper);
	}

	@Test
	public void testCreateWithFielsNotNull() {
		this.entity.setId(1L);
		this.entity.setName(StringUtils.EMPTY);
		this.entity.setDescription(StringUtils.EMPTY);
		this.repositoryProcess.create(entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void testCreateWithFielsNameNull() {
		this.entity.setId(1L);
		this.entity.setDescription(StringUtils.EMPTY);
		this.repositoryProcess.create(this.entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void testCreateWithFielsDescriptionNull() {
		this.entity.setId(1L);
		this.entity.setName(StringUtils.EMPTY);
		this.repositoryProcess.create(this.entity);
	}

}
