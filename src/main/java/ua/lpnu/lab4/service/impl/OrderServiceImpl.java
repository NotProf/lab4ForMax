package ua.lpnu.lab4.service.impl;


import org.springframework.stereotype.Service;
import ua.lpnu.lab4.dto.OrderDTO;
import ua.lpnu.lab4.entity.Order;
import ua.lpnu.lab4.entity.User;
import ua.lpnu.lab4.mapper.OrderToOrderDTOMapper;
import ua.lpnu.lab4.repository.OrderRepository;
import ua.lpnu.lab4.repository.UserRepository;
import ua.lpnu.lab4.service.OrderService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderToOrderDTOMapper orderToOrderDTOMapper;
    private final UserRepository userRepository;

    public OrderServiceImpl(OrderRepository orderRepository, OrderToOrderDTOMapper orderToOrderDTOMapper, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.orderToOrderDTOMapper = orderToOrderDTOMapper;
        this.userRepository = userRepository;
    }

    @Override
    public OrderDTO createNewOrder(OrderDTO orderDTO) {
        User user = userRepository.getById(orderDTO.getUserId());

        Order order = orderToOrderDTOMapper.toEntity(orderDTO);
        Order saved = orderRepository.save(order);

        return orderToOrderDTOMapper.toDTO(saved, user);
    }

    @Override
    public List<OrderDTO> getAllByUserId(long userId) {
        User user = userRepository.getById(userId);
        return orderRepository.getByUserId(userId).stream()
                .map((o) -> orderToOrderDTOMapper.toDTO(o, user))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO getById(long orderId) {
        Order order = orderRepository.getById(orderId);
        User user = userRepository.getById(order.getId());
        return orderToOrderDTOMapper.toDTO(order, user);
    }
}
