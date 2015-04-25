package ec.com.gesso.controller.administration.company;

import java.util.Collection;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ec.com.gesso.application.factory.GessoSearchCriteria;
import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.company.CompanyModel;
import ec.com.gesso.model.entity.Catalog;
import ec.com.gesso.model.entity.Company;
import ec.com.gesso.model.entity.ContactData;
import ec.com.gesso.model.entity.Document;
import ec.com.gesso.model.entity.GeopoliticalDivision;
import ec.com.gesso.security.factory.GessoSecurityFactory;

@Controller
@SessionAttributes
public class CompanyEditController {
	
	 private final static Logger LOGGER = LoggerFactory.getLogger(CompanyEditController.class);
	
	@RequestMapping(value = "/company/edit-company/{id}", method = RequestMethod.GET)
	public ModelAndView editCompany(@PathVariable("id") Long id, Model model){
		
		final Company companyCriteria = new Company();
		companyCriteria.setId(3l);
		companyCriteria.setState(Boolean.TRUE);
		
		companyCriteria.setGeopoliticalDivision(new GeopoliticalDivision());
		companyCriteria.getGeopoliticalDivision().setGeopoliticalDivisionRoot(new GeopoliticalDivision());
		
		companyCriteria.setContactDataCollection(new HashSet<ContactData>());
		companyCriteria.setDocumentCollection(new HashSet<Document>());
		
		final Company company = GessoSearchCriteria.getInstance().getServiceCriteria().find(companyCriteria);
		
		final CompanyModel companyModel = new CompanyModel();
		companyModel.setNombreComercial(company.getName());
		companyModel.setRazonSocial(company.getRazonSocial());
		companyModel.setRuc(company.getDocumentCollection().iterator().next().getValue());
		companyModel.setTypesCompanies(company.getIdTypeCompany());
		companyModel.setTypeProductiveSector(companyModel.getTypeProductiveSector());
		companyModel.setIdGeopoliticalDivisionCity(company.getIdGeopoliticalDivision());
		companyModel.setIdGeopoliticalDivisionProvince(company.getGeopoliticalDivision().getGeopoliticalDivisionRoot().getId());
		companyModel.setIdGeopoliticalDivisionCountry(company.getGeopoliticalDivision().getGeopoliticalDivisionRoot().getIdRoot());
		companyModel.setTypeProductiveSector(company.getIdProductiveSector());
		
		
		Collection<Catalog> typesCompanies = null;
		try {
			typesCompanies = GessoSecurityFactory.getInstance().getCatalogService().findCatalogByGroup("TP");
		} catch (GessoException e) {
			e.printStackTrace();
		}
		
		Collection<Catalog> worksHours = null;
		try {
			worksHours = GessoSecurityFactory.getInstance().getCatalogService().findCatalogByGroup("HT");
		} catch (GessoException e) {
			e.printStackTrace();
		}
		
		Collection<Catalog> productivesSector = null;
		try {
			productivesSector = GessoSecurityFactory.getInstance().getCatalogService().findCatalogByGroup("SP");
		} catch (GessoException e) {
			e.printStackTrace();
		}
		
		Collection<GeopoliticalDivision> geopoliticalCountries =  null;
		try {
			geopoliticalCountries = GessoSearchCriteria.getInstance().getServiceCriteria().findRootGeopoliticalDivision();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Collection<GeopoliticalDivision> geopoliticalProvinces =  null;
		try {
			geopoliticalProvinces = GessoSearchCriteria.getInstance().getServiceCriteria().findChildrenGeopoliticalDivision(company.getGeopoliticalDivision().getGeopoliticalDivisionRoot().getIdRoot());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Collection<GeopoliticalDivision> geopoliticalCities =  null;
		try {
			geopoliticalCities = GessoSearchCriteria.getInstance().getServiceCriteria().findChildrenGeopoliticalDivision(company.getGeopoliticalDivision().getIdRoot());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		final ModelAndView modelAndView = new ModelAndView("/company/edit-company", "command", companyModel);
		modelAndView.addObject("typesCompanies", typesCompanies);
		modelAndView.addObject("worksHours", worksHours);
		modelAndView.addObject("productivesSector", productivesSector);
		modelAndView.addObject("geopoliticalCountries", geopoliticalCountries);
		modelAndView.addObject("geopoliticalProvinces", geopoliticalProvinces);
		modelAndView.addObject("geopoliticalCities", geopoliticalCities);
		return modelAndView;
	}
	
	

}
