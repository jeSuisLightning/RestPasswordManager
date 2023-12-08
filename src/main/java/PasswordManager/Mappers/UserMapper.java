package PasswordManager.Mappers;

import PasswordManager.Models.MainModels.User;
import PasswordManager.Models.UpsertSourceRequest;
import PasswordManager.Models.UpsertUserResponse;
import PasswordManager.Models.UserListResponse;
import PasswordManager.Models.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,uses = SourceMapper.class)
public interface UserMapper {
    User requestToUser(UpsertUserResponse request);
    @Mapping(source = "userId",target = id)
    User requestToUser(Long userId, UpsertUserResponse request);
    UserResponse userResponse(User user);
    default UserListResponse userListToResponse(List<User> users){
        UserListResponse response = new UserListResponse();
        response.setUsers(users.stream().map(this::userResponse).collect(Collectors.toList()));
        return response;
    }

}
