package PasswordManager.Models;

import PasswordManager.Models.MainModels.User;
import lombok.Data;

@Data
public class UpsertSourceRequest
{
    private Long userId;
    private String name;

}
