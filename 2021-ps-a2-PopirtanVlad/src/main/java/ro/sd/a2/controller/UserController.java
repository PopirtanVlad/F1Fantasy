package ro.sd.a2.controller;

import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ro.sd.a2.dto.UserDto;
import ro.sd.a2.service.UserService;
import ro.sd.a2.strategyPattern.IFile;
import ro.sd.a2.strategyPattern.PDFGenerator;
import ro.sd.a2.strategyPattern.TXTGenerator;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class UserController {

    private static IFile strategy;

    private String user_id;

    @Autowired
    private UserService userService;


    /**Pagina in care utilizatorul isi poate vedea, crea sau edita echipele.
     * @param user_id Id-ul utilizatorului care este loggat.
     */
    @GetMapping("profile/{user_id}")
    public ModelAndView showMyTeams(@PathVariable String user_id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("userDto",userService.getAllUsers());
        mav.setViewName("my_teams");
        this.user_id=user_id;
        return mav;
    }

    /**Pagina in care utilizatorul poate toate ligile,dar si ligile in care este inscris.
     * @param user_id Id-ul utilizatorului care este loggat.
     */
    @GetMapping("profile/leagues/{user_id}")
    public ModelAndView showLeagues(@PathVariable String user_id){
        ModelAndView mav = new ModelAndView();
        UserDto userDto=new UserDto();
        mav.addObject("userDto",userDto);
        mav.setViewName("leagues");
        return mav;
    }

    @PostMapping("profile/downloadInfo")
    public RedirectView generatePdf(@Valid String pointsScoring) throws IOException, DocumentException {
        if(pointsScoring.equals("TXT")){
            strategy=new TXTGenerator();
        }
        else{
            strategy=new PDFGenerator();
        }
        strategy.generateFile();
        return new RedirectView("http://localhost:7799/app/profile/"+this.user_id);
    }
}
