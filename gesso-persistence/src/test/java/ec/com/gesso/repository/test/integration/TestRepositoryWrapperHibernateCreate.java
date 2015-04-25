/**
 * 
 */
package ec.com.gesso.repository.test.integration;

import java.io.Serializable;

import org.junit.Before;
import org.junit.Test;

import ec.com.gesso.model.entity.Company;
import ec.com.gesso.repository.IRepositoryEntity;
import ec.com.gesso.repository.exception.GessoRepositoryException;

/**
 * @author Gabriel
 *
 */
public class TestRepositoryWrapperHibernateCreate extends BaseRepositoryIntegration {
	
	@Before
	public void setUp() throws Exception {
		this.repository = (IRepositoryEntity) applicationContext.getBean("repositoryWrapperHibernate");
	}
	
	@Test(expected=GessoRepositoryException.class)
	public void testCreateWithEntityNull(){
		this.repository.create(null);
	}
	
	@Test(expected=GessoRepositoryException.class)
	public void testCreateWithEntityFalse(){
		class EntityFalse implements Serializable{} 
		final EntityFalse entityFalse = new EntityFalse();
		this.repository.create(entityFalse);
	}
	
	@Test(expected=GessoRepositoryException.class)
	public void testCreateWithEntityThatHasRequierdFieldNull(){
		final Company company = new Company();
		this.repository.create(company);
	}
	
	@Test(expected=GessoRepositoryException.class)
	public void testCreateWithEntityWithOutForeignKey() {
		Company company = new Company();
		company.setName("Company");
		company.setIdProductiveSector("MR");
		company.setIdTypeCompany("PEQ");
		this.repository.create(company);
	}
}