package PasswordManager.Mappers;

import PasswordManager.Models.MainModels.Source;
import PasswordManager.Models.UpsertSourceRequest;
import PasswordManager.Service.UserService;

public abstract class SourceMapperDelegate implements SourceMapper{
    private UserService dataUserService;
    @Override
    public Source requestToSource(UpsertSourceRequest request) {
        Source source = new Source();
        source.setName(request.getName());
        source.setUser(dataUserService.findById(request.getUserId()));
        return source;
    }
    @Override
    public Source requestToSource(Long sourceId, UpsertSourceRequest request) {
        Source source = requestToSource(request);
        source.setId(sourceId);
        return source;
    }
}
