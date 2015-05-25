/**
 * 
 */
package ec.com.gesso.repository.test.integration;

import java.io.Serializable;

import org.junit.Before;
import org.junit.Test;

import ec.com.gesso.model.entity.Company;
import ec.com.gesso.repository.IRepositoryEntity;
import ec.com.gesso.repository.exception.EntityDataValidationException;

/**
 * @author Gabriel
 *
 */
public class TestRepositoryWrapperHibernateCreate extends BaseRepositoryIntegration {
	
	@Before
	public void setUp() throws Exception {
		this.repository = (IRepositoryEntity) applicationContext.getBean("repositoryEntity");
	}
	
	@Test(expected=EntityDataValidationException.class)
	public void testCreateWithEntityNull(){
		this.repository.add(null);
	}
	
	@Test(expected=EntityDataValidationException.class)
	public void testCreateWithEntityFalse(){
		class EntityFalse implements Serializable{
			private static final long serialVersionUID = 1L;
		} 
		final EntityFalse entityFalse = new EntityFalse();	
		this.repository.add(entityFalse);
	}
	
	@Test(expected=EntityDataValidationException.class)
	public void testCreateWithEntityThatHasRequierdFieldNull(){
		final Company company = new Company();
		this.repository.add(company);
	}
	
	@Test(expected=EntityDataValidationException.class)
	public void testCreateWithEntityWithOutForeignKey() {
		Company company = new Company();
		company.setName("Company");
		company.setIdProductiveSector("MR");
		company.setIdTypeCompany("PEQ");
		this.repository.add(company);
	}
}