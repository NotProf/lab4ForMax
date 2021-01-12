package ua.lpnu.lab4.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ua.lpnu.lab4.dto.CarDTO;
import ua.lpnu.lab4.dto.OrderDTO;
import ua.lpnu.lab4.entity.Car;
import ua.lpnu.lab4.entity.Order;
import ua.lpnu.lab4.entity.User;
import ua.lpnu.lab4.exception.ServiceException;
import ua.lpnu.lab4.mapper.CarToCarDTOMapper;
import ua.lpnu.lab4.mapper.OrderToOrderDTOMapper;
import ua.lpnu.lab4.repository.CarRepository;
import ua.lpnu.lab4.repository.OrderRepository;
import ua.lpnu.lab4.repository.UserRepository;
import ua.lpnu.lab4.service.CarService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarToCarDTOMapper carToCarDTOMapper;
    private final OrderRepository orderRepository;
    private final OrderToOrderDTOMapper orderToOrderDTOMapper;
    private final UserRepository userRepository;


    public CarServiceImpl(CarRepository carRepository, CarToCarDTOMapper carToCarDTOMapper, OrderRepository orderRepository, OrderToOrderDTOMapper orderToOrderDTOMapper, UserRepository userRepository) {
        this.carRepository = carRepository;
        this.carToCarDTOMapper = carToCarDTOMapper;
        this.orderRepository = orderRepository;
        this.orderToOrderDTOMapper = orderToOrderDTOMapper;
        this.userRepository = userRepository;
    }

    @Override
    public CarDTO createNewCar(CarDTO carDTO) {
        Car car = carToCarDTOMapper.toEntity(carDTO);
        return carToCarDTOMapper.toDTO(carRepository.save(car));
    }

    @Override
    public List<CarDTO> getAllCarsByOrderId(long orderId) {
        Order order = orderRepository.getById(orderId);
        List<Car> cars = order.getCars();
        if (cars == null) {
            throw new ServiceException(HttpStatus.NOT_FOUND.value(), "List is empty", null);
        }
        return order.getCars().stream().map(carToCarDTOMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public CarDTO getCarById(long carId) {
        return carToCarDTOMapper.toDTO(carRepository.getById(carId));
    }

    @Override
    public List<CarDTO> getAllCars() {
        return carRepository.getAll().stream().map(carToCarDTOMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public OrderDTO addCarToOrder(long orderId, long carId) {
        Order order = orderRepository.getById(orderId);
        Car car = carRepository.getById(carId);
        User user = userRepository.getById(order.getUserId());
        List<Car> cars = order.getCars();
        if (cars == null) {
            cars = new ArrayList<>();
        }
        cars.add(car);
        order.setCars(cars);
        Double price = cars.stream().map(Car::getPrice).reduce(0.0, Double::sum);
        order.setSum(price);
        return orderToOrderDTOMapper.toDTO(orderRepository.update(order), user);
    }
}
