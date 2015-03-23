package ec.com.gesso.controller.administration;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class UserAdministrationController {
	@RequestMapping(value = "/user-administration", method = RequestMethod.GET)
	public void userAdministration(Model model){
		Collection<UserDto> lstCollection = null;
		try {
			lstCollection = GessoSecurityFactory.getInstance().getSecurityService().findAllUsers();
		} catch (GessoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("members", lstCollection);
		
//		return new ModelAndView("user-administration", "command", lstCollection);
	}
	
	@RequestMapping(value = "/user-administration", method = RequestMethod.POST)
    public String userAdministration(@ModelAttribute("contact")Person contact, BindingResult result) {
    	
    	Collection<UserDto> lstCollection = null;
		try {
			lstCollection = GessoSecurityFactory.getInstance().getSecurityService().findAllUsers();
		} catch (GessoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	if(lstCollection == null){
    		return "redirect:login";
    	}
    	
        return "redirect:newPerson";
    }
	
	
	@RequestMapping(value = "/user-profile", method = RequestMethod.GET)
	public ModelAndView userProfile(){
		return new ModelAndView("profile", "command", new Person());
	}
	
}
