package ua.lpnu.lab4.controller;


import org.springframework.web.bind.annotation.*;
import ua.lpnu.lab4.dto.OrderDTO;
import ua.lpnu.lab4.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/")
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.createNewOrder(orderDTO);
    }

    @GetMapping("/{id}")
    public OrderDTO getById(@PathVariable long id) {
        return orderService.getById(id);
    }

    @GetMapping("/getByUserId/{userId}")
    public List<OrderDTO> getByUserId(@PathVariable long userId) {
        return orderService.getAllByUserId(userId);
    }
}
