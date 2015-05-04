package ec.com.gesso.controller.administration.company;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ec.com.gesso.application.factory.GessoFactory;
import ec.com.gesso.application.factory.GessoSearchCriteria;
import ec.com.gesso.application.lang.CompanyBuilder;
import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.company.CompanyModel;
import ec.com.gesso.model.entity.Catalog;
import ec.com.gesso.model.entity.Company;
import ec.com.gesso.model.entity.GeopoliticalDivision;
import ec.com.gesso.security.factory.GessoSecurityFactory;

@Controller
@SessionAttributes
public class CompanyCreateController {
	
	 private final static Logger LOGGER = LoggerFactory.getLogger(CompanyCreateController.class);
	
	@RequestMapping(value = "/company/create-company", method = RequestMethod.GET)
	public ModelAndView createCompany(){
		
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
		
		Collection<GeopoliticalDivision> geopoliticalDivisions =  null;
		try {
			geopoliticalDivisions = GessoSearchCriteria.getInstance().getServiceCriteria().findRootGeopoliticalDivision();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		final ModelAndView modelAndView = new ModelAndView("/company/create-company", "command", new CompanyModel());
		modelAndView.addObject("typesCompanies", typesCompanies);
		modelAndView.addObject("worksHours", worksHours);
		modelAndView.addObject("productivesSector", productivesSector);
		modelAndView.addObject("geopoliticalDivisions", geopoliticalDivisions);
		return modelAndView;
	}
	
	@RequestMapping(value = "/company/create-company", method = RequestMethod.POST)
    public String saveCompany(@ModelAttribute("contact")CompanyModel companyModel, BindingResult result) {
    	try {
    		
    		CompanyBuilder companyBuilder = new CompanyBuilder();
    		companyBuilder.createNameCompany(companyModel.getNombreComercial())
    				.addrRazonSocial(companyModel.getRazonSocial())
    				.addDocument("RUC", companyModel.getRuc())
    				.addActivityEconomic(companyModel.getActividadComercialPrincipal())
    				.addActivityEconomic(companyModel.getActividadComercialSecuandaria())
    				.addTypeCompany(companyModel.getTypesCompanies())
    				.addProductiveSector(companyModel.getTypeProductiveSector())
    				.addAddress(companyModel.getDireccion())
    				.addEmail(companyModel.getEmail())
    				.addPhone(companyModel.getCelular(), "CEL")
    				.addPhone(companyModel.getTelefono(), "TEL")
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
    		
    		GessoFactory.getInstance().getServiceCompany().register(company);
    		
		} catch (Exception e) {
			LOGGER.error("A courrido un error", e);
		}
    	
    	
        return "redirect:/company-administration";
    }

}
