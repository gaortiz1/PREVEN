/**
 * 
 */
package ec.com.gesso.application.lang;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.collections4.CollectionUtils;

import ec.com.gesso.model.entity.ActivityEconomicCompany;
import ec.com.gesso.model.entity.Company;
import ec.com.gesso.model.entity.ContactData;
import ec.com.gesso.model.entity.Document;
import ec.com.gesso.model.entity.DocumentPK;
import ec.com.gesso.model.entity.ScheduleWork;
import ec.com.gesso.model.entity.ScheduleWorkPK;

/**
 * @author Gabriel
 *
 */
public class CompanyBuilder {
	
	private String nombreComapany;
	private String razonSocial;
	private String typeCompany;
	private String typeProductiveSector;
	private Long idGeopoliticalDivision;
	private Collection<ActivityEconomicCompany> activities = new ArrayList<ActivityEconomicCompany>();
	private Set<String> idsBusinessHour = new TreeSet<String>();
	private Map<String, String> documents = new HashMap<String, String>();
	
	private ContactDataBuilder contactDataBuilder = new ContactDataBuilder();
	

	public CompanyBuilder createNameCompany(final String nombre) {
		this.nombreComapany = nombre;
		return this;
	}
	
	public CompanyBuilder addRazonSocial(final String razonSocial) {
		this.razonSocial = razonSocial;
		return this;
	}

	public CompanyBuilder addActivityEconomic(Integer id, String idTypeActivity, String nameActivityEconomic) {
		final ActivityEconomicCompany activityEconomicCompany = new ActivityEconomicCompany();
		activityEconomicCompany.setId(id);
		activityEconomicCompany.setIdTypeActivity(idTypeActivity);
		activityEconomicCompany.setName(nameActivityEconomic);
		this.activities.add(activityEconomicCompany);
		return this;
	}

	public CompanyBuilder addTypeCompany(String typeCompany) {
		this.typeCompany = typeCompany;
		return this;
	}
	
	public CompanyBuilder addGeopoliticalDivision(Long idGeopoliticalDivision) {
		this.idGeopoliticalDivision = idGeopoliticalDivision;
		return this;
	}

	public CompanyBuilder addScheduleWork(String idBusinessHour) {
		this.idsBusinessHour.add(idBusinessHour);
		return this;
	}
	
	public CompanyBuilder addProductiveSector(String typeProductiveSector) {
		this.typeProductiveSector = typeProductiveSector;
		return this;
	}
	
	public CompanyBuilder addDocument(String typeDocument, String value) {
		this.documents.put(typeDocument, value);
		return this;
	}
	
	public CompanyBuilder addEmail(Long id, String emailaddess) {
		this.contactDataBuilder.addEmail(id, emailaddess);
		return this;
	}
	
	public CompanyBuilder addAddress(Long id, String nameAddress) {
		this.contactDataBuilder.addAddress(id, nameAddress);
		return this;
	}

	public CompanyBuilder addPhone(Long id, String number, String idtypePhone) {
		this.contactDataBuilder.addPhone(id, number, idtypePhone);
		return this;
	}
	
	public Company build(){
		final Company company = new Company();
		company.setName(this.nombreComapany);
		company.setRazonSocial(this.razonSocial);
		company.setIdTypeCompany(this.typeCompany);
		company.setIdProductiveSector(this.typeProductiveSector);
		company.setIdGeopoliticalDivision(this.idGeopoliticalDivision);
		
		if(CollectionUtils.isNotEmpty(this.activities)){
			company.setActivitiesEconomic(new HashSet<ActivityEconomicCompany>());
			for(final ActivityEconomicCompany activityEconomicCompany : this.activities){
				company.getActivitiesEconomic().add(activityEconomicCompany);
			}
		}
		
		if(!this.idsBusinessHour.isEmpty()) {
			company.setWorkSchedules(new HashSet<ScheduleWork>());
			for(final String idBusinessHour: this.idsBusinessHour) {
				final ScheduleWork scheduleWork = new ScheduleWork();
				scheduleWork.setIdScheduleWork(new ScheduleWorkPK());
				scheduleWork.getIdScheduleWork().setIdBusinessHour(idBusinessHour);
				company.getWorkSchedules().add(scheduleWork);
			}
		}
		
		if(!this.documents.isEmpty()) {
			company.setDocuments(new HashSet<Document>());
			for (final Map.Entry<String,String> entryDocument : this.documents.entrySet()) {
				final Document document = new Document();
				document.setIdDocument(new DocumentPK());
				document.getIdDocument().setIdTypeDocument(entryDocument.getKey());
				document.setValue(entryDocument.getValue());
				company.getDocuments().add(document);
			}
		}
		
		company.setContactsData(new HashSet<ContactData>());
		company.getContactsData().add(contactDataBuilder.build());
		
		return company;
	}
	
}
