package ec.com.gesso.controller.administration;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import ec.com.gesso.application.dto.PersonDto;
import ec.com.gesso.application.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
			// TODO Auto-generated catch block
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


	
	@RequestMapping(value = "/user-administration-edit/{idUser}", method = RequestMethod.GET)
	@ResponseBody
	public String userAdministrationEdit(@PathVariable Integer idUser, Model model){
		User userDto = null;
		try {
			userDto = GessoSecurityFactory.getInstance().getSecurityService().findUserById(idUser);
		} catch (GessoException e) {
			e.printStackTrace();
		}
		model.addAttribute("userDto", userDto);
		

		return "{message:ok}";
//		return new ModelAndView("user-administration", "command", lstCollection);
	}
	@RequestMapping(value = "/user-administration-edit", method = RequestMethod.POST)
    public String userAdministration(@ModelAttribute("contact")User userDto, BindingResult result) {
    	
    	
		try {
			GessoSecurityFactory.getInstance().getSecurityService().persistUser(userDto);
		} catch (GessoException e) {
			e.printStackTrace();
		}
    	
        return "redirect:user-administration";
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
	
	
	
	
	@RequestMapping(value = "/user-profile", method = RequestMethod.GET)
	public ModelAndView userProfile(){
		return new ModelAndView("profile", "command", new Person());
	}
	
}
