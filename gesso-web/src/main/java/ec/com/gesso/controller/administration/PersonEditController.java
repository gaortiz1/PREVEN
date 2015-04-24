package ec.com.gesso.controller.administration;

import ec.com.gesso.application.dto.PersonDto;
import ec.com.gesso.application.dto.UserDto;
import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Person;
import ec.com.gesso.security.factory.GessoSecurityFactory;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Roberto on 23/04/2015.
 */
@Controller
@SessionAttributes()
public class PersonEditController {

    @RequestMapping(value="/person-edit", method= RequestMethod.GET,produces={"application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Collection<PersonDto> getPersonList() {
        Collection<Person> lstPersonas = null;
        Collection<PersonDto> lstPersonasDto = new ArrayList<PersonDto>();
        try {
            lstPersonas  = GessoSecurityFactory.getInstance().getSecurityService().findAllPersons();
        } catch (GessoException e) {
            e.printStackTrace();
        }

        ModelMapper modelMapper = new ModelMapper();

        for(Person obj: lstPersonas){
            lstPersonasDto.add(modelMapper.map(obj, PersonDto.class));
        }
        return lstPersonasDto;
    }
}
