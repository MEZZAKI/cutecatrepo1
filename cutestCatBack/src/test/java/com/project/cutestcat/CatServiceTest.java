package com.project.cutestcat;

import com.project.cutestcat.entity.Cat;
import com.project.cutestcat.repository.CatRepository;
import com.project.cutestcat.service.CatService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class CatServiceTest {

    @Autowired
    CatService catService;

    @MockBean
    private CatRepository catRepository;

    @Test
    public void resetScoreAllCatsTest(){
        // We simulate having 3 cats with score=4 in the database
        List<Cat> cats = Arrays.asList(new Cat(), new Cat(), new Cat());
        cats.forEach(cat -> cat.setScore(4));
        Mockito.when(catRepository.findAll())
                .thenReturn(cats);
        Mockito.when(catRepository.saveAll(cats))
                .thenReturn(cats);
        // the method should make all cats score = 0
        List<Cat> returnedCats = catService.resetScoreAllCats();
        Assertions.assertNotNull(returnedCats);
        Assertions.assertFalse(returnedCats.isEmpty());
        for(Cat cat:returnedCats){
            Assertions.assertEquals(0,cat.getScore());
        }
    }
}
