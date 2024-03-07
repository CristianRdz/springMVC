package mx.edu.utez.sda.springmvc.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class ControlPeliculas {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @Secured({"ROLE_RECE", "ROLE_NINIO", "ROLE_ADULTO"})
    public String index(Authentication authentication) {
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
    // Rol de ninio debe poder acceder a las siguientes rutas
    //<li class="nav-item">
    //                    <a class="nav-link" href="/risas">Risas</a>
    //
    //                </li>
    //                <li class="nav-item">
    //                    <a class="nav-link" href="/aventuras">Aventuras</a>
    //                </li>
    //                <li class="nav-item">
    //                    <a class="nav-link" href="/documentales">Documentales</a>
    //                </li>
    //                <li>

    // Rol de adulto debe poder acceder a las siguientes rutas
    //<li class="nav-item">
    //                    <a class="nav-link" href="/risas">Risas</a>
    //
    //                </li>
    //                <li class="nav-item">
    //                    <a class="nav-link" href="/aventuras">Aventuras</a>
    //                </li>
    //                <li class="nav-item">
    //                    <a class="nav-link" href="/documentales">Documentales</a>
    //                </li>
    //                <li class="nav-item">
    //                    <a class="nav-link" href="/adultos">Adultos</a>
    //                </li>
    //
    //                <li class="nav-item">
    //                    <a class="nav-link" href="/accion">Accion</a>
    //                </li>
    //
    //                <li class="nav-item">
    //                    <a class="nav-link" href="/terror">Terror</a>
    //                </li>


    @RequestMapping(value = "/risas", method = RequestMethod.GET)
    @Secured({"ROLE_RECE", "ROLE_NINIO", "ROLE_ADULTO"})
    public String risas() {
        return "risas";
    }

    @RequestMapping(value = "/aventuras", method = RequestMethod.GET)
    @Secured({"ROLE_RECE", "ROLE_NINIO", "ROLE_ADULTO"})
    public String aventuras() {
        return "aventuras";
    }

    @RequestMapping(value = "/documentales", method = RequestMethod.GET)
    @Secured({"ROLE_RECE", "ROLE_NINIO", "ROLE_ADULTO"})
    public String documentales() {
        return "documentales";
    }

    @RequestMapping(value = "/adultos", method = RequestMethod.GET)
    @Secured({"ROLE_RECE", "ROLE_ADULTO"})
    public String adultos() {
        return "adultos";
    }

    @RequestMapping(value = "/accion", method = RequestMethod.GET)
    @Secured({"ROLE_RECE", "ROLE_ADULTO"})
    public String accion() {
        return "accion";
    }

    @RequestMapping(value = "/terror", method = RequestMethod.GET)
    @Secured({"ROLE_RECE", "ROLE_ADULTO"})
    public String terror() {
        return "terror";
    }
}
