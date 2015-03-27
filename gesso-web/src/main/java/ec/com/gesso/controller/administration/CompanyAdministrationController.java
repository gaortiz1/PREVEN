package ec.com.gesso.controller.administration;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ec.com.gesso.application.factory.GessoFactory;
import ec.com.gesso.application.lang.CompanyBuilder;
import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.CompanyModel;
import ec.com.gesso.model.entity.Catalog;
import ec.com.gesso.model.entity.Company;
import ec.com.gesso.security.factory.GessoSecurityFactory;

@Controller
@SessionAttributes
public class CompanyAdministrationController {
	
	@RequestMapping(value = "/company-administration", method = RequestMethod.GET)
	public ModelAndView userAdministration(){
		
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
		
		final ModelAndView modelAndView = new ModelAndView("company-administration", "command", new CompanyModel());
		modelAndView.addObject("typesCompanies", typesCompanies);
		modelAndView.addObject("worksHours", worksHours);
		modelAndView.addObject("productivesSector", productivesSector);
		return modelAndView;
	}
	
	@RequestMapping(value = "/company-administration", method = RequestMethod.POST)
    public String companyCreate(@ModelAttribute("contact")CompanyModel companyModel, BindingResult result) {
    	try {
    		
    		CompanyBuilder companyBuilder = new CompanyBuilder();
    		companyBuilder.createNameCompany(companyModel.getNombreComercial())
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
    		
    		final Company company = companyBuilder.build();
    		
    		GessoFactory.getInstance().getServiceCompany().create(company);
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
        return "redirect:company-administration";
    }

}
