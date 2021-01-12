package ua.lpnu.lab4.repository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import ua.lpnu.lab4.entity.Car;
import ua.lpnu.lab4.exception.ServiceException;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CarRepository {
    private List<Car> carList;
    private long count;

    @PostConstruct
    public void initOrders() {
        carList = new ArrayList<>();
        count = 0;
    }

    public List<Car> getAll() {
        return carList;
    }

    public Car save(Car car) {
        ++count;
        car.setId(count);
        carList.add(car);
        return car;
    }

    public Car getById(long id) {
        Optional<Car> first = carList.stream().filter((order -> order.getId() == id)).findFirst();

        if (first.isPresent()) {
            return first.get();
        } else {
            throw new ServiceException(HttpStatus.NOT_FOUND.value(), "Order not found", null);
        }
    }

    public Car update(Car car) {
        Car byId = this.getById(car.getId());
        carList.remove(byId);
        carList.add(car);
        return car;
    }
}
