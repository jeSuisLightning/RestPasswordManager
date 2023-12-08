package PasswordManager.Mappers;

import PasswordManager.Models.MainModels.Source;
import PasswordManager.Models.SourceListResponse;
import PasswordManager.Models.SourceResponse;
import PasswordManager.Models.UpsertSourceRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel="spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SourceMapper {

    Source requestToSource(UpsertSourceRequest request);
    @Mapping(source = "sourceId",target = id)
    Source requestToSource(Long sourceId,UpsertSourceRequest request);
    List<SourceResponse> sourceListResponse(List<Source> sources);
    SourceResponse sourceResponse(Source source);
    default SourceListResponse sourceListToResponse(List<Source> sources){
        SourceListResponse response = new SourceListResponse();
        response.setSourceListResponse(sourceListResponse(sources));
        return response;
    }

}
