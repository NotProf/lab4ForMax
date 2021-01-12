package ua.lpnu.lab4.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {
    private long id;
    private String firstname;
    private String lastname;
    private LocalDate birthday;
}
