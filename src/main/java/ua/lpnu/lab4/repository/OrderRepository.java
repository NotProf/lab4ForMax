package ua.lpnu.lab4.repository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import ua.lpnu.lab4.entity.Order;
import ua.lpnu.lab4.exception.ServiceException;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class OrderRepository {
    private List<Order> orderList;
    private long count;

    @PostConstruct
    public void initOrders() {
        orderList = new ArrayList<>();
        count = 0;
    }

    public List<Order> getAll() {
        return orderList;
    }

    public Order save(Order order) {
        ++count;
        order.setId(count);
        orderList.add(order);
        return order;
    }

    public Order getById(long id) {
        Optional<Order> first = orderList.stream().filter((order -> order.getId() == id)).findFirst();

        if (first.isPresent()) {
            return first.get();
        } else {
            throw new ServiceException(HttpStatus.NOT_FOUND.value(), "Order not exist", null);
        }
    }

    public Order update(Order order) {
        Order byId = this.getById(order.getId());
        orderList.remove(byId);
        orderList.add(order);
        return order;
    }

    public List<Order> getByUserId(long userId) {
       return orderList.stream().filter((o) -> o.getUserId() == userId).collect(Collectors.toList());
    }

}
