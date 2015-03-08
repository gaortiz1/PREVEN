package ec.com.gesso.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ec.com.gesso.controller.persona.PersonDto;

@Controller
@SessionAttributes
public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(){
		return new ModelAndView("login", "command", new PersonDto());
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String aaContact(@ModelAttribute("contact")PersonDto contact, BindingResult result) {
    	System.out.println(contact.getFirstname());
        return "redirect:newPerson";
    }
	
}
