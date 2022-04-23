package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {

    @GetMapping("/cars")
    public String getCar(@RequestParam(value = "count", defaultValue = "5") int allCars, Model model) {
        List<Car> list = new ArrayList<>();
        list.add(new Car("BMW", "red", 2020));
        list.add(new Car("Toyota", "green", 1997));
        list.add(new Car("Mercedes", "black", 2021));
        list.add(new Car("Volkswagen", "grey", 2011));
        list.add(new Car("Ford", "blue", 2007));
        list = CarService.carsCount(list, allCars);
        model.addAttribute("list", list);
        return "car";
    }
}
