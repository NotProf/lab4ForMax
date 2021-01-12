package ua.lpnu.lab4.controller;

import org.springframework.web.bind.annotation.*;
import ua.lpnu.lab4.dto.UserDTO;
import ua.lpnu.lab4.service.UserService;

import java.util.*;

@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.registerUser(userDTO);
    }

    @GetMapping("/")
    public List<UserDTO> getAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable long id) {
        return userService.getUserById(id);
    }
}
