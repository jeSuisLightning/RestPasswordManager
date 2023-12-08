package PasswordManager.Models;

import PasswordManager.Models.MainModels.Source;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserResponse {
    private String userName;
    List<SourceResponse> sources = new ArrayList<>();
    private Long id;

}
