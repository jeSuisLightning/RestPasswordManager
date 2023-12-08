package PasswordManager.Controllers;

import PasswordManager.Mappers.UserMapper;
import PasswordManager.Models.MainModels.User;
import PasswordManager.Models.UpsertUserResponse;
import PasswordManager.Models.UserListResponse;
import PasswordManager.Models.UserResponse;
import PasswordManager.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;
    @GetMapping
    public ResponseEntity<UserListResponse> showAll(){
        return ResponseEntity.ok(userMapper.userListToResponse(userService.findAll()));
    }
    @GetMapping("{id}")
    public ResponseEntity<UserResponse> showById(@PathVariable Long id){
        return ResponseEntity.ok(userMapper.userResponse(userService.findById(id)));
    }
    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UpsertUserResponse response){
        User upsertUser = userService.create(userMapper.requestToUser(response));
        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.userResponse(upsertUser));
    }
    @PutMapping("{id}")
    public ResponseEntity<UserResponse> update(@PathVariable("id") Long userId,@RequestBody
                                               UpsertUserResponse response){
        User updatedUser = userService.update(userMapper.requestToUser(userId,response));
        return ResponseEntity.ok(userMapper.userResponse(updatedUser));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
