package ua.lpnu.lab4.repository;


import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import ua.lpnu.lab4.entity.User;
import ua.lpnu.lab4.exception.ServiceException;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private List<User> users;

    public long count;

    @PostConstruct
    private void initList() {
        count = 0;
        users = new ArrayList<>();
    }

    public List<User> getAll() {
        return users;
    }

    public User save(User user) {
        ++count;
        user.setId(count);
        users.add(user);

        return user;
    }

    public User getById(long id) {
        Optional<User> first = users.stream().filter((user -> user.getId() == id)).findFirst();

        if (first.isPresent()) {
            return first.get();
        } else {
            throw new ServiceException(HttpStatus.NOT_FOUND.value(), "User not found", null);
        }
    }

    public User update(User user) {
        User byId = this.getById(user.getId());
        users.remove(byId);
        users.add(user);
        return user;
    }
}
