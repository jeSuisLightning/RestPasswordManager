package PasswordManager.Repository.Impl;

import PasswordManager.Exceptions.EntityNotFoundException;
import PasswordManager.Models.MainModels.Source;
import PasswordManager.Models.MainModels.User;
import PasswordManager.Repository.SourceRepo;
import PasswordManager.Repository.UserRepo;
import PasswordManager.Utils.BeanUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
@RequiredArgsConstructor
public class DataBaseSourceRepository implements SourceRepo {
    private UserRepo userRepo;
    private final Map<Long,Source> sourceMap = new ConcurrentHashMap();
    private final AtomicLong currentId = new AtomicLong(1);
    @Autowired
    public void setUserRepo(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public List<Source> findAll() {
        return new ArrayList<>(sourceMap.values());
    }

    @Override
    public Optional<Source> findById(Long id) {
        return Optional.ofNullable(sourceMap.get(id));
    }

    @Override
    public Source update(Source source) {
        Long sourceId = currentId.getAndIncrement();
        Source upsertSource = sourceMap.get(sourceId);
        if(upsertSource==null){
            throw new EntityNotFoundException(MessageFormat.format("",sourceId));
        }
        BeanUtil.copyNonNullProperties(sourceId,sourceMap);
        upsertSource.setId(sourceId);
        sourceMap.put(sourceId,source);
        return upsertSource;
    }

    @Override
    public Source create(Source source) {
        Long sourceId = currentId.getAndIncrement();
        Long userId = source.getUser().getId();
        User user = userRepo.findById(sourceId).orElseThrow(()->new EntityNotFoundException(MessageFormat.format("",sourceId))) ;
        source.setUser(user);
        source.setId(userId);
        user.addSource(source);
        sourceMap.put(sourceId,source);
        userRepo.update(user);
        return source;
    }

    @Override
    public void delete(Long id) {
        sourceMap.remove(id);

    }
    @Override
    public void deleteAll(List<Source> sources) {
        sources.removeAll(sources);
    }
}
