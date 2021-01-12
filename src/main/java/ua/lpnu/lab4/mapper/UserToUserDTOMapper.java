package ua.lpnu.lab4.mapper;

import org.springframework.stereotype.Component;
import ua.lpnu.lab4.dto.UserDTO;
import ua.lpnu.lab4.entity.User;

@Component
public class UserToUserDTOMapper {

    public UserDTO toDTO(User user) {
        final UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setFirstname(user.getFirstname());
        userDTO.setLastname(user.getLastname());
        userDTO.setBirthday(user.getBirthday());

        return userDTO;
    }

    public User toEntity(UserDTO userDTO) {
        final User user = new User();

        user.setId(userDTO.getId());
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setBirthday(userDTO.getBirthday());

        return user;
    }
}
