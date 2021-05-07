package org.epsi.Controller;

import org.epsi.Dao.UtilisateurDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccueilController {

    @Autowired
    UtilisateurDao utilisateurDao;

    @RequestMapping("/")
    public String accueil() {
        System.out.println("Execute la méthode Accueil");
        return "home";
    }

    @RequestMapping("/valider")
    public ModelAndView valider(@RequestParam("email") String email, @RequestParam("motDePasse") String motDePasse) {

        ModelAndView mv = new ModelAndView("Accueil");

        if (utilisateurDao.valider(email, motDePasse) != null) {
            mv.addObject("successMsg", "Vous êtes connecté");
        } else {
            mv.addObject("errorMsg", "Vos données sont incorrect, veuillez recommencer");
        }

        return mv;
    }
}
