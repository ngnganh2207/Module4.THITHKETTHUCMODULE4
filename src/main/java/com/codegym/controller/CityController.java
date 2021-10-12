package com.codegym.controller;

import com.codegym.model.City;
import com.codegym.model.Nation;
import com.codegym.service.ICityService;
import com.codegym.service.INationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@PropertySource("classpath:upload_file.properties")
public class CityController {
    @Value("${file-upload")
    private String fileUpload;

    @Autowired
    private ICityService cityService;
    @Autowired
    private INationService nationService;

    @ModelAttribute("nations")
    public Iterable<Nation> Nation(){
        return nationService.findAll();
    }

    @RequestMapping("/")
    public ModelAndView listCity(){
        Iterable<City> cities= cityService.findAll();
        ModelAndView modelAndView=new ModelAndView("city/list");
        modelAndView.addObject("listCity", cities);
        return modelAndView;
    }

    @GetMapping("/detail/city/{id}")
    public ModelAndView detailNationForm(@PathVariable Long id){
        Optional<City> city= cityService.findById(id);
        ModelAndView modelAndView= new ModelAndView("city/detail");
        modelAndView.addObject("city", city.get());
        return modelAndView;
    }

    @GetMapping("/create/city")
    public ModelAndView showCreateCityForm(){
//        Iterable<Nation> nations= nationService.findAll();
        ModelAndView modelAndView= new ModelAndView("city/add");
        modelAndView.addObject("city",new City());
//        modelAndView.addObject("nations", nations);
        return modelAndView;
    }

    @PostMapping("/create/city")
    public Object saveCityForm(@Validated @ModelAttribute("city") City city, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "city/add";
        }
        cityService.save(city);
        ModelAndView modelAndView=new ModelAndView("city/add");
        modelAndView.addObject("city",new City());
        modelAndView.addObject("message","Create City Successfully");
        return modelAndView;
    }

    @GetMapping("/edit/city/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Optional<City> city= cityService.findById(id);
        if(city.isPresent()){
            ModelAndView modelAndView= new ModelAndView("city/edit");
            modelAndView.addObject("city",city.get());
            return modelAndView;
        }else {
            ModelAndView modelAndView= new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit/city/")
    public Object updateCity(@Validated @ModelAttribute("city") City city, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "city/edit";
        }
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("city/edit");
        modelAndView.addObject("city", city);
        modelAndView.addObject("message", "City updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete/city/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Optional<City> city= cityService.findById(id);
        if(city.isPresent()){
            ModelAndView modelAndView= new ModelAndView("city/delete");
            modelAndView.addObject("city",city.get());
            return modelAndView;
        }else {
            ModelAndView modelAndView= new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete/city/")
    public String deleteCity(@ModelAttribute("city") City city){
        cityService.remove(city.getId());
        return "redirect:/";
    }


}
