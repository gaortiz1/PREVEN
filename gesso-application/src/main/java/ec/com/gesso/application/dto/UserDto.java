package ec.com.gesso.application.dto;

/**
 * Created by Roberto on 19/04/2015.
 */
public class UserDto {
    private String nickName;
    private String password;

    public UserDto() {}

    public UserDto(String nickName, String password) {
        this.nickName = nickName;
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
