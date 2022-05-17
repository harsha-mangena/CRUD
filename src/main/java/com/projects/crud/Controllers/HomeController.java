package com.projects.crud.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    /**
     * API : /Home
     * TYPE : GET
     * @return : Message <String>
     */
    @GetMapping("/Home")
    private String getHomeMessage()
    {
        return "<center><h2><i>Welcome to Employee Management System.</i></h2></center>";
    }
    
}
