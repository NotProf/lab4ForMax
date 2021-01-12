package ua.lpnu.lab4.service;


import ua.lpnu.lab4.dto.UserDTO;

import java.util.List;


public interface UserService {

    UserDTO registerUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();

    UserDTO getUserById(long id);
}
