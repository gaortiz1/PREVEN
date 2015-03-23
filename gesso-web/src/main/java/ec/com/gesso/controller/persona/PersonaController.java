package ec.com.gesso.controller.persona;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ec.com.gesso.model.entity.Person;

@Controller
@SessionAttributes
public class PersonaController {
	@RequestMapping(value="/newPerson", method =RequestMethod.GET )
	public ModelAndView showContacts() {
		return new ModelAndView("home", "command", new Person());
	}
    
    @RequestMapping(value = "/newPerson", method = RequestMethod.POST)
    public String aaContact(@ModelAttribute("contact")Person contact, BindingResult result) {
    	System.out.println(contact.getFirstName());
        return "redirect:";
    }
}
