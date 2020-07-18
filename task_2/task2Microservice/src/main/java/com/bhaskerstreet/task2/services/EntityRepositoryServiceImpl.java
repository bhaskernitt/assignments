package com.bhaskerstreet.task2.services;

import com.bhaskerstreet.task2.entities.DatabaseEntity;
import com.bhaskerstreet.task2.entities.NameSubClassEntity;
import com.bhaskerstreet.task2.repositories.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntityRepositoryServiceImpl implements EntityRepositoryService {

    private final EntityRepository entityRepository;

    @Autowired
    public EntityRepositoryServiceImpl(EntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    @Override
    public DatabaseEntity findById(Integer id) {
        return entityRepository.findById(id).orElse(null);
    }

    @Override
    public List<NameSubClassEntity> findClassAndSubClass() {
        return entityRepository.findClassAndSubClass();
    }

    @Override
    public List<DatabaseEntity> saveEntities(List<DatabaseEntity> entities) {
        return entityRepository.saveAll(entities);
    }

    @Override
    public void deleteAll() {
        entityRepository.deleteAll();
    }
}
