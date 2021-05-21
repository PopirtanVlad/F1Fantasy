package ro.sd.a2.controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ro.sd.a2.dto.RaceDto;
import ro.sd.a2.service.RaceService;

import java.util.UUID;


/**Clasa ce controleaza view-ul pentru grand prix-uri pe pagina de administrator.*/
@Controller
public class AdminControllerRaces {

    @Autowired
    private RaceService raceService;

    /**Functie ce afiseaza grand prix-urile pe pagina administratorului*/
    @GetMapping("/admin_page_races")
    public ModelAndView showAdminRaces(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("raceDto",new RaceDto());
        mav.addObject("races",raceService.getAllRaces());
        mav.setViewName("admin_page_races");
        return mav;
    }

    /**Metoda ce sterge un grand prix din calendar
     * @param id Id-ul grand prix-ului pe care dorim sa il stergem
     * @return Functia returneaza un redirect la pagina ce afiseaza toti constructorii. Aceasta actioneaza ca un refresh.
     */
    @GetMapping("/deleteRace/{id}")
    public RedirectView deleteRace(@PathVariable String id){
        raceService.deleteRace(raceService.findRaceById(id));
        return new RedirectView("http://localhost:7799/app/admin_page_races");
    }

    /**Metoda ce adauga un grand prix in calendar
     * @param raceDto Grand prix-ul pe care dorim sa il stergem
     * @return Functia returneaza un redirect la pagina ce afiseaza toti constructorii. Aceasta actioneaza ca un refresh.
     */
    @PostMapping("/addRace")
    public RedirectView addRace(@ModelAttribute("raceDto") RaceDto raceDto){
        raceDto.setRace_id(UUID.randomUUID().toString());
        raceService.addRace(raceDto);
        return new RedirectView("http://localhost:7799/app/admin_page_races");
    }
}
