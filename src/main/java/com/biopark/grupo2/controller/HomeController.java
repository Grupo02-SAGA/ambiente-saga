package com.biopark.grupo2.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping("/")
    public ModelAndView getMenuPage() {
        ModelAndView getMenuPage = new ModelAndView();
        getMenuPage.setViewName("Home");
        return  getMenuPage;
    }
}
