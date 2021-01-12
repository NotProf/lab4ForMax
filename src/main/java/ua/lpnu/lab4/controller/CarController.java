package ua.lpnu.lab4.controller;

import org.springframework.web.bind.annotation.*;
import ua.lpnu.lab4.dto.CarDTO;
import ua.lpnu.lab4.dto.OrderDTO;
import ua.lpnu.lab4.service.CarService;
import java.util.*;

@RestController
@RequestMapping("car")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/")
    public CarDTO createCar(@RequestBody CarDTO carDTO) {
        return carService.createNewCar(carDTO);
    }

    @GetMapping("/")
    public List<CarDTO> getAll(){
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public CarDTO getById(@PathVariable long id){
        return carService.getCarById(id);
    }

    @GetMapping("/getByOrderId/{id}")
    public List<CarDTO> getByOrderId (@PathVariable long id){
        return carService.getAllCarsByOrderId(id);
    }

    @GetMapping("/addCarToOrder/order/{orderId}/car/{carId}")
    public OrderDTO addCarToOrder(@PathVariable long orderId, @PathVariable long carId){
        return carService.addCarToOrder(orderId, carId);
    }
}
