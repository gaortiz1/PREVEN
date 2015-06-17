package ec.com.gesso.controller.administration.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ec.com.gesso.application.factory.GessoSearchCriteriaFactory;
import ec.com.gesso.application.factory.GessoServiceFactory;
import ec.com.gesso.application.lang.CompanyBuilder;
import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.controller.exception.ResourceNotFoundException;
import ec.com.gesso.json.serializer.CompanyModelSerializer;
import ec.com.gesso.model.activity.ActivityEconomicModel;
import ec.com.gesso.model.company.CompanyModel;
import ec.com.gesso.model.contactdata.AddressModel;
import ec.com.gesso.model.contactdata.EmailModel;
import ec.com.gesso.model.contactdata.PhoneModel;
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

@Controller
@SessionAttributes
public class RegisterCompanyController {
	
	 private final static Logger LOGGER = LoggerFactory.getLogger(RegisterCompanyController.class);
	
	@RequestMapping(value = "/company/register-company", method = RequestMethod.GET)
	public ModelAndView createCompany(){
		return new ModelAndView("/company/register-company");
	}
	
	@RequestMapping(value = "/company/edit-company/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String editCompany(@PathVariable("id") Long id){
		
		final Company company = this.buildSearchCompany(id);
		
		if (null == company) {
			throw new ResourceNotFoundException();
		}
		
		CompanyModel companyModel = new CompanyModel();
		companyModel.setId(company.getId());
		companyModel.setNombreComercial(company.getName());
		companyModel.setRazonSocial(company.getRazonSocial());
		companyModel.setRuc(company.getDocuments().iterator().next().getValue());
		
		for (ActivityEconomicCompany activityEconomicCompany : company.getActivitiesEconomic()) {
			if ("PRINC".equals(activityEconomicCompany.getIdTypeActivity())){
				companyModel.setActividadComercialPrincipal(new ActivityEconomicModel());
				companyModel.getActividadComercialPrincipal().setId(activityEconomicCompany.getId());
				companyModel.getActividadComercialPrincipal().setName(activityEconomicCompany.getName());
			}else if ("SECUN".equals(activityEconomicCompany.getIdTypeActivity())){
				companyModel.setActividadComercialSecuandaria(new ActivityEconomicModel());
				companyModel.getActividadComercialSecuandaria().setId(activityEconomicCompany.getId());
				companyModel.getActividadComercialSecuandaria().setName(activityEconomicCompany.getName());
			}
		}
		
		companyModel.setIdGeopoliticalDivisionCountry(company.getGeopoliticalDivision().getGeopoliticalDivisionRoot().getGeopoliticalDivisionRoot().getId());
		companyModel.setIdGeopoliticalDivisionProvince(company.getGeopoliticalDivision().getGeopoliticalDivisionRoot().getId());
		companyModel.setIdGeopoliticalDivisionCity(company.getIdGeopoliticalDivision());
		
		companyModel.setTypesCompanies(company.getIdTypeCompany());
		companyModel.setTypeProductiveSector(company.getIdProductiveSector());
		
		Collection<String> schedulesWork = new ArrayList<String>();
		for (ScheduleWork scheduleWork: company.getWorkSchedules()){
			schedulesWork.add(scheduleWork.getIdScheduleWork().getIdBusinessHour());
		}
		companyModel.setSchedulesWork(schedulesWork.toArray(new String[]{}));
		
		for (ContactData contactData : company.getContactsData()) {
			
			for (Address address : contactData.getAddresses()) {
				companyModel.setDireccion(new AddressModel());
				companyModel.getDireccion().setId(address.getId());
				companyModel.getDireccion().setNameAddress(address.getNameAddress());
			}
			
			for (Email email : contactData.getEmails()) {
				companyModel.setEmail(new EmailModel());
				companyModel.getEmail().setId(email.getId());
				companyModel.getEmail().setEmailaddess(email.getEmailaddess());
			}
			
			for (Phone phone : contactData.getPhones()) {
				if ("TEL".equals(StringUtils.trim(phone.getIdtypePhone()))) {
					companyModel.setTelefono(new PhoneModel());
					companyModel.getTelefono().setId(phone.getId());
					companyModel.getTelefono().setNumber(phone.getNumber());
				} else if ("CEL".equals(StringUtils.trim(phone.getIdtypePhone()))) {
					companyModel.setCelular(new PhoneModel());
					companyModel.getCelular().setId(phone.getId());
					companyModel.getCelular().setNumber(phone.getNumber());
				}
			}
		}
		GsonBuilder gsonBuilder = new GsonBuilder();
	    Gson gson = gsonBuilder.registerTypeAdapter(CompanyModel.class, new CompanyModelSerializer()).create();
    	return gson.toJson(companyModel);
	}
	
	private Company buildSearchCompany(Long id){
		
		final Company companyCriteria = new Company();
		companyCriteria.setId(id);
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
		
		return GessoSearchCriteriaFactory.getInstance().getServiceCriteria().find(companyCriteria);
	}
	
	@RequestMapping(value = "/register-company", method = RequestMethod.POST)
    public @ResponseBody Company registerCompany(@RequestBody CompanyModel companyModel, BindingResult bindingResult) throws GessoException {
		
		try {
    		
    		CompanyBuilder companyBuilder = new CompanyBuilder();
    		companyBuilder.createNameCompany(companyModel.getNombreComercial())
    				.addRazonSocial(companyModel.getRazonSocial())
    				.addDocument("RUC", companyModel.getRuc())
    				.addActivityEconomic(companyModel.getActividadComercialPrincipal().getId(), "PRINC",companyModel.getActividadComercialPrincipal().getName())
    				.addActivityEconomic(companyModel.getActividadComercialSecuandaria().getId(), "SECUN",companyModel.getActividadComercialSecuandaria().getName())
    				.addTypeCompany(companyModel.getTypesCompanies())
    				.addProductiveSector(companyModel.getTypeProductiveSector())
    				.addAddress(companyModel.getDireccion().getId(), companyModel.getDireccion().getNameAddress())
    				.addEmail(companyModel.getEmail().getId(), companyModel.getEmail().getEmailaddess())
    				.addPhone(companyModel.getCelular().getId(), companyModel.getCelular().getNumber(), "CEL")
    				.addPhone(companyModel.getTelefono().getId(), companyModel.getTelefono().getNumber(), "TEL")
    				.build();
    		
    		if (companyModel.getSchedulesWork() != null){
    			
    			for (String scheduleWork : companyModel.getSchedulesWork()) {
    				companyBuilder.addScheduleWork(scheduleWork);
    			}
    		}
    		
    		if (companyModel.getIdGeopoliticalDivisionCity() != null){
    			companyBuilder.addGeopoliticalDivision(companyModel.getIdGeopoliticalDivisionCity());
    		}
    		
    		final Company company = companyBuilder.build();
    		
    		return GessoServiceFactory.getInstance().getServiceCompany().register(company);
    		
		} catch (Exception e) {
			LOGGER.error("A courrido un error", e);
			throw new GessoException(e);
		}
    }
}
