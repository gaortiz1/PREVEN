package ec.com.gesso.controller.administration;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

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
		person.setStatusPerson(Boolean.TRUE);
        
		ModelAndView modelAndView = new ModelAndView("person-administration", "command", person);
		modelAndView.addObject("country", country);
		modelAndView.addObject("sex", sex);
		modelAndView.addObject("levelVulnerability",levelVulnerability);
	        
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
	
	class CatalogAdapter implements JsonSerializer<Catalog> {

		@Override
		public JsonElement serialize(Catalog arg0, Type arg1, JsonSerializationContext arg2) {
			JsonObject jsonObject = new JsonObject();
	        jsonObject.addProperty("catalog_id", arg0.getId());
	        jsonObject.addProperty("catalog_name", arg0.getName());
	        return jsonObject; 
		}
	}
}


