package com.hufflepuff.generation.italy.BookIn.model.services.implementations;

import com.hufflepuff.generation.italy.BookIn.model.data.abstractions.*;
import com.hufflepuff.generation.italy.BookIn.model.entities.Book;
import com.hufflepuff.generation.italy.BookIn.model.entities.Genre;
import com.hufflepuff.generation.italy.BookIn.model.entities.GeoLocation;
import com.hufflepuff.generation.italy.BookIn.model.entities.Tag;
import com.hufflepuff.generation.italy.BookIn.model.services.abstractions.AbstractBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

@Service
public class BookService implements AbstractBookService {

    private AbstractBookRepository bookRepo;
    private GenericRepository<Genre> genreRepo;
    private GenericRepository<Tag> tagRepo;
    private GenericRepository<GeoLocation> locationRepo;

    @Autowired
    public BookService(AbstractBookRepository bookRepo, GenreRepository genreRepo, TagRepository tagRepo, GeoLocationRepository locationRepo) {
        this.bookRepo = bookRepo;
        this.genreRepo = genreRepo;
        this.tagRepo = tagRepo;
        this.locationRepo = locationRepo;
    }

    @Override
    public Book saveBookWithGenresTagsLocation(Book b, Set<Genre> genres, Set<Tag> tags, GeoLocation location) {
        for (Genre g : genres) genreRepo.save(g);
        for (Tag t : tags) tagRepo.save(t);
        locationRepo.save(location);
        b.setGenres(genres);
        b.setTags(tags);
        b.setLocation(location);
        bookRepo.save(b);
        return b;
    }

    @Override
    public Iterable<Book> findByTitleContainingAndIsAvailableTrue(String part) {
        return bookRepo.findByTitleContainingAndIsAvailableTrue(part);
    }

    @Override
    public Iterable<Book> findByAuthorContainingAndIsAvailableTrue(String partName) {
        return bookRepo.findByAuthorContainingAndIsAvailableTrue(partName);
    }

    @Override
    public Iterable<Book> findByGenresAndIsAvailableTrue(Genre genre) {
        return bookRepo.findByGenresAndIsAvailableTrue(genre);
    }

    @Override
    public Iterable<Book> findByTagsAndIsAvailableTrue(Tag tag) {
        return bookRepo.findByTagsAndIsAvailableTrue(tag);
    }

    @Override
    public Iterable<Book> findByPublisherContainingAndIsAvailableTrue(String pubPartName) {
        return bookRepo.findByPublisherContainingAndIsAvailableTrue(pubPartName);
    }

    @Override
    public Optional<Book> findByISBNAndIsAvailableTrue(String isbn) {
        return bookRepo.findByISBNAndIsAvailableTrue(isbn);
    }

    @Override
    public Iterable<Book> findByYearBetweenAndIsAvailableTrue(LocalDate startDate, LocalDate endDate) {
        return bookRepo.findByYearBetweenAndIsAvailableTrue(startDate, endDate);
    }

    @Override
    public Iterable<Book> findByLanguageAndIsAvailableTrue(String language) {
        return bookRepo.findByLanguageAndIsAvailableTrue(language);
    }

    @Override
    public Iterable<Book> findByIsShippableAndIsAvailableTrue(boolean isShippable) {
        return bookRepo.findByIsShippableAndIsAvailableTrue(isShippable);
    }

    @Override
    public Iterable<Book> findByGeoLocationCityAndIsAvailableTrue(String cityname) {
        return findByGeoLocationCityAndIsAvailableTrue(cityname);
    }

    @Override
    public Iterable<Book> findByGeoLocationCoordinatesAndIsAvailableTrue(double latitude, double longitude) {
        return null;
    }

    /*@Override
    public Iterable<Book> findBookByNamedParamsAndIsAvailableTrue(String title, String author, Genre genre, Tag tag,
                                                String publisher, String isbn, LocalDate startDate, LocalDate endDate,
                                                String language, boolean isShippable, String cityname) {
        return repo.findBookByNamedParamsAndIsAvailableTrue(title, author, genre, tag, publisher, isbn, startDate,
                endDate, language, isShippable, cityname);
    }*/

}
