package ec.com.gesso.controller.login;

import javax.servlet.http.HttpSession;

import ec.com.gesso.application.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Person;
import ec.com.gesso.model.entity.User;
import ec.com.gesso.security.factory.GessoSecurityFactory;

@Controller
@SessionAttributes()
public class LoginController {
	private String password;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(){
		return new ModelAndView("login", "command", new Person());
	}


	@RequestMapping(value="/springcontent",
			method=RequestMethod.GET,produces={"application/xml", "application/json"})
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody
	UserDto getUser() {
		UserDto userDetails = new UserDto();
		userDetails.setNickName("Praveen");
		userDetails.setPassword(password);
		return userDetails;
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
		} catch (GessoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	session.setAttribute("logedUser" , userDto);
        
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
