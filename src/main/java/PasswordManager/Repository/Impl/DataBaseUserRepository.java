package PasswordManager.Repository.Impl;

import PasswordManager.Exceptions.EntityNotFoundException;
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
public class DataBaseUserRepository implements UserRepo {
    private SourceRepo sourceRepo;
    private final Map<Long,User> userMap = new ConcurrentHashMap<>();
    private final AtomicLong currentId = new AtomicLong(1);
    @Autowired
    public void setSourceRepo(SourceRepo sourceRepo){
        this.sourceRepo = sourceRepo;
    }
    @Override
    public List<User> findAll() {
        return new ArrayList<>(userMap.values());
    }
    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(userMap.get(currentId));
    }

    @Override
    public User create(User user) {
        Long userId = currentId.getAndIncrement();
        user.setId(userId);
        userMap.put(userId,user);
        return user;
    }

    @Override
    public User update(User user) {
        Long userId = user.getId();
        User upsertUser = userMap.get(userId);
        if (userId==null){
            throw new EntityNotFoundException(MessageFormat.format("",userId));
        }
        BeanUtil.copyNonNullProperties(user,userId);
        upsertUser.setId(userId);
        userMap.put(userId,user);
        return upsertUser;
    }

    @Override
    public void delete(Long id) {
        User user = userMap.get(id);
        if (id==null){
            throw new EntityNotFoundException(MessageFormat.format("",id));
        }
        userMap.remove(id);
    }
}
