package ec.com.gesso.controller.persona;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes
public class PersonaController {
	@RequestMapping(value="/newPerson", method =RequestMethod.GET )
	public ModelAndView showContacts() {
		return new ModelAndView("create-person", "command", new PersonDto());
	}
    
    @RequestMapping(value = "/newPerson", method = RequestMethod.POST)
    public String aaContact(@ModelAttribute("contact")PersonDto contact, BindingResult result) {
    	System.out.println(contact.getFirstname());
        return "redirect:";
    }
}
