/**
 * 
 */
package ec.com.gesso.application.test.integration;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.HashSet;

import org.junit.Test;

import ec.com.gesso.application.factory.GessoSearchCriteria;
import ec.com.gesso.model.entity.Company;
import ec.com.gesso.model.entity.ContactData;
import ec.com.gesso.model.entity.Document;
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
		final Company companyCriteria = new Company();
		companyCriteria.setId(3l);
		companyCriteria.setState(Boolean.TRUE);
		
		companyCriteria.setGeopoliticalDivision(new GeopoliticalDivision());
		companyCriteria.getGeopoliticalDivision().setGeopoliticalDivisionRoot(new GeopoliticalDivision());
		
		companyCriteria.setContactDataCollection(new HashSet<ContactData>());
		companyCriteria.setDocumentCollection(new HashSet<Document>());
		
		final Company company = GessoSearchCriteria.getInstance().getServiceCriteria().find(companyCriteria);
	}
}
