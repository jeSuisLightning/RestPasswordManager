package PasswordManager.Service.implementation;

import PasswordManager.Exceptions.EntityNotFoundException;
import PasswordManager.Models.MainModels.User;
import PasswordManager.Repository.UserRepo;
import PasswordManager.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepo.findById(id).orElseThrow(()->new EntityNotFoundException(MessageFormat.format("",id)));
    }

    @Override
    public User create(User user) {
        return userRepo.create(user);
    }

    @Override
    public User update(User user) {
        return userRepo.create(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepo.delete(id);
    }
}



//    @Override
//    public List<User> findAll() {
//        return userService.findAll();
