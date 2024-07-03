package CoinKeeper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import CoinKeeper.configuration.jwt.JwtUtils;

@RequestMapping("/coinkeeper")
@Controller
public class HomeController {

    @Autowired
    private JwtUtils jwt;

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
    public ModelAndView painel(@CookieValue(name = "token") String token) {
        ModelAndView mv = new ModelAndView();
        
        if (jwt.validateJwtToken(token))
            mv.setViewName("/logged/painel");

        return mv;
    }

    @GetMapping("/perfil")
    public ModelAndView perfil() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/logged/perfil");
        return mv;
    }

    @GetMapping("/config")
    public ModelAndView config() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/logged/config");
        return mv;
    }

    @GetMapping("/logout")
    public ModelAndView logout() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
        return mv;
    }
}
