package ec.com.gesso.controller.administration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ec.com.gesso.model.entity.Person;
import ec.com.gesso.security.factory.GessoSecurityFactory;
@Controller
@SessionAttributes
public class PersonAdministrationController {
	@RequestMapping(value = "/person-administration", method = RequestMethod.GET)
	public ModelAndView userAdministration(){
		
		Map< String, String > country = new HashMap<String, String>();  
		country.put("EC", "Ecuador");  
		country.put("COL", "Colombia");  
		country.put("URG", "Uruguay");
		
		
		Map< String, String > sex = new HashMap<String, String>();  
		sex.put("M", "Male");
		sex.put("F", "Female"); 
		
		
		Map< String, String > levelVulnerability = new HashMap<String, String>();
		levelVulnerability.put("NIN", "NINGUNA");
		levelVulnerability.put("EMB", "EMBARAZADA");
		levelVulnerability.put("DIS", "DISCAPACITADO");
		levelVulnerability.put("TED", "3RA EDAD");
		
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
