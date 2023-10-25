package com.project.cutestcat.service;
import com.project.cutestcat.entity.Cat;
import java.util.List;
public interface CatService {
    List<Cat> getAll();
    List<Cat> saveAll(List<Cat> cats);
    public void initCatsList();
    List<Cat> resetScoreAllCats();
}
