package com.bhaskerstreet.task2;

import com.bhaskerstreet.task2.entities.DatabaseEntity;
import com.bhaskerstreet.task2.loader.fileLoader.FileLoader;
import com.bhaskerstreet.task2.services.EntityRepositoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(scanBasePackages = "com.bhaskerstreet.task2.**")
@EnableWebMvc
public class Task2Application implements ApplicationRunner {

    private static final Logger LOGGER = LogManager.getLogger(com.bhaskerstreet.task2.Task2Application.class);
    private final EntityRepositoryService entityRepositoryService;


    @Autowired
    public Task2Application(EntityRepositoryService entityRepositoryService) {
        this.entityRepositoryService = entityRepositoryService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Task2Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {

        entityRepositoryService.deleteAll();

        try {
            List<DatabaseEntity> databaseEntities = new ArrayList<>();
            String[] results = new FileLoader("/dbRecords").load().split("\n");
            for (String result : results) {
                String[] columns = result.split(",");
                databaseEntities.add(new DatabaseEntity(columns[0], columns[1], columns[2], columns[3]));
            }

            for (String result : results) {
                String[] columns = result.split(",");
                databaseEntities.add(new DatabaseEntity(columns[0], columns[1], columns[2], columns[3]));
            }
            entityRepositoryService.saveEntities(databaseEntities);

        } catch (Exception e) {
            LOGGER.error("unable to fetch data from file");
        }
    }
}
