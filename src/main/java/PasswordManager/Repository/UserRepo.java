package PasswordManager.Repository;

import PasswordManager.Models.MainModels.User;

import java.util.List;
import java.util.Optional;

public interface UserRepo {
    List<User> findAll();
    Optional<User> findById(Long id);
    User create(User user);
    User update(User user);
    void delete(Long id);
}
