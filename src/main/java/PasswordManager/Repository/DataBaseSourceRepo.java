package PasswordManager.Repository;

import PasswordManager.Models.MainModels.Source;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataBaseSourceRepo extends JpaRepository<Source,Long> {
}
