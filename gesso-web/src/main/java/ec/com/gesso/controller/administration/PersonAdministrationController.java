package ec.com.gesso.controller.administration;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Catalog;
import ec.com.gesso.model.entity.CountryDto;
import ec.com.gesso.model.entity.Person;
import ec.com.gesso.security.factory.GessoSecurityFactory;
@Controller
@SessionAttributes
public class PersonAdministrationController {
	@RequestMapping(value = "/person-administration", method = RequestMethod.GET)
	public ModelAndView userAdministration(){
		
		Collection<CountryDto> country = null;
		try {
			country = GessoSecurityFactory.getInstance().getLocalizationService().findCountry();
		} catch (GessoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Map< String, String > sex = new HashMap<String, String>();  
		sex.put("M", "Male");
		sex.put("F", "Female"); 
		
		
		Collection<Catalog> levelVulnerability = null;
		try {
			levelVulnerability = GessoSecurityFactory.getInstance().getCatalogService().findVulnerabilityCatalog();
		} catch (GessoException e) {
			e.printStackTrace();
		}
		
		Person person = new Person();
        
		ModelAndView modelAndView = new ModelAndView("person-administration", "command", person);
		modelAndView.addObject("country", country);
		modelAndView.addObject("sex", sex);
		modelAndView.addObject("levelVulnerability",levelVulnerability);
	        
		return modelAndView;
	}
	
	@RequestMapping(value = "/person-administration", method = RequestMethod.POST)
    public String userAdministration(@ModelAttribute("contact")Person person, BindingResult result) {
    	try {
    		GessoSecurityFactory.getInstance().getSecurityService().persistPerson(person);	
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
        return "redirect:newPerson";
    }
}
