package ro.sd.a2.mapper;

import ro.sd.a2.dto.UserDto;
import ro.sd.a2.entity.UsersEntity;
import ro.sd.a2.factory.UserFactory;

public class UserMapper {
    public static UserDto entityToDto(UsersEntity user){
        UserDto userDto=new UserDto();
        userDto.setUser_id(user.getUser_id());
        userDto.setUser_name(user.getUser_name());
        userDto.setUser_email(user.getUser_email());
        userDto.setUser_password(user.getUser_password());
        userDto.setUser_type(user.getUser_type());
        userDto.setUser_birthdate(user.getUser_birthdate());
        return userDto;
    }

    public static UsersEntity dtoToEntity(UserDto userDto){
        UsersEntity user= UserFactory.generateUser();
        user.setUser_id(userDto.getUser_id());
        user.setUser_name(userDto.getUser_name());
        user.setUser_email(userDto.getUser_email());
        user.setUser_password(userDto.getUser_password());
        user.setUser_type(userDto.getUser_type());
        user.setUser_birthdate(userDto.getUser_birthdate());
        return user;
    }
}
