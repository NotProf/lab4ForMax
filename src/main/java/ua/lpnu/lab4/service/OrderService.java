package ua.lpnu.lab4.service;


import ua.lpnu.lab4.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    OrderDTO createNewOrder(OrderDTO orderDTO);

    List<OrderDTO> getAllByUserId(long userId);

    OrderDTO getById(long orderId);

}
