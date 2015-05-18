package ec.com.gesso.controller.login;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import ec.com.gesso.application.dto.UserDto;
import ec.com.gesso.application.dto.UserProfileDto;
import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.User;
import ec.com.gesso.model.entity.UserProfile;
import ec.com.gesso.security.factory.GessoSecurityFactory;

@Controller
@SessionAttributes()
@RequestMapping("/")
public class LoginController {

	//private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	/*@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Person person = new Person();
		person.setUserDto(new User());
		model.addAttribute("command", person);

		return "home";
	}*/
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home() {
		
		return "loginForm";
	}
	
	
	@RequestMapping(value = "/loginUser_json", method = RequestMethod.POST)
	public  @ResponseBody UserDto loginUser_JSON( @RequestBody UserDto userDto )   {
		User logedUser = null;
		try {
			logedUser = GessoSecurityFactory.getInstance().getSecurityService().autenticateUser(userDto.getNickName(), userDto.getPassword());
		} catch (GessoException e) {
			e.printStackTrace();
		}
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.map(logedUser, userDto);
		return userDto;
	}
	

    @RequestMapping(value="/build-user-menu/{usrId}", method= RequestMethod.GET,produces={"application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Collection<UserProfileDto> buildUserMenu(@PathVariable Integer usrId){
        Collection<UserProfile> lstResult = null;
        try {
            lstResult = GessoSecurityFactory.getInstance().getSecurityService().findMenuForUser(usrId);
        } catch (GessoException e) {
            e.printStackTrace();
        }

		ModelMapper modelMapper = new ModelMapper();
        Collection<UserProfileDto> lstResultUserProfile = null;
		Type listType = new TypeToken<List<UserProfileDto>>() {}.getType();
        try {
            lstResultUserProfile = modelMapper.map(lstResult, listType );
        }catch(Exception e){
            e.printStackTrace();
        }


        return lstResultUserProfile;
    }
	
}
