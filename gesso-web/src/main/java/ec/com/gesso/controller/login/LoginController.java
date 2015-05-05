package ec.com.gesso.controller.login;

import ec.com.gesso.application.dto.UserDto;
import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Person;
import ec.com.gesso.model.entity.User;
import ec.com.gesso.model.entity.UserProfile;
import ec.com.gesso.security.factory.GessoSecurityFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Locale;

@Controller
@SessionAttributes()
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	/*@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(){
		return new ModelAndView("login", "command", new Person());
	}*/

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Person person = new Person();
		person.setUserDto(new User());
		model.addAttribute("command", person);

		return "login";
	}

	@RequestMapping(value = "/savecompany_json", method = RequestMethod.POST)
	public  @ResponseBody String login_JSON( @RequestBody UserDto userDto )   {
		//
		// Code processing the input parameters
		//
		System.out.println(userDto);
		return "JSON: The company name: " + userDto.getNickName() + ", Employees count: " + userDto.getPassword() + ", Headoffice: " + userDto.getNickName();
	}


	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("contact")Person contact, BindingResult result, HttpSession session) {
    	
    	User userDto = null;
		try {
			userDto = GessoSecurityFactory.getInstance().getSecurityService().autenticateUser(contact.getUserDto().getUsrNickName(), contact.getUserDto().getUsrPassword());
			Collection<UserProfile> lstResult = null;
			try {
				lstResult = GessoSecurityFactory.getInstance().getSecurityService().findMenuForUser(1);


				for(UserProfile objResult: lstResult){
					System.out.println(objResult);
				}
			} catch (GessoException e) {
				e.printStackTrace();
			}
		} catch (GessoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	session.setAttribute("logedUser" , userDto);
        
    	if(userDto == null){
    		return "redirect:login";
    	}
    	
        return "redirect:home";
    }
	
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup(@ModelAttribute("contact")Person contact, BindingResult result) {
    	System.out.println(contact.getFirstName());
        return "redirect:newPerson";
    }
	
}
