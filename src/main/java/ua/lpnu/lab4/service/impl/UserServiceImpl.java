package ua.lpnu.lab4.service.impl;


import org.springframework.stereotype.Service;
import ua.lpnu.lab4.dto.UserDTO;
import ua.lpnu.lab4.entity.Order;
import ua.lpnu.lab4.entity.User;
import ua.lpnu.lab4.mapper.UserToUserDTOMapper;
import ua.lpnu.lab4.repository.UserRepository;
import ua.lpnu.lab4.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserToUserDTOMapper userToUserDTOMapper;

    public UserServiceImpl(UserRepository userRepository, UserToUserDTOMapper userToUserDTOMapper) {
        this.userRepository = userRepository;
        this.userToUserDTOMapper = userToUserDTOMapper;
    }

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        List<Order> orders = new ArrayList<>();
        User user = userToUserDTOMapper.toEntity(userDTO);
        return userToUserDTOMapper.toDTO(userRepository.save(user));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> all = userRepository.getAll();
        return  all.stream().map(userToUserDTOMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(long id) {
        return userToUserDTOMapper.toDTO(userRepository.getById(id));
    }
}
