package ro.sd.a2.dto;

import java.util.UUID;

public class UserDto {

    private String user_id;

    private String user_name;

    private String user_password;

    private String user_email;

    private char user_type;

    private String user_birthdate;

    public UserDto() {
    }

    public UserDto(String user_name, String user_password, String user_email, char user_type, String user_birthdate) {
        this.user_id = UUID.randomUUID().toString();
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_email = user_email;
        this.user_type = user_type;
        this.user_birthdate=user_birthdate;
    }

    public String getUser_birthdate() {
        return user_birthdate;
    }

    public void setUser_birthdate(String user_birthdate) {
        this.user_birthdate = user_birthdate;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public char getUser_type() {
        return user_type;
    }

    public void setUser_type(char user_type) {
        this.user_type = user_type;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + user_id + '\'' +
                ", name='" + user_name + '\'' +
                '}';
    }
}
