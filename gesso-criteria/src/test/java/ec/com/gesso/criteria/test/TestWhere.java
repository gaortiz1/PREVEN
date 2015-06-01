/**
 * 
 */
package ec.com.gesso.criteria.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ec.com.gesso.criteria.QueryCriteria;
import ec.com.gesso.criteria.test.entity.JobRisk;
import ec.com.gesso.criteria.test.entity.JobRiskPK;

/**
 * @author Gabriel
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:ec/com/gesso/criteria/test/resources/spring/config/gesso-transactions.xml",
		"classpath:ec/com/gesso/criteria/test/resources/spring/config/gesso-entity-manager.xml",
		"classpath:ec/com/gesso/criteria/test/resources/spring/config/gesso-criteria.xml" })
public class TestWhere {

	@Autowired
	protected ApplicationContext applicationContext;

	private QueryCriteria queryCriteria;

	@Before
	public void setUp() throws Exception {
		this.queryCriteria = (QueryCriteria) applicationContext.getBean("criteriaJPA");
	}
	
	@Test
	public void testSearchByIdEmmbeded() {
		JobRisk jobRisk = new JobRisk();
		jobRisk.setId(new JobRiskPK());
		jobRisk.getId().setIdJob(1l);
		
		this.queryCriteria.find(jobRisk);
	}

}
