package com.project.cutestcat.mapper;
import com.project.cutestcat.dto.CatDto;
import com.project.cutestcat.entity.Cat;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface CatMapper {
    public CatDto toDto(Cat cat);
    public List<CatDto> toDto(Iterable<Cat> cats);
    public Cat toEntity(CatDto cat);
    public List<Cat> toEntity(Iterable<CatDto> cats);
}