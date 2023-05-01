package com.hufflepuff.generation.italy.BookIn.model.services.abstractions;

import com.hufflepuff.generation.italy.BookIn.model.entities.Book;
import com.hufflepuff.generation.italy.BookIn.model.entities.Genre;
import com.hufflepuff.generation.italy.BookIn.model.entities.GeoLocation;
import com.hufflepuff.generation.italy.BookIn.model.entities.Tag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface AbstractBookService {

    Book saveBookWithGenresTagsLocation(Book b, Set<Genre> genres, Set<Tag> tags, GeoLocation location);

    Iterable<Book> findByTitleContainingAndIsAvailableTrue(String part);

    Iterable<Book> findByAuthorContainingAndIsAvailableTrue(String partName);

    Iterable<Book> findByGenresAndIsAvailableTrue(Genre genre);

    Iterable<Book> findByTagsAndIsAvailableTrue(Tag tag);

    Iterable<Book> findByPublisherContainingAndIsAvailableTrue(String pubPartName);

    Optional<Book> findByISBNAndIsAvailableTrue(String isbn);

    Iterable<Book> findByYearBetweenAndIsAvailableTrue(LocalDate startDate, LocalDate endDate);

    Iterable<Book> findByLanguageAndIsAvailableTrue(String language);

    Iterable<Book> findByIsShippableAndIsAvailableTrue(boolean isShippable);

    Iterable<Book> findByGeoLocationCityAndIsAvailableTrue(String cityname);

    Iterable<Book> findByGeoLocationCoordinatesAndIsAvailableTrue(double latitude, double longitude);

}
