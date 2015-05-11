package ec.com.gesso.controller.login;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ec.com.gesso.application.dto.PersonDto;
import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Person;
import ec.com.gesso.model.entity.User;
import ec.com.gesso.security.factory.GessoSecurityFactory;

@Controller
@SessionAttributes
public class SignUpController {
	@RequestMapping(value="/singUp", method =RequestMethod.GET )
	public ModelAndView signUp() {
		
		Person person = new Person();
		person.setUserDto(new User());
		
		return new ModelAndView("home", "command", person);
	}
    
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String signUp(@ModelAttribute("contact")Person person, BindingResult result) {
    	person.setIdSexCatalog("M");
    	person.setStatusPerson(Boolean.TRUE);
    	person.setDateOfBirth(new Date());
    	try {
			GessoSecurityFactory.getInstance().getSecurityService().persistNewUser(person);
		} catch (GessoException e) {
			e.printStackTrace();
		}
        return "redirect:login";
    }
    
    
    @RequestMapping(value = "/recordUser_json", method = RequestMethod.POST)
	public  @ResponseBody PersonDto recordUser_JSON( @RequestBody PersonDto personDto)   {
    	ModelMapper modelMapper = new ModelMapper();
    	
    	Person person = new Person();
    	modelMapper.map(personDto, person);
    	
    	person.setIdSexCatalog("M");
    	person.setStatusPerson(Boolean.TRUE);
    	person.setDateOfBirth(new Date());
    	try {
			GessoSecurityFactory.getInstance().getSecurityService().persistNewUser(person);
			return personDto;
		} catch (GessoException e) {
			e.printStackTrace();
			return null;
		}
	}
}
