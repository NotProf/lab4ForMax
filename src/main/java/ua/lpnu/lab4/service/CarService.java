package ua.lpnu.lab4.service;

import ua.lpnu.lab4.dto.CarDTO;
import ua.lpnu.lab4.dto.OrderDTO;

import java.util.List;

public interface CarService {
    CarDTO createNewCar(CarDTO carDTO);

    List<CarDTO> getAllCarsByOrderId(long orderId);

    CarDTO getCarById(long carId);

    List<CarDTO> getAllCars();

    OrderDTO addCarToOrder(long orderId, long carId);
}
