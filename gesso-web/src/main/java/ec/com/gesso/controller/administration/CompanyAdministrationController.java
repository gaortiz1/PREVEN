package ec.com.gesso.controller.administration;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ec.com.gesso.application.factory.GessoFactory;
import ec.com.gesso.application.lang.CompanyBuilder;
import ec.com.gesso.model.CompanyModel;
import ec.com.gesso.model.entity.Company;

@Controller
@SessionAttributes
public class CompanyAdministrationController {
	
	@RequestMapping(value = "/company-administration", method = RequestMethod.GET)
	public ModelAndView userAdministration(){
		return new ModelAndView("company-administration", "command", new CompanyModel());
	}
	
	@RequestMapping(value = "/company-administration", method = RequestMethod.POST)
    public String companyCreate(@ModelAttribute("contact")CompanyModel companyModel, BindingResult result) {
    	try {
    		CompanyBuilder companyBuilder = new CompanyBuilder();
    		final Company company = companyBuilder.createNameCompany(companyModel.getNombreComercial())
    				.addDocument("RUC", companyModel.getRuc())
    				.addActivityEconomic(companyModel.getActividadComercialPrincipal())
    				.addActivityEconomic(companyModel.getActividadComercialSecuandaria())
    				.addTypeCompany("MICRO")
    				.addScheduleWork("J8")
    				.addScheduleWork("JC")
    				.addProductiveSector("BR")
    				.addAddress(companyModel.getDireccion())
    				.addEmail(companyModel.getEmail())
    				.addPhone(companyModel.getCelular(), "CEL")
    				.addPhone(companyModel.getTelefono(), "TEL")
    				.build();
    		GessoFactory.getInstance().getServiceCompany().create(company);
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
        return "redirect:person-administration";
    }

}
