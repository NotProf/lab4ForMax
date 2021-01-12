package ua.lpnu.lab4.mapper;

import org.springframework.stereotype.Component;
import ua.lpnu.lab4.dto.CarDTO;
import ua.lpnu.lab4.entity.Car;

@Component
public class CarToCarDTOMapper {

    public Car toEntity(CarDTO carDTO) {
        Car car = new Car();
        car.setId(carDTO.getId());
        car.setModel(carDTO.getModel());
        car.setPrice(carDTO.getPrice());
        car.setDateOfMaufacture(carDTO.getDateOfManufacture());

        return car;
    }

    public CarDTO toDTO(Car car) {
        CarDTO carDTO = new CarDTO();

        carDTO.setId(car.getId());
        carDTO.setModel(car.getModel());
        carDTO.setPrice(car.getPrice());
        carDTO.setDateOfManufacture(car.getDateOfMaufacture());

        return carDTO;
    }
}
