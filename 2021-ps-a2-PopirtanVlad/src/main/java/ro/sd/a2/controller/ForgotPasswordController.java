package ro.sd.a2.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ro.sd.a2.dto.UserDto;
import ro.sd.a2.service.UserService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class ForgotPasswordController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/forgot_password")
    public ModelAndView showForgotPasswordForm(){
        ModelAndView mav = new ModelAndView();
        UserDto userDto=new UserDto();
        mav.addObject("userDto",userDto);
        mav.setViewName("forgot_password");
        return mav;
    }

    @PostMapping("/forgotPasswordPressed")
    public RedirectView redirectToLogin(@ModelAttribute("userDto") UserDto userDto) throws MessagingException, IOException {

        UserDto requestedUser = userService.getUserByMail(userDto.getUser_email());
        restTemplate.postForObject("http://localhost:7798/mail-service/sendMail", requestedUser, UserDto.class);
        return new RedirectView("login");
    }

}
