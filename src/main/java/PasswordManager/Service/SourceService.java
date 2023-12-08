package PasswordManager.Service;

import PasswordManager.Models.MainModels.Source;

import java.util.List;
import java.util.Optional;

public interface SourceService {
    List<Source> findAll();
    Source findById(Long id);
    Source create(Source source);
    Source update(Source source);
    void deleteById(Long id);
}
