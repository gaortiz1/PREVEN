/**
 * 
 */
package ec.com.gesso.repository.test.integration;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import ec.com.gesso.model.entity.GeopoliticalDivision;
import ec.com.gesso.repository.IRepositoryCriteriaGeoPolDivi;

/**
 * @author Gabriel
 *
 */
@ContextConfiguration(locations = {
		"geso-transactions.xml",
		"classpath:ec/com/gesso/persistence/resources/spring/config/gesso-persistencia.xml",
		"classpath:ec/com/gesso/persistence/resources/spring/config/gesso-criteria.xml" })
public class TestRepositoryCriteriaGeoPolDivi extends AbstractRepositoryIntegration{
	
	private IRepositoryCriteriaGeoPolDivi repositoryCriteriaGeoPolDivi;
	
	@Before
	public void setUp() throws Exception {
		this.repositoryCriteriaGeoPolDivi = (IRepositoryCriteriaGeoPolDivi) applicationContext.getBean("repositoryCriteriaGeoPolDivi");
	}
	
	@Test
	public void shouldHaveGeoPolDivi(){
		final Collection<GeopoliticalDivision> collectionGeopoliticalDivisions = this.repositoryCriteriaGeoPolDivi.findGeopoliticalDivisionWitoutRoot(); 
		assertEquals(Boolean.FALSE, collectionGeopoliticalDivisions.isEmpty());
	}

}
