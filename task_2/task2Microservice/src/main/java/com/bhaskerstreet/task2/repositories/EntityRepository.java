package com.bhaskerstreet.task2.repositories;

import com.bhaskerstreet.task2.entities.DatabaseEntity;
import com.bhaskerstreet.task2.entities.NameSubClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntityRepository extends JpaRepository<DatabaseEntity, Integer> {


    @Query(value = "SELECT new com.bhaskerstreet.task2.entities.NameSubClassEntity(b.name,a.name,a.id)  from DatabaseEntity a inner join DatabaseEntity b on a.id=b.parentId")
    List<NameSubClassEntity> findClassAndSubClass();


}
