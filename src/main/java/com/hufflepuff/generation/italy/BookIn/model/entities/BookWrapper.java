package com.hufflepuff.generation.italy.BookIn.model.entities;

import com.hufflepuff.generation.italy.BookIn.dtos.BookDto;
import com.hufflepuff.generation.italy.BookIn.dtos.GenreDto;
import com.hufflepuff.generation.italy.BookIn.dtos.TagDto;

import java.util.List;
import java.util.Set;

public class BookWrapper {
    private BookDto bookDto;
    private Set<GenreDto> genresDto;
    private Set<TagDto> tagsDto;
    GeoLocation location;

    public BookDto getBookDto() {
        return bookDto;
    }

    public Set<GenreDto> getGenresDto() {
        return genresDto;
    }

    public Set<TagDto> getTagsDto() {
        return tagsDto;
    }

    public GeoLocation getLocation() {
        return location;
    }
}
