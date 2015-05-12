package ec.com.gesso.controller.administration;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ec.com.gesso.application.dto.PersonDto;
import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Person;
import ec.com.gesso.security.factory.GessoSecurityFactory;

/**
 * Created by Roberto on 23/04/2015.
 */
@Controller
@SessionAttributes()
public class PersonEditController {


    @RequestMapping(value = "/person-edit", method = RequestMethod.GET)
    public ModelAndView processAdministration(){
        ProcessView processView = new ProcessView();
        try {
            processView.setLstProcess(GessoSecurityFactory.getInstance().getProcessService().findProcess());
        } catch (GessoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        ModelAndView modelAndView = new ModelAndView("person-edit", "command", processView);
        modelAndView.addObject("lstProcess", processView.getLstProcess());
        return modelAndView;
    }

    @RequestMapping(value="/load-person-list", method= RequestMethod.GET,produces={"application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Collection<PersonDto> getPersonList() {
        Collection<Person> lstPersonas = null;
        Collection<PersonDto> lstPersonasDto = null;
        try {
            lstPersonas  = GessoSecurityFactory.getInstance().getSecurityService().findAllPersons();
        } catch (GessoException e) {
            e.printStackTrace();
        }

        ModelMapper modelMapper = new ModelMapper();

        Type listType = new TypeToken<List<PersonDto>>() {}.getType();
        lstPersonasDto = modelMapper.map(lstPersonas, listType );

        return lstPersonasDto;
    }


    @RequestMapping(value = "/saveperson_json", method = RequestMethod.POST)
    public  @ResponseBody PersonDto savePerson_JSON( @RequestBody PersonDto personDto ) throws Exception {
        ModelMapper modelMapper = new ModelMapper();
        Person objPersist = modelMapper.map(personDto, Person.class);
        try {
            GessoSecurityFactory.getInstance().getSecurityService().persistPersonUpdate(objPersist);
        } catch (GessoException e) {
            throw new Exception("Error");
        }
        return personDto;
    }
}
