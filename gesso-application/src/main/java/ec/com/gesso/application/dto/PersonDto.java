package ec.com.gesso.application.dto;

/**
 * Created by Roberto on 19/04/2015.
 */
public class PersonDto {
    private UserDto userDto;
    private String personalEmail;

    public PersonDto() {

    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
