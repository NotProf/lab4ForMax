package ua.lpnu.lab4.entity;

import lombok.Data;

import java.time.LocalDate;
import java.util.*;

@Data
public class Order {
    private long id;
    private List<Car> cars;
    private long userId;
    private double sum;
    private LocalDate date;
}
