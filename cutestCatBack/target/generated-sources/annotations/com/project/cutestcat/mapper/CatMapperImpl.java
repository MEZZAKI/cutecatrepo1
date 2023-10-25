package com.project.cutestcat.mapper;

import com.project.cutestcat.dto.CatDto;
import com.project.cutestcat.entity.Cat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-24T19:02:47+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class CatMapperImpl implements CatMapper {

    @Override
    public CatDto toDto(Cat cat) {
        if ( cat == null ) {
            return null;
        }

        Long id = null;
        String url = null;
        Integer score = null;

        id = cat.getId();
        url = cat.getUrl();
        score = cat.getScore();

        CatDto catDto = new CatDto( id, url, score );

        return catDto;
    }

    @Override
    public List<CatDto> toDto(Iterable<Cat> cats) {
        if ( cats == null ) {
            return null;
        }

        List<CatDto> list = new ArrayList<CatDto>();
        for ( Cat cat : cats ) {
            list.add( toDto( cat ) );
        }

        return list;
    }

    @Override
    public Cat toEntity(CatDto cat) {
        if ( cat == null ) {
            return null;
        }

        Cat cat1 = new Cat();

        cat1.setId( cat.id() );
        cat1.setUrl( cat.url() );
        cat1.setScore( cat.score() );

        return cat1;
    }

    @Override
    public List<Cat> toEntity(Iterable<CatDto> cats) {
        if ( cats == null ) {
            return null;
        }

        List<Cat> list = new ArrayList<Cat>();
        for ( CatDto catDto : cats ) {
            list.add( toEntity( catDto ) );
        }

        return list;
    }
}
