package mx.edu.utez.sda.springmvc.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ControlPeliculas {

    @RequestMapping(value ="/",method = RequestMethod.GET)
    @Secured({"ROLE_RECE", "ROLE_NINIO", "ROLE_ADULTO"})
    public String index(Authentication authentication){
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            String userRole = authority.getAuthority();
            if (userRole.equals("ROLE_RECE")) {
                return "home";
            } else if (userRole.equals("ROLE_NINIO")) {
                return "ninio";
            } else if (userRole.equals("ROLE_ADULTO")) {
                return "adulto";
            }
        }
        return "index";
    }
}