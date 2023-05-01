package com.hufflepuff.generation.italy.BookIn.model.data.abstractions;

import com.hufflepuff.generation.italy.BookIn.model.entities.Book;
import com.hufflepuff.generation.italy.BookIn.model.entities.Genre;
import com.hufflepuff.generation.italy.BookIn.model.entities.Tag;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;

public interface AbstractBookRepository extends GenericRepository<Book> {

    Iterable<Book> findByTitleContainingAndIsAvailableTrue(String part);
    Iterable<Book> findByAuthorContainingAndIsAvailableTrue(String partname);
    Iterable<Book> findByGenresAndIsAvailableTrue(Genre genre);
    Iterable<Book> findByTagsAndIsAvailableTrue(Tag tag);
    Iterable<Book> findByPublisherContainingAndIsAvailableTrue(String pubpartname);
    Optional<Book> findByISBNAndIsAvailableTrue(String isbn);
    Iterable<Book> findByYearBetweenAndIsAvailableTrue(LocalDate startDate, LocalDate endDate);
    Iterable<Book> findByLanguageAndIsAvailableTrue (String language);
    Iterable<Book> findByIsShippableAndIsAvailableTrue (boolean isShippable);
    @Query("SELECT b from Book b WHERE b.location.city = :cityname")
    Iterable<Book> findByGeoLocationCityAndIsAvailableTrue (String cityname);
}
