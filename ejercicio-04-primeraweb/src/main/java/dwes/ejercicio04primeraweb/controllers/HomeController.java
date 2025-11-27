package dwes.ejercicio04primeraweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {


    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("titulo", "Página principal");

        return mv;
    }

}
