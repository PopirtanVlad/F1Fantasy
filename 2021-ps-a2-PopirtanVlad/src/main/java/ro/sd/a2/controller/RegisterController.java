package ro.sd.a2.controller;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ro.sd.a2.dto.UserDto;
import ro.sd.a2.service.UserService;
import ro.sd.a2.utils.RabbitMQ.RabbitMQConfig;

import java.util.UUID;

/** Clasa ce controleaza view-ul pentru register, dar si pentru login.
 */
@Controller
public class RegisterController {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private UserService userService;

    /**Pagina de register
     */
    @GetMapping("/register")
    public ModelAndView showRegisterForm(){
        ModelAndView mav = new ModelAndView();
        UserDto userDto=new UserDto();
        mav.addObject("userDto",userDto);
        mav.setViewName("register");
        return mav;
    }

    /**Metoda ce inregistreaza un utilzator nou. Aceasta verifica daca utilizatorul exista, daca nu, il adauga in baza de date.
     * @param userDto Utilizatorul inregistrat
     * @return Dupa ce a indeplinit inregistrarea, metoda trimite utilizatorul la pagina de login.
     */
   @PostMapping("/registerPressed")
    public RedirectView submitForm(@ModelAttribute("userDto") UserDto userDto){
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl("register");
        try{
            System.out.println(userService.getUserByMail(userDto.getUser_email())==null);
            if(userService.getUserByMail(userDto.getUser_email())==null) {
                userDto.setUser_type('U');
                userDto.setUser_id(UUID.randomUUID().toString());
                userService.addUser(userDto);
                template.convertAndSend(RabbitMQConfig.TOPIC_EXCHANGE_NAME,RabbitMQConfig.ROUTING_KEY_NAME,userDto);
                redirectView.setUrl("login");
            }
            else{
                System.out.println("User already exists");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return redirectView;
    }

    /**Pagina de login
     */
    @GetMapping("/login")
    public ModelAndView showLoginForm(){
        ModelAndView mav = new ModelAndView();
        UserDto userDto=new UserDto();
        mav.addObject("userDto",userDto);
        mav.setViewName("login");
        return mav;
    }

    /**Metoda apelata atunci cand utilizatorul apasa pe butonul login.
     * @param userDto Utilizatorul care se loggeaza
     * @return Daca utilizatorul este de tipul administrator, programul il va trimite catre pagina de administrator,
     * altfel il va redirectiona catre pagina in care isi poate vedea echipele sale.
     */
    @PostMapping("/loginPressed")
    public RedirectView loginForm(@ModelAttribute("userDto") UserDto userDto){
        UserDto currUser=userService.getUserByMail(userDto.getUser_email());
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl("login");
        if(currUser!=null && currUser.getUser_password().equals(userDto.getUser_password())) {
            if(currUser.getUser_type()=='U') {
                redirectView.setUrl("profile/" + currUser.getUser_id());
            }
            else{
                redirectView.setUrl("admin_page_users");
            }
        }
        else{
            System.out.println("Invalid credentials");
        }
        return redirectView;
    }

    @PostMapping("/forgotPassword")
    public RedirectView forgotPassword(){
        return new RedirectView("/forgotPasswordPace");
    }

}
