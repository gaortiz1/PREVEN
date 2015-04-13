/**
 * 
 */
package ec.com.gesso.application.lang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

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
	
	private String nombreComapny;
	private String typeCompany;
	private String typeProductiveSector;
	private Long idGeopoliticalDivision;
	private Set<String> namesActivityEconomicCompany = new TreeSet<String>();
	private Set<String> idsBusinessHour = new TreeSet<String>();
	private Map<String, String> documents = new HashMap<String, String>();
	
	private ContactDataBuilder contactDataBuilder = new ContactDataBuilder();
	

	public CompanyBuilder createNameCompany(final String nombre) {
		this.nombreComapny = nombre;
		return this;
	}

	public CompanyBuilder addActivityEconomic(String nameActivityEconomic) {
		this.namesActivityEconomicCompany.add(nameActivityEconomic);
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
	
	public CompanyBuilder addEmail(String email) {
		this.contactDataBuilder.addEmail(email);
		return this;
	}
	
	public CompanyBuilder addAddress(String address) {
		this.contactDataBuilder.addAddress(address);
		return this;
	}

	public CompanyBuilder addPhone(String number, String idtypePhone) {
		this.contactDataBuilder.addPhone(number, idtypePhone);
		return this;
	}
	
	public Company build(){
		final Company company = new Company();
		company.setName(this.nombreComapny);
		company.setIdTypeCompany(this.typeCompany);
		company.setIdProductiveSector(this.typeProductiveSector);
		company.setIdGeopoliticalDivision(this.idGeopoliticalDivision);
		
		if(!this.namesActivityEconomicCompany.isEmpty()){
			company.setActivityEconomicCompanyCollection(new ArrayList<ActivityEconomicCompany>());
			for(final String activityEconomic : this.namesActivityEconomicCompany){
				ActivityEconomicCompany activityEconomicCompany = new ActivityEconomicCompany();
				activityEconomicCompany.setName(activityEconomic);
				company.getActivityEconomicCompanyCollection().add(activityEconomicCompany);
			}
		}
		
		if(!this.idsBusinessHour.isEmpty()) {
			company.setScheduleWorkCollection(new ArrayList<ScheduleWork>());
			for(final String idBusinessHour: this.idsBusinessHour) {
				final ScheduleWork scheduleWork = new ScheduleWork();
				scheduleWork.setIdScheduleWork(new ScheduleWorkPK());
				scheduleWork.getIdScheduleWork().setIdBusinessHour(idBusinessHour);
				company.getScheduleWorkCollection().add(scheduleWork);
			}
		}
		
		if(!this.documents.isEmpty()) {
			company.setDocumentCollection(new ArrayList<Document>());
			for (final Map.Entry<String,String> entryDocument : this.documents.entrySet()) {
				final Document document = new Document();
				document.setIdDocument(new DocumentPK());
				document.getIdDocument().setIdTypeDocument(entryDocument.getKey());
				document.setValue(entryDocument.getValue());
				company.getDocumentCollection().add(document);
			}
		}
		
		company.setContactDataCollection(new ArrayList<ContactData>());
		company.getContactDataCollection().add(contactDataBuilder.build());
		
		return company;
	}
	
}
