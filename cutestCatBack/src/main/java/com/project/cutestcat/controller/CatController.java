package com.project.cutestcat.controller;
import com.project.cutestcat.mapper.CatMapper;
import com.project.cutestcat.service.CatService;
import com.project.cutestcat.service.CatServiceImpl;
import com.project.cutestcat.dto.CatDto;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cats")
@CrossOrigin(origins = "*")
public class CatController {

    final private CatService catService;
    @Autowired
    CatController(CatServiceImpl catService){
        this.catService =catService;
    }
    final private CatMapper catMapper=Mappers.getMapper(CatMapper.class);

    @RequestMapping(value="/getAll", method= RequestMethod.GET,produces="application/json")
    public ResponseEntity<List<CatDto>>  getAll(){
        return ResponseEntity.ok(catMapper.toDto(catService.getAll()));
    }

    @RequestMapping(value="/resetScoreAllCats", method= RequestMethod.GET,produces="application/json")
    public ResponseEntity<List<CatDto>>  resetScoreAllCats(){
        return ResponseEntity.ok(catMapper.toDto(catService.resetScoreAllCats()));
    }

    @RequestMapping(value="/saveAll", method= RequestMethod.POST,produces="application/json")
    public ResponseEntity<List<CatDto>>  saveAll(@RequestBody List<CatDto> cats){
        return ResponseEntity.ok(catMapper.toDto(catService.saveAll(catMapper.toEntity(cats))));
    }

}
