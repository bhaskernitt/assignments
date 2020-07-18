package com.bhaskerstreet.task2.services;

import com.bhaskerstreet.task2.dtos.Response;
import com.bhaskerstreet.task2.entities.NameSubClassEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NestedResponseGeneratorServiceImpl implements NestedResponseGeneratorService {

    private final EntityRepositoryService entityRepositoryService;

    @Autowired
    public NestedResponseGeneratorServiceImpl(EntityRepositoryService entityRepositoryService) {
        this.entityRepositoryService = entityRepositoryService;
    }

    private static String isSubClassExistAsAKey(List<NameSubClassEntity> nameSubClassRecords, String name, String subName) {


        for (NameSubClassEntity nameSubClassEntity : nameSubClassRecords) {
            if (nameSubClassEntity.getName().equals(subName)) {
                nameSubClassEntity.setToBeIgnored(true);
                return nameSubClassEntity.getSubclasses();
            }
        }

        return null;
    }

    private void addNormalNode(List<Response> responseList, String name, String subClass) {

        responseList.add(createNormalNode(name, subClass));
    }

    private Response createNormalNode(String name, String subClass) {

        Response subclass = new Response(subClass);

        List<Response> ll = new ArrayList<>();
        ll.add(subclass);
        return new Response(name, ll);

    }

    private Response createNormalNode(String name, Response nestedChildResponse) {

        Response response = new Response(name);
        List<Response> nestedChildList = new ArrayList<>();
        nestedChildList.add(nestedChildResponse);

        response.setSubClasses(nestedChildList);
        return response;


    }

    private void addSubClassIfNodePresent(List<Response> responseList, String name, String subClass) {

        List<Response> lo = null;
        for (Response response : responseList) {
            if (name.equals(response.getName())) {
                lo = response.getSubClasses();
            }
        }
        Response name2 = new Response(subClass);
        lo.add(name2);
    }

    @Override
    public List<Response> generateNestedJson() {
        List<NameSubClassEntity> nameSubClassRecords = entityRepositoryService.findClassAndSubClass();

        List<Response> nestedJson = new ArrayList<>();
        Map<String, Boolean> isAddedMapNew = new HashMap<>();

        for (NameSubClassEntity nameSubClassEntity : nameSubClassRecords) {
            String subclasses = nameSubClassEntity.getSubclasses();
            String name = nameSubClassEntity.getName();
            if (nameSubClassEntity.isToBeIgnored()) {
                continue;
            }

            String subClass;
            if ((subClass = isSubClassExistAsAKey(nameSubClassRecords, name, subclasses)) != null) {
                isAddedMapNew.put(name, true);
                List<Response> lo = null;
                for (Response response : nestedJson) {

                    if (name.equals(response.getName())) {
                        lo = response.getSubClasses();
                    }
                }
                if (lo == null) {
                    Response nestedResponse = createNormalNode(subclasses, subClass);
                    nestedJson.add(createNormalNode(name, nestedResponse));
                } else {
                    addSubClassIfNodePresent(nestedJson, name, subclasses);
                }

            } else {
                if (isAddedMapNew.containsKey(name)) {
                    addSubClassIfNodePresent(nestedJson, name, subclasses);
                } else {
                    addNormalNode(nestedJson, name, subclasses);
                    isAddedMapNew.put(name, true);
                }
            }

        }
        return nestedJson;
    }
}
