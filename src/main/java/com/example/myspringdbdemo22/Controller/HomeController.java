package com.example.myspringdbdemo22.Controller;

import com.example.myspringdbdemo22.Model.Person;
import com.example.myspringdbdemo22.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @Autowired
    PersonService personService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("persons", personService.fetchAll());
        return "home/index";
    }
    @GetMapping("/create")
    public String create(){
        return "home/create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Person p){
        personService.addPerson(p);
        return "redirect:/";
    }
}
