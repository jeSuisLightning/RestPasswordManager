package PasswordManager.Models.MainModels;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name = "User")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ToString.Include
    private String userName;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Source> sourceList = new ArrayList<>();
    @Transactional
    public void addSource(Source source){
        sourceList.add(source);
    }
    @Transactional
    public void removeSource(Long sourceId){
        sourceList = sourceList.stream().filter(o -> !o.getId().equals(sourceId)).collect(Collectors.toList());
    }
//    public Source removeSourceByName(String sourceName,Source source){
//        Source source1 = sourceList.get()
//        if (sourceName==null){
//            throw new EntityNotFoundException(MessageFormat.format("Ресурс с данным именем не найден",sourceName));
//        }
//        sourceList.remove(sourceName);
//
//    }


}
