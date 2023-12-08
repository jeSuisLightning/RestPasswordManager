package PasswordManager.Controllers;

import PasswordManager.Mappers.SourceMapper;
import PasswordManager.Mappers.UserMapper;
import PasswordManager.Models.MainModels.Source;
import PasswordManager.Models.SourceListResponse;
import PasswordManager.Models.SourceResponse;
import PasswordManager.Models.UpsertSourceRequest;
import PasswordManager.Service.SourceService;
import PasswordManager.Service.implementation.SourceServiceImpl;
import PasswordManager.Service.implementation.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.aot.AotServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/source/")
@RequiredArgsConstructor
public class SourceController {
    private final SourceService sourceService;
    private  SourceMapper sourceMapper;
    @GetMapping
    public ResponseEntity<SourceListResponse> showAll(){
        return ResponseEntity.ok(sourceMapper.sourceListToResponse(sourceService.findAll()));
    }
    @GetMapping("{id}")
    public ResponseEntity<SourceResponse> showById(@PathVariable("id")Long sourceId){
        return ResponseEntity.ok(sourceMapper.sourceResponse(sourceService.findById(sourceId)));
    }
    @PostMapping
    public ResponseEntity<SourceResponse> create(@RequestBody UpsertSourceRequest request){
        Source newSource = sourceService.create(sourceMapper.requestToSource(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(sourceMapper.sourceResponse(newSource));
    }
    @PutMapping("{id}")
    public ResponseEntity<SourceResponse> update(@PathVariable("id")Long id,UpsertSourceRequest request){
        Source exictedSource = sourceService.update(sourceMapper.requestToSource(id,request));
        return ResponseEntity.ok(sourceMapper.sourceResponse(exictedSource));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        sourceService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
