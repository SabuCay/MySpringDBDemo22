package com.example.myspringdbdemo22.Controller;

import com.example.myspringdbdemo22.Model.Person;
import com.example.myspringdbdemo22.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.annotation.Retention;

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
    @GetMapping("/viewOne/{id}")
    public String viewOne(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personService.findPersonById(id));
        return "home/viewOne";
    }
    @GetMapping("/deleteOne/{id}")
    public String deleteOne(@PathVariable("id") int id){
        boolean deleted = personService.deletePerson(id);
        if (deleted){
            return "redirect:/";
        }else {
            return "redirect:/";
        }
    }
    @GetMapping("/updateOne/{id}")
    public String updateOne(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personService.findPersonById(id));
        return "home/updateOne";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Person person){
        personService.updatePerson(person);
        return "redirect:/";
    }
}
