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
public class TestRepositoryWrapperHibernateEdit extends BaseRepositoryIntegration {
	
	@Before
	public void setUp() throws Exception {
		this.repository = (IRepositoryEntity) applicationContext.getBean("repositoryWrapperHibernate");
	}
	
	@Test(expected=EntityDataValidationException.class)
	public void shouldNotEditWithEntityNull(){
		this.repository.edit(null);
	}
	
	@Test(expected=EntityDataValidationException.class)
	public void shouldNotEditWithEntityFalse(){
		class EntityFalse implements Serializable{} 
		final EntityFalse entityFalse = new EntityFalse();
		this.repository.edit(entityFalse);
	}
	
	@Test(expected=EntityDataValidationException.class)
	public void shouldNotEditWithEntityWithOutConstraint(){
		final Company company = new Company();
		company.setId(33l);
		company.setIdProductiveSector("AR");
		company.setIdTypeCompany("MICRO");
		company.setName("Prueba de persistencia");
		company.setRazonSocial("Prueba de persistencia");
		company.setIdGeopoliticalDivision(66L);
		company.setState(Boolean.FALSE);
		this.repository.edit(company);
	}
	
	@Test(expected=EntityDataValidationException.class)
	public void shouldNotEditWithEntityWithOutPropertyRequierd(){
		final Company company = new Company();
		company.setId(33l);
		company.setIdProductiveSector("AR");
		company.setIdTypeCompany("MICRO");
		company.setName("Prueba de persistencia");
		company.setRazonSocial("Prueba de persistencia");
		company.setState(Boolean.FALSE);
		this.repository.edit(company);
	}
}