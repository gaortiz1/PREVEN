/**
 * 
 */
package ec.com.gesso.test;

import java.util.Date;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Catalog;
import ec.com.gesso.model.entity.Person;
import ec.com.gesso.security.factory.GessoSecurityFactory;

/**
 * @author roberto
 *
 */
public class PersonTest {
	@Test
	public void crearPersona(){
		Person person = new Person();
		person.setFirstName("mujer");
		person.setLastName("mujer");
		person.setDocumentNumber("1717171717");
		person.setDateOfBirth(new Date());
		person.setLactationPeriod(Boolean.TRUE);
		Integer catalogoSexo = null;
		Integer catalogoVulnerabilidad = null;
		try {
			catalogoSexo = ((Catalog)CollectionUtils.get(GessoSecurityFactory.getInstance().getCatalogService().findSexCatalog(),0)).getIdGroupcatalog();
			catalogoVulnerabilidad = ((Catalog)CollectionUtils.get(GessoSecurityFactory.getInstance().getCatalogService().findVulnerabilityCatalog(),0)).getIdGroupcatalog();
		} catch (GessoException e1) {
			e1.printStackTrace();
		}
		
		person.setIdSexCatalog(catalogoSexo);
		person.setIdCatalogVulnerability(catalogoVulnerabilidad);
		
		
		
		
//		person.setIdSexCatalog(1);
		try {
			GessoSecurityFactory.getInstance().getSecurityService().persistPerson(person);
			System.out.println("pruebas");
		} catch (GessoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}