package ua.lpnu.lab4.mapper;


import org.springframework.stereotype.Component;
import ua.lpnu.lab4.dto.OrderDTO;
import ua.lpnu.lab4.entity.Order;
import ua.lpnu.lab4.entity.User;

@Component
public class OrderToOrderDTOMapper {

    public OrderDTO toDTO(Order order, User user) {
        final OrderDTO orderDTO = new OrderDTO();

        orderDTO.setId(order.getId());
        orderDTO.setDate(order.getDate());
        orderDTO.setCars(order.getCars());
        orderDTO.setSum(order.getSum());


        if (user != null) {
            orderDTO.setUserId(user.getId());
            orderDTO.setFirstname(user.getFirstname());
            orderDTO.setLastname(user.getLastname());
        }

        return orderDTO;
    }

    public Order toEntity(OrderDTO orderDTO) {
        final Order order = new Order();

        order.setId(orderDTO.getId());
        order.setDate(orderDTO.getDate());
        order.setCars(orderDTO.getCars());
        order.setSum(orderDTO.getSum());
        order.setUserId(orderDTO.getUserId());

        return order;
    }
}
