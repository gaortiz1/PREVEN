package ec.com.gesso.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ec.com.gesso.security.domain.model.security.dto.Person;
import ec.com.gesso.security.domain.model.security.dto.UserDto;

@Controller
@SessionAttributes
public class SignUpController {
	@RequestMapping(value="/singUp", method =RequestMethod.GET )
	public ModelAndView showContacts() {
		
		Person person = new Person();
		person.setUserDto(new UserDto());
		
		return new ModelAndView("home", "command", person);
	}
    
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String aaContact(@ModelAttribute("contact")Person contact, BindingResult result) {
        return "redirect:login";
    }
}
