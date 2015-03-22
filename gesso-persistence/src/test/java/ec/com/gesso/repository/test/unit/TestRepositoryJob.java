package ec.com.gesso.repository.test.unit;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ec.com.gesso.model.entity.Job;
import ec.com.gesso.repository.exception.ValidationEntity;
import ec.com.gesso.repository.impl.RepositoryJob;

@RunWith(MockitoJUnitRunner.class)
public class TestRepositoryJob extends AbstractTestEntity<Job>{
	
	private RepositoryJob repositoryProcess;
	private final Job entity = new Job();

	@Before
	public void setUp() throws Exception {
		this.repositoryProcess = new RepositoryJob();
		this.repositoryProcess.setRepositoryEntity(repositoryWrapper);
		this.entity.setId(1L);
		this.entity.setName(StringUtils.EMPTY);
		this.entity.setDescription(StringUtils.EMPTY);
	}

	@Test
	public void testCreateWithFielsNotNull() {
		this.repositoryProcess.create(entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void testCreateWithFielsNameNull() {
		this.entity.setName(null);
		this.repositoryProcess.create(this.entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void testCreateWithFielsDescriptionNull() {
		this.entity.setDescription(null);
		this.repositoryProcess.create(this.entity);
	}
	
	@Test(expected=ValidationEntity.class)
	public void testCreateWithParameterNull() {
		this.repositoryProcess.create(null);
	}

}
