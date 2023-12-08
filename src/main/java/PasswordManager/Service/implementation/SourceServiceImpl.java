package PasswordManager.Service.implementation;

import PasswordManager.Exceptions.EntityNotFoundException;
import PasswordManager.Models.MainModels.Source;
import PasswordManager.Repository.SourceRepo;
import PasswordManager.Service.SourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SourceServiceImpl implements SourceService  {
    private final SourceRepo sourceRepo;
    private final SourceService sourceService;

    @Override
    public List<Source> findAll() {
        return sourceRepo.findAll();
    }

    @Override
    public Source findById(Long id) {
        return sourceRepo.findById(id)
                .orElseThrow(()->new EntityNotFoundException(MessageFormat.format("",id)));
    }

    @Override
    public Source create(Source source) {
        return sourceRepo.create(source);
    }

    @Override
    public Source update(Source source) {
        return sourceRepo.update(source);
    }

    @Override
    public void deleteById(Long id) {
        sourceRepo.delete(id);
    }
}
