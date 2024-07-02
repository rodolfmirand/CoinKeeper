package CoinKeeper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/coinkeeper")
@Controller
public class HomeController {
    
    @GetMapping("/home")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
        return mv;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/cadastrar");
        return mv;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/login");
        return mv;
    }

    @GetMapping("/painel")
    public ModelAndView painel() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("logged/painel");
        return mv;
    }

    @GetMapping("/perfil")
    public ModelAndView perfil() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("logged/perfil");
        return mv;
    }

    @GetMapping("/config")
    public ModelAndView config() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("logged/config");
        return mv;
    }

    // fazer logout
}
