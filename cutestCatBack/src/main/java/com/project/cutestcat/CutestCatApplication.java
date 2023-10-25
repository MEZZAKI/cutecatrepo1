package com.project.cutestcat;

import com.project.cutestcat.service.CatService;
import com.project.cutestcat.service.CatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class CutestCatApplication {
	final private CatService catService;
	@Autowired
	CutestCatApplication(CatServiceImpl catService){
		this.catService =catService;
	}

	public static void main(String[] args) {
		SpringApplication.run(CutestCatApplication.class, args);
	}
	// After application startup init cats list
	@EventListener(ApplicationReadyEvent.class)
	public void initCatsList() {
		catService.initCatsList();
	}
}