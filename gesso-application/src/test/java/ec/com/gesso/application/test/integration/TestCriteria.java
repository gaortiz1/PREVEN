/**
 * 
 */
package ec.com.gesso.application.test.integration;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import ec.com.gesso.application.factory.GessoSearchCriteriaFactory;
import ec.com.gesso.model.entity.ActivityEconomicCompany;
import ec.com.gesso.model.entity.Address;
import ec.com.gesso.model.entity.Catalog;
import ec.com.gesso.model.entity.Company;
import ec.com.gesso.model.entity.ContactData;
import ec.com.gesso.model.entity.Document;
import ec.com.gesso.model.entity.Email;
import ec.com.gesso.model.entity.GeopoliticalDivision;
import ec.com.gesso.model.entity.Phone;
import ec.com.gesso.model.entity.ScheduleWork;

/**
 * @author Gabriel
 *
 */
public class TestCriteria {
	
	@Test
	public void shouldExistGeopoliticalDivision() {
		final Company companyCriteria = new Company();
		companyCriteria.setId(11L);
		companyCriteria.setState(Boolean.TRUE);
		
		final Document document = new Document();
		document.setState(Boolean.TRUE);
		companyCriteria.setDocuments(new HashSet<Document>());
		companyCriteria.getDocuments().add(document);
		
		final ActivityEconomicCompany activityEconomicCompany = new ActivityEconomicCompany();
		activityEconomicCompany.setState(Boolean.TRUE);
		companyCriteria.setActivitiesEconomic(new HashSet<ActivityEconomicCompany>());
		companyCriteria.getActivitiesEconomic().add(activityEconomicCompany);
		
		companyCriteria.setTypeCompany(new Catalog());
		companyCriteria.getTypeCompany().setState(Boolean.TRUE);
		
		companyCriteria.setCatalogSectorProductivo(new Catalog());
		companyCriteria.getCatalogSectorProductivo().setState(Boolean.TRUE);
		
		final ScheduleWork scheduleWork = new ScheduleWork();
		companyCriteria.setState(Boolean.TRUE);
		companyCriteria.setWorkSchedules(new HashSet<ScheduleWork>());
		companyCriteria.getWorkSchedules().add(scheduleWork);
		
		final ContactData contactData = new ContactData();
		
		final Address address = new Address();
		address.setState(Boolean.TRUE);
		contactData.setAddresses(new HashSet<Address>());
		contactData.getAddresses().add(address);
		
		final Phone phone = new Phone();
		phone.setState(Boolean.TRUE);
		contactData.setPhones(new HashSet<Phone>());
		contactData.getPhones().add(phone);
		
		final Email email = new Email();
		email.setState(Boolean.TRUE);
		contactData.setEmails(new HashSet<Email>());
		contactData.getEmails().add(email);
		
		companyCriteria.setContactsData(new HashSet<ContactData>());
		companyCriteria.getContactsData().add(contactData);
		
		companyCriteria.setGeopoliticalDivision(new GeopoliticalDivision());
		companyCriteria.getGeopoliticalDivision().setGeopoliticalDivisionRoot(new GeopoliticalDivision());
		companyCriteria.getGeopoliticalDivision().getGeopoliticalDivisionRoot().setGeopoliticalDivisionRoot(new GeopoliticalDivision());
		
		final Company company = GessoSearchCriteriaFactory.getInstance().getServiceCriteria().find(companyCriteria);
		assertNull(company);
	}
}
