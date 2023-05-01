package com.hufflepuff.generation.italy.BookIn.dtos;

import com.hufflepuff.generation.italy.BookIn.model.entities.Genre;
import com.hufflepuff.generation.italy.BookIn.model.entities.Tag;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TagDto {
    private long id;
    private String name;
    private String description;

    public TagDto(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public static TagDto fromEntity(Tag tag) {
        return new TagDto(tag.getId(), tag.getName(), tag.getDescription());
    }

    public static List<TagDto> fromEntityList(List<Tag> tagList) {
        ArrayList<TagDto> result = new ArrayList<>();
        for (Tag t : tagList) {
            result.add(fromEntity(t));
        }
        return result;
    }

    public Tag toEntity() {
        return new Tag(this.getId(), this.getName(),
                this.getDescription(),
                null);
    } //si può aggiungere già qui una lista di libri?

    public static Set<Tag> fromDtoList(Set<TagDto> tagDtos) {
        HashSet<Tag> result = new HashSet<>();
        for (TagDto t : tagDtos) {
            result.add(t.toEntity());
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

    public String getDescription() {
        return this.description == null || this.description.length() == 0 ? "" : this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
