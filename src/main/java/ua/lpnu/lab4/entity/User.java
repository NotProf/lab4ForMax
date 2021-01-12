package ua.lpnu.lab4.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class User {
    private long id;
    private String firstname;
    private String lastname;
    private LocalDate birthday;
}
