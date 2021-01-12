package ua.lpnu.lab4.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Car {
    private long id;
    private  String model;
    private LocalDate dateOfMaufacture;
    private double price;
}
