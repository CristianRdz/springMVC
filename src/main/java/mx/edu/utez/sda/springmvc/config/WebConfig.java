package mx.edu.utez.sda.springmvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/form").setViewName("form");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/ninio").setViewName("ninio");
        registry.addViewController("/adulto").setViewName("adulto");
        registry.addViewController("/accion").setViewName("accion");
        registry.addViewController("/risas").setViewName("risas");
        registry.addViewController("/terror").setViewName("terror");
        registry.addViewController("/aventura").setViewName("aventura");
        registry.addViewController("/adultos").setViewName("adultos");
        registry.addViewController("/documentales").setViewName("documentales");


    }


}
