package ua.lpnu.lab4.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CarDTO {
    private long id;
    private  String model;
    private LocalDate dateOfManufacture;
    private double price;
}
