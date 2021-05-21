package ro.sd.a2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ro.sd.a2.dto.UserDto;
import ro.sd.a2.service.UserService;
import ro.sd.a2.service.repository.UserRepository;

import java.util.UUID;

@SpringBootApplication
public class Assignment2SdApplication {

    public static void main(String[] args) {
        SpringApplication.run(Assignment2SdApplication.class, args);


    }

}
