/**
 * 
 */
package ec.com.gesso.criteria.test;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ec.com.gesso.criteria.QueryCriteria;
import ec.com.gesso.criteria.test.entity.ActivityEconomicCompany;
import ec.com.gesso.criteria.test.entity.Catalog;
import ec.com.gesso.criteria.test.entity.Company;
import ec.com.gesso.criteria.test.entity.GroupCatalog;
import ec.com.gesso.criteria.test.entity.JobRisk;
import ec.com.gesso.criteria.test.entity.Risk;

/**
 * @author Gabriel
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:ec/com/gesso/criteria/test/resources/spring/config/gesso-transactions.xml",
		"classpath:ec/com/gesso/criteria/test/resources/spring/config/gesso-entity-manager.xml",
		"classpath:ec/com/gesso/criteria/test/resources/spring/config/gesso-criteria.xml" })
public class TestIntegracionCriteriaJPA {
	
	@Autowired protected ApplicationContext applicationContext;
	
	private QueryCriteria queryCriteria;
	
	@Before
	public void setUp() throws Exception {
		this.queryCriteria = (QueryCriteria) applicationContext.getBean("criteriaJPA");
	}
	
	@Test
	public void testWithOneJoin(){
		Company company = new Company();
		company.setIdProductiveSector("a");
		company.setActivityEconomicCompanyCollection(new ArrayList<ActivityEconomicCompany>());
		
		ActivityEconomicCompany activityEconomicCompany = new ActivityEconomicCompany();
		activityEconomicCompany.setName("s");
		
		company.getActivityEconomicCompanyCollection().add(activityEconomicCompany);
		
		this.queryCriteria.findAll(company);
	}
	
	@Test
	public void testWithManyJoin(){
		Company company = new Company();
		company.setIdProductiveSector("a");
		
		Catalog catalog = new Catalog();
		catalog.setName("a");
		catalog.setGroupCatalog(new GroupCatalog());
		catalog.getGroupCatalog().setName("a");
		
		company.setCatalogSectorProductivo(catalog);
		
		company.setActivityEconomicCompanyCollection(new ArrayList<ActivityEconomicCompany>());
		
		ActivityEconomicCompany activityEconomicCompany = new ActivityEconomicCompany();
		activityEconomicCompany.setName("s");
		
		company.getActivityEconomicCompanyCollection().add(activityEconomicCompany);
		
		this.queryCriteria.findAll(company);
	}
	
	@Test
	public void testFactor(){
		final Risk riskTemplate = new Risk();
		riskTemplate.setId(1l);
		riskTemplate.setState(Boolean.TRUE);
		riskTemplate.setJobRisks(new ArrayList<JobRisk>());
		final JobRisk jobRisk = new JobRisk();
		jobRisk.setState(Boolean.TRUE);
		riskTemplate.getJobRisks().add(jobRisk);
		
		final Risk risk = this.queryCriteria.find(riskTemplate);
	}

}
