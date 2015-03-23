package ec.com.gesso;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ec.com.gesso.model.entity.Person;
import ec.com.gesso.model.entity.UserDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Person person = new Person();
		person.setUserDto(new UserDto());
		model.addAttribute("command", person );

		return "login";
	}
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homePage(Locale locale, Model model) {
		return "home";
	}
}
