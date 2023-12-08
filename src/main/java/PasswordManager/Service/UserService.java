package PasswordManager.Service;

import PasswordManager.Models.MainModels.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User create(User user);
    User update(User user);
    void deleteById(Long id);
}
