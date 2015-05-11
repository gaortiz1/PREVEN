package ec.com.gesso.controller.administration;

import java.lang.reflect.Type;
import java.util.Collection;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;

import ec.com.gesso.application.dto.PersonDto;
import ec.com.gesso.application.dto.UserDto;
import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Person;
import ec.com.gesso.model.entity.User;
import ec.com.gesso.security.factory.GessoSecurityFactory;


@Controller
@SessionAttributes
public class UserAdministrationController {
	@RequestMapping(value = "/user-administration", method = RequestMethod.GET)
	public void userAdministration(Model model){
		Collection<User> lstCollection = null;
		try {
			lstCollection = GessoSecurityFactory.getInstance().getSecurityService().findAllUsers();
		} catch (GessoException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("members", lstCollection);
		
//		return new ModelAndView("user-administration", "command", lstCollection);
	}

    @RequestMapping(value="/find_users_json",
            method=RequestMethod.GET,produces={"application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Collection<PersonDto> findUsers() {
        Collection<Person> lstUserResult = null;
        Collection<PersonDto> lstUserDtoResult = null;
        try {
            lstUserResult = GessoSecurityFactory.getInstance().getSecurityService().findAllUsersByPerson();
        } catch (GessoException e) {
            e.printStackTrace();
        }

        ModelMapper modelMapper = new ModelMapper();
        Type listType = new TypeToken<Collection<PersonDto>>() {}.getType();
        lstUserDtoResult = modelMapper.map(lstUserResult, listType );

        return lstUserDtoResult;
    }
    
	@RequestMapping(value = "/user-administration-edit", method = RequestMethod.POST)
    public @ResponseBody UserDto userAdministration(@RequestBody UserDto userDto, BindingResult result) {
    	
		ModelMapper modelMapper = new ModelMapper();
		User user = new User();
		modelMapper.map(userDto, user);
		try {
			GessoSecurityFactory.getInstance().getSecurityService().updateUser(user);
		} catch (GessoException e) {
			e.printStackTrace();
		}
    	
        return userDto;
    }
	
	@RequestMapping(value = "/user-administration", method = RequestMethod.POST)
    public String userAdministration(@ModelAttribute("contact")Person contact, BindingResult result) {
    	
    	Collection<User> lstCollection = null;
		try {
			lstCollection = GessoSecurityFactory.getInstance().getSecurityService().findAllUsers();
		} catch (GessoException e) {
			e.printStackTrace();
		}
    	
    	if(lstCollection == null){
    		return "redirect:login";
    	}
    	
        return "redirect:newPerson";
    }
	
}
