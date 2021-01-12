package ua.lpnu.lab4.dto;

import lombok.Data;
import ua.lpnu.lab4.entity.Car;
import ua.lpnu.lab4.entity.User;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrderDTO {
    private long id;
    private List<Car> cars;
    private long userId;
    private String firstname;
    private String lastname;
    private double sum;
    private LocalDate date;
}
