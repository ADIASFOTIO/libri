package com.hufflepuff.generation.italy.BookIn.dtos;

import com.hufflepuff.generation.italy.BookIn.model.entities.Book;
import com.hufflepuff.generation.italy.BookIn.model.entities.Genre;
import com.hufflepuff.generation.italy.BookIn.model.entities.Tag;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenreDto {
    private long id;
    private String name;

    public GenreDto(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static GenreDto fromEntity(Genre g) {
        return new GenreDto(g.getId(), g.getName());
    }

    public static List<GenreDto> fromEntityList(List<Genre> genreList) {
        ArrayList<GenreDto> result = new ArrayList<>();
        for (Genre g : genreList) {
            result.add(fromEntity(g));
        }
        return result;
    }

    public Genre toEntity() {
        return new Genre(this.getId(), this.getName(), null);
    } //si può aggiungere già qui una lista di libri?

    public static Set<Genre> fromDtoList(Set<GenreDto> genreDtos) {
        HashSet<Genre> result = new HashSet<>();
        for (GenreDto g : genreDtos) {
            result.add(g.toEntity());
        }
        return result;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
