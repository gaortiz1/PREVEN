package ec.com.gesso.controller.administration;

import ec.com.gesso.model.entity.Process;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by roberto on 25/03/2015.
 */

@Controller
@SessionAttributes
public class ProcessAdministration {

    @RequestMapping(value = "/process-administration", method = RequestMethod.GET)
    public ModelAndView userAdministration(){
        ec.com.gesso.model.entity.Process process = new Process();
        ModelAndView modelAndView = new ModelAndView("process-administration", "command", process);

        return modelAndView;
    }
}
