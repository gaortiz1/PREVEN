package ec.com.gesso.controller.administration.company;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ec.com.gesso.application.factory.GessoServiceFactory;
import ec.com.gesso.application.lang.CompanyBuilder;
import ec.com.gesso.model.company.CompanyModel;
import ec.com.gesso.model.entity.Company;

@Controller
@SessionAttributes
public class CompanyCreateController {
	
	 private final static Logger LOGGER = LoggerFactory.getLogger(CompanyCreateController.class);
	
	@RequestMapping(value = "/company/create-company", method = RequestMethod.GET)
	public ModelAndView createCompany(){		
		final ModelAndView modelAndView = new ModelAndView("/company/create-company", "command", new CompanyModel());
		return modelAndView;
	}
	
	@RequestMapping(value = "/company/create-company", method = RequestMethod.POST)
    public String saveCompany(@ModelAttribute("contact")CompanyModel companyModel, BindingResult result) {
    	try {
    		
    		CompanyBuilder companyBuilder = new CompanyBuilder();
    		companyBuilder.createNameCompany(companyModel.getNombreComercial())
    				.addRazonSocial(companyModel.getRazonSocial())
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
    		
    		GessoServiceFactory.getInstance().getServiceCompany().register(company);
    		
		} catch (Exception e) {
			LOGGER.error("A courrido un error", e);
		}
    	
    	
        return "redirect:/company-administration";
    }

}
