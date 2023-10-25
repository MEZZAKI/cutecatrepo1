package com.project.cutestcat.service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.cutestcat.entity.Cat;
import com.project.cutestcat.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class CatServiceImpl implements CatService{
    final CatRepository catRepository;
    @Autowired
    public CatServiceImpl(CatRepository catRepository) {
        this.catRepository = catRepository;
    }
    public List<Cat> getAll(){
        return catRepository.findAll();
    }
    public List<Cat> saveAll(List<Cat> cats){
        return catRepository.saveAll(cats);
    }
    public List<Cat> resetScoreAllCats(){
        List<Cat> cats = catRepository.findAll();
        //reset score to zero for all cats
        cats.forEach(cat -> cat.setScore(0));
        return catRepository.saveAll(cats);
    }
    // Read cats json file and write it in the DB
    public void initCatsList(){
        InputStream inputStream = TypeReference.class.getResourceAsStream("/cats.json");
        try {
            List<Cat> cats = new ObjectMapper().readValue(inputStream,new TypeReference<>(){});
            catRepository.saveAll(cats);
        } catch ( IOException e){
            System.out.println("Error while init data from json file : " + e.getMessage());
        }
    }
}
