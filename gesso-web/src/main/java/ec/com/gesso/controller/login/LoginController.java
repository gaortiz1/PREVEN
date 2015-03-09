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
import ec.com.gesso.security.factory.GessoSecurityFactory;

@Controller
@SessionAttributes
public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(){
		return new ModelAndView("login", "command", new Person());
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("contact")Person contact, BindingResult result) {
    	System.out.println(contact.getUserDto().getUsrNickName());
    	System.out.println(contact.getUserDto().getUsrPassword());
    	
    	UserDto userDto =  GessoSecurityFactory.getInstance().getSecurityService().autenticateUser(contact.getUserDto().getUsrNickName(), contact.getUserDto().getUsrPassword());
    	System.out.println(userDto);
    	
    	if(userDto == null){
    		return "redirect:login";
    	}
    	
        return "redirect:newPerson";
    }
	
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup(@ModelAttribute("contact")Person contact, BindingResult result) {
    	System.out.println(contact.getFirstName());
        return "redirect:newPerson";
    }
	
}
