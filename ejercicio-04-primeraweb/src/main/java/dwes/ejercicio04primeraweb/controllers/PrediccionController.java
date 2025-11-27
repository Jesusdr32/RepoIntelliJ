package dwes.ejercicio04primeraweb.controllers;

import dwes.ejercicio04primeraweb.services.PrediccionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrediccionController {


    private final PrediccionService prediccionService;

    public PrediccionController(PrediccionService prediccionService) {
        this.prediccionService = prediccionService;
    }

    @GetMapping("/prediccion")
    public ModelAndView prediccion() {
        ModelAndView mv = new ModelAndView("prediccion");
        mv.addObject("predicciones", prediccionService.getPrediccionSemana());

        return mv;
    }
}
