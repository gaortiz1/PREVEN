/**
 * 
 */
package ec.com.gesso.application.test.integration;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;

import ec.com.gesso.application.factory.GessoSearchCriteria;
import ec.com.gesso.model.entity.GeopoliticalDivision;

/**
 * @author Gabriel
 *
 */
public class TestCriteria {

	@Test
	public void shouldExistGeopoliticalDivisionRoot() {
		final Collection<GeopoliticalDivision> collectionGeopoliticalDivisions = GessoSearchCriteria.getInstance().getServiceCriteria().findRootGeopoliticalDivision(); 
		assertEquals(Boolean.FALSE, collectionGeopoliticalDivisions.isEmpty());
	}
	
	@Test
	public void shouldExistGeopoliticalDivision() {
		final Collection<GeopoliticalDivision> collectionGeopoliticalDivisions = GessoSearchCriteria.getInstance().getServiceCriteria().findChildrenGeopoliticalDivision(1L);
		assertEquals(Boolean.FALSE, collectionGeopoliticalDivisions.isEmpty());
	}

}
