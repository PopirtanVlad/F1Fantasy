package ro.sd.a2.controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ro.sd.a2.dto.ConstructorDto;
import ro.sd.a2.service.ConstructorService;

import java.util.UUID;
/**Clasa ce controleaza view-ul pentru constructori pe pagina de administrator.*/
@Controller
public class AdminControllerConstructors {

    @Autowired
    private ConstructorService constructorService;

    /**Functie ce afiseaza constructorii pe pagina administratorilor*/
    @GetMapping("/admin_page_constructors")
    public ModelAndView showAdminConstructors(){
        ModelAndView mav = new ModelAndView();
        ConstructorDto constructorDto=new ConstructorDto();
        mav.addObject(constructorDto);
        mav.addObject("constructors",constructorService.getAllConstructors());
        mav.setViewName("admin_page_constructors");
        return mav;
    }

    /**Functie ce adauga un nou constructor
     * @param constructorDto Constructorul ce trebuie adaugat.
     * @return Functia returneaza un redirect la pagina ce afiseaza toti constructorii. Aceasta actioneaza ca un refresh.
     */
    @PostMapping("/addConstructor")
    public RedirectView addConstructor(@ModelAttribute("constructorDto") ConstructorDto constructorDto){
        constructorDto.setConstructor_id(UUID.randomUUID().toString());
        constructorService.addConstructor(constructorDto);
        return new RedirectView("http://localhost:7799/app/admin_page_constructors");
    }


    /**Functie ce sterge un constructor
     * @param id Id-ul constructorului ce trebuie sters.
     * @return Functia returneaza un redirect la pagina ce afiseaza toti constructorii. Aceasta actioneaza ca un refresh.
     */
    @GetMapping("/deleteConstructor/{id}")
    public RedirectView deleteConstructor(@PathVariable String id){
        constructorService.deleteConstructor(constructorService.findConstructorById(id));
        return new RedirectView("http://localhost:7799/app/admin_page_constructors");
    }
}
