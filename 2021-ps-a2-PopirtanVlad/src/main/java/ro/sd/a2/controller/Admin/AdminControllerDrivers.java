package ro.sd.a2.controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ro.sd.a2.dto.ConstructorDto;
import ro.sd.a2.dto.DriverDto;
import ro.sd.a2.service.ConstructorService;
import ro.sd.a2.service.DriverService;

import javax.validation.Valid;
import java.util.UUID;

/**
 * Clasa ce controleaza view-ul pentru piloti pe pagina de administrator.
 */
@Controller
public class AdminControllerDrivers {

    @Autowired
    private DriverService driverService;

    @Autowired
    private ConstructorService constructorService;


    /**Functie ce afiseaza constructorii pe pagina administratorului*/
    @GetMapping("/admin_page_drivers")
    public ModelAndView showAdminDrivers(){
        ModelAndView mav = new ModelAndView();
        DriverDto driverDto=new DriverDto();
        mav.addObject(driverDto);
        mav.addObject("drivers",driverService.getAllDrivers());
        mav.addObject("constructors",constructorService.getAllConstructors());
        mav.setViewName("admin_page_drivers");
        return mav;
    }

    /** Functie ce adauga un nou pilot
     * @param driverConstructor Id-ul constructorului pentru care piloteaza pilotul.
     * @param driverDto Pilotul ce trebuie sters.
     * @return Functia returneaza un redirect la pagina ce afiseaza toti constructorii. Aceasta actioneaza ca un refresh.
     */
    @PostMapping("/addDriver")
    public RedirectView addDriver(@Valid String driverConstructor, @ModelAttribute("driverDto") DriverDto driverDto){
        driverDto.setDriver_id(UUID.randomUUID().toString());
        driverDto.setDriver_constructor_id(driverConstructor);
        driverService.addDriver(driverDto);
        return new RedirectView("http://localhost:7799/app/admin_page_drivers");
    }

    /**Functie ce sterge un driver
     * @param id Id-ul driver-ului ce trebuie sters.
     * @return Functia returneaza un redirect la pagina ce afiseaza toti pilotii. Aceasta actioneaza ca un refresh.
     */
    @GetMapping("/deleteDriver/{id}")
    public RedirectView deleteDriver(@PathVariable String id){
        driverService.deleteDriver(driverService.findDriverById(id));
        return new RedirectView("http://localhost:7799/app/admin_page_drivers");
    }
}
