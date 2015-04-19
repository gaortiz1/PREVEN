package ec.com.gesso.application.test.mapping;

import ec.com.gesso.application.dto.PersonDto;
import ec.com.gesso.model.entity.Person;
import ec.com.gesso.model.entity.User;
import org.junit.Test;
import org.modelmapper.ModelMapper;

/**
 * Created by Roberto on 19/04/2015.
 */
public class TestUserMapping {
    @Test
    public void mappUser(){
        ModelMapper modelMapper = new ModelMapper();
        Person user = new Person();
        user.setPersonalEmail("maniac787");
        user.setUserDto(new User("usuaio","clave"));



        PersonDto orderDTO = modelMapper.map(user, PersonDto.class);
        System.out.println(orderDTO);
    }
}
