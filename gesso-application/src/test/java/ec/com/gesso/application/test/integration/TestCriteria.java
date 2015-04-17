/**
 * 
 */
package ec.com.gesso.application.test.integration;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;

import ec.com.gesso.application.factory.SearchCriteria;
import ec.com.gesso.model.entity.GeopoliticalDivision;

/**
 * @author Gabriel
 *
 */
public class TestCriteria {

	@Test
	public void shouldExistGeopoliticalDivisionRoot() {
		final Collection<GeopoliticalDivision> collectionGeopoliticalDivisions = SearchCriteria.getInstance().getServiceCriteria().findGeopoliticalDivisionWitoutRoot(); 
		assertEquals(Boolean.FALSE, collectionGeopoliticalDivisions.isEmpty());
	}
	
	@Test
	public void shouldExistGeopoliticalDivision() {
		final Collection<GeopoliticalDivision> collectionGeopoliticalDivisions = SearchCriteria.getInstance().getServiceCriteria().findGeopoliticalDivisionRoot(1L);
		assertEquals(Boolean.FALSE, collectionGeopoliticalDivisions.isEmpty());
	}

}
