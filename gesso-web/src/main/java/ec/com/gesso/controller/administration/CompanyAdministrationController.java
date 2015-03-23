package ec.com.gesso.controller.administration;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Person;
import ec.com.gesso.model.entity.UserDto;
import ec.com.gesso.security.factory.GessoSecurityFactory;
@Controller
@SessionAttributes
public class CompanyAdministrationController {
	@RequestMapping(value = "/company-administration", method = RequestMethod.GET)
	public ModelAndView userAdministration(){
		return new ModelAndView("company-administration", "command", new Person());
	}
	
	@RequestMapping(value = "/company-administration", method = RequestMethod.POST)
    public String userAdministration(@ModelAttribute("contact")Person contact, BindingResult result) {
    	
    	UserDto userDto = null;
		try {
			userDto = GessoSecurityFactory.getInstance().getSecurityService().autenticateUser(contact.getUserDto().getUsrNickName(), contact.getUserDto().getUsrPassword());
		} catch (GessoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	if(userDto == null){
    		return "redirect:login";
    	}
    	
        return "redirect:newPerson";
    }
}
