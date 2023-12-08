package PasswordManager.Repository;

import PasswordManager.Models.MainModels.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataBaseUserRepo extends JpaRepository<User,Long>{
}
