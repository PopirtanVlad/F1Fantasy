package ro.sd.a2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a2.dto.UserDto;
import ro.sd.a2.entity.UsersEntity;
import ro.sd.a2.mapper.UserMapper;
import ro.sd.a2.service.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    static final Logger log= LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getAllUsers() {
        List<UserDto> userDtos=new ArrayList<>();
        for(UsersEntity u:userRepository.findAll()){
            userDtos.add(UserMapper.entityToDto(u));
        }
        return userDtos;
    }

    public UserDto getUserByMail(String email){
        if(userRepository.find(email)==null){
            return null;
        }
        return UserMapper.entityToDto(userRepository.find(email));
    }

    public void updateUser(UserDto userDto ){
        userRepository.save(UserMapper.dtoToEntity(userDto));
    }

    public UserDto findUserById(String id){
        return UserMapper.entityToDto(userRepository.findById(id).get());
    }

    public void addUser(UserDto userDto){
        userRepository.save(UserMapper.dtoToEntity(userDto));
    }
}
