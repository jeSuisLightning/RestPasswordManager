package PasswordManager.Repository;

import PasswordManager.Models.MainModels.Source;

import java.util.List;
import java.util.Optional;

public interface SourceRepo {
    List<Source> findAll();
    Optional<Source> findById(Long id);
    Source update(Source source);
    Source create(Source source);
    void delete(Long id);
    void deleteAll(List<Source> sources);
}
