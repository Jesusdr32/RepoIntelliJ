package dwes.ejercicio04primeraweb.controllers;

import dwes.ejercicio04primeraweb.services.PersonaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonaController {
    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping("/personas")
    public ModelAndView listarPersonas() {
        ModelAndView mv = new ModelAndView("personas");
        mv.addObject("personas", personaService.find(10));

        return mv;
    }

    @GetMapping("/personas/una")
    public ModelAndView unaPersona() {
        ModelAndView mv = new ModelAndView("persona");
        mv.addObject("persona", personaService.findOne());

        return mv;
    }

}
