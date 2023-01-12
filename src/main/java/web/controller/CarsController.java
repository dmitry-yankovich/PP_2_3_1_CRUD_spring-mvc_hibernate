package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarServiceImpl;

import java.util.Optional;

@Controller
@RequestMapping("cars")
public class CarsController {

    private final CarServiceImpl carService;

    @Autowired
    public CarsController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping
    //public String index(@RequestParam(value = "count", required = false)Optional<Integer> count, Model model) {
    public String index(@RequestParam(value = "count", required = false, defaultValue = "5") int count, Model model) {
        //count = (!count.isPresent()) ? Optional.of(0) : count;
        //model.addAttribute("cars", carService.carList(count.get()));
        model.addAttribute("cars", carService.carList(count));
        return "cars";
    }
}
