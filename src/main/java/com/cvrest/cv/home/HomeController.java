package com.cvrest.cv.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
public class HomeController {

    private HomeService homeService;

    @Autowired
    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/")
    public String getHome(Model model) {
        List<Project> projects = homeService.getAll();
        if (projects.size() == 0) {
            return "error";
        }
        model.addAttribute("project", projects.get(0));
        return "projet";
    }

    @PostMapping(path = "/")
    @ResponseBody()
    public void addProjet(@RequestBody Project projet) {
        homeService.addProjet(projet);
    }
}
