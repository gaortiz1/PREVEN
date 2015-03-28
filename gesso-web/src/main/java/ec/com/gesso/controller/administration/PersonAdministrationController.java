package ec.com.gesso.controller.administration;

import java.util.Collection;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.controller.serializer.CatalogAdapter;
import ec.com.gesso.model.entity.Catalog;
import ec.com.gesso.model.entity.CountryDto;
import ec.com.gesso.model.entity.Person;
import ec.com.gesso.model.entity.Process;
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
			e.printStackTrace();
		}
		
		Collection<Catalog> levelVulnerability = null;
		try {
			levelVulnerability = GessoSecurityFactory.getInstance().getCatalogService().findVulnerabilityCatalog();
		} catch (GessoException e) {
			e.printStackTrace();
		}
		
		Collection<Catalog> lstProfesion = null;
		try {
			lstProfesion = GessoSecurityFactory.getInstance().getCatalogService().findProfesionCatalog();
		} catch (GessoException e) {
			e.printStackTrace();
		}
		
		
		Collection<Process> lstProcess = null;
		try {
			lstProcess = GessoSecurityFactory.getInstance().getProcessService().findProcess();
		} catch (GessoException e) {
			e.printStackTrace();
		}
		
		
		Person person = new Person();
		person.setStatusPerson(Boolean.TRUE);
        
		ModelAndView modelAndView = new ModelAndView("person-administration", "command", person);
		modelAndView.addObject("country", country);
		modelAndView.addObject("levelVulnerability",levelVulnerability);
		modelAndView.addObject("lstProfesion",lstProfesion);
		modelAndView.addObject("lstProcess",lstProcess);
		
	        
		return modelAndView;
	}
	
//	@RequestMapping(value = "/person-fill-ciudad", method = RequestMethod.POST)
	@RequestMapping(value = "/person-fill-ciudad/{petId}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public String fillCiudad(@PathVariable String petId, Model model) {
		
//		Gson gson  = new Gson();
		
		Collection<Catalog> levelVulnerability = null;
		try {
			levelVulnerability = GessoSecurityFactory.getInstance().getCatalogService().findVulnerabilityCatalog();
		} catch (GessoException e) {
			e.printStackTrace();
		}
		
		GsonBuilder gsonBuilder = new GsonBuilder();
	    Gson gson = gsonBuilder.registerTypeAdapter(Catalog.class, new CatalogAdapter()).create();
	    
    	return gson.toJson(levelVulnerability);
    }
	
	
	@RequestMapping(value = "/person-administration", method = RequestMethod.POST)
    public String userAdministration(@ModelAttribute("contact")Person person, BindingResult result) {
    	try {
//    		person.setLactationPeriod(Boolean.TRUE);
    		person.setStatusPerson(Boolean.TRUE);
    		
    		GessoSecurityFactory.getInstance().getSecurityService().persistPerson(person);	
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
        return "redirect:person-administration";
    }
	
	
}


