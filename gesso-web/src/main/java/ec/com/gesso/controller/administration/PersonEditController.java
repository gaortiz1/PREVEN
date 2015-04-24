package ec.com.gesso.controller.administration;

import ec.com.gesso.application.dto.PersonDto;
import ec.com.gesso.application.dto.UserDto;
import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Person;
import ec.com.gesso.security.factory.GessoSecurityFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collection;

/**
 * Created by Roberto on 23/04/2015.
 */
public class PersonEditController {

    @RequestMapping(value="/person-edit", method= RequestMethod.GET,produces={"application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Collection<Person> getPersonList() {
        Collection<Person> lstPersonas = null;
        try {
            lstPersonas  = GessoSecurityFactory.getInstance().getSecurityService().findAllPersons();
        } catch (GessoException e) {
            e.printStackTrace();
        }
        return null;
    }
}
