package PasswordManager.Models;

import PasswordManager.Models.MainModels.Source;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserListResponse {
    List<UserResponse> users = new ArrayList<>();
}
