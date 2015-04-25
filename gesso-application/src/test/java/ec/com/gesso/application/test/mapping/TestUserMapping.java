package ec.com.gesso.application.test.mapping;

import ec.com.gesso.application.dto.PersonDto;
import ec.com.gesso.model.entity.Person;
import ec.com.gesso.model.entity.User;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.internal.asm.Type;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Roberto on 19/04/2015.
 */
public class TestUserMapping {
    @Test
    public void mappUser(){
        ModelMapper modelMapper = new ModelMapper();

        Person user = new Person();
        user.setPersonalEmail("maniac787");
        user.setUserDto(new User("usuaio", "clave"));



        PersonDto orderDTO = modelMapper.map(user, PersonDto.class);
        System.out.println(orderDTO);


        Collection<Person> lst = new ArrayList<Person>(2);
        Collection<PersonDto> result = null;
        lst.add(user);
        java.lang.reflect.Type listType = new TypeToken<List<PersonDto>>() {}.getType();
        result = modelMapper.map(lst, listType );
        System.out.println(result);
    }
}
