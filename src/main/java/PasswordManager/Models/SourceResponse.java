package PasswordManager.Models;

import PasswordManager.Models.MainModels.Source;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SourceResponse {

    private String name;
    private String login;
    private String password;


//    List<Source> sources = new ArrayList<>();
}
