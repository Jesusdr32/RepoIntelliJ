package dwes.ejemplo04primeraweb.controllers;

import dwes.ejemplo04primeraweb.entities.User;
import dwes.ejemplo04primeraweb.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private final UserRepository userRepository;

    public HomeController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //@RequestMapping(method = RequestMethod.GET, path = "/")
    @GetMapping("/")
    @PostMapping("/")
    public String index() {
        System.out.println("HomeController.index()");
        User user = userService
        return "index";
    }
}
