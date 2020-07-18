package com.bhaskerstreet.task2.services;

import com.bhaskerstreet.task2.entities.DatabaseEntity;
import com.bhaskerstreet.task2.entities.NameSubClassEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EntityRepositoryService {

    DatabaseEntity findById(Integer id);

    List<NameSubClassEntity> findClassAndSubClass();

    List<DatabaseEntity> saveEntities(List<DatabaseEntity> entities);

    void deleteAll();


}
