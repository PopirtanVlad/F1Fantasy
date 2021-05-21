package ro.sd.a2.controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ro.sd.a2.dto.UserDto;
import ro.sd.a2.service.UserService;

/**Clasa ce controleaza view-ul pentru useri pe pagina de administrator.*/
@Controller
public class AdminControllerUsers {

    @Autowired
    private UserService userService;

    /**Functie ce afiseaza utilizatorii pe pagina administratorului
     */
    @GetMapping("/admin_page_users")
    public ModelAndView showAdminUsers(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("users",userService.getAllUsers());
        mav.setViewName("admin_page_users");
        return mav;
    }
}
