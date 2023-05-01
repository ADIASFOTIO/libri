package com.hufflepuff.generation.italy.BookIn.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder //genera codice per creare un bookBuilder
@Table(name = "book")
public class Book {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   @SequenceGenerator(name = "book_generator", allocationSize = 1)
   private long id;
   private String title;
   private String ISBN;
   private LocalDate year;
   private String publisher;
   private String language;
   private String author;
   private boolean isShippable;
   private String review;
   private boolean isAvailable;

   @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   @JoinColumn(name = "location_id", referencedColumnName = "id", nullable = true)
   private GeoLocation location;

   @ManyToMany(cascade = CascadeType.PERSIST)
   @JoinTable(
         name = "book_genre",
         joinColumns = @JoinColumn(name = "book_id"),
         inverseJoinColumns = @JoinColumn(name = "genre_id", nullable = true)
   )
   private Set<Genre> genres;

   @ManyToMany(cascade = CascadeType.PERSIST)
   @JoinTable(
         name = "book_tag",
         joinColumns = @JoinColumn(name = "book_id"),
         inverseJoinColumns = @JoinColumn(name = "tag_id", nullable = true)
   )
   private Set<Tag> tags;

   public Book(long id, String title, String ISBN, LocalDate year, String publisher, String language, String author,
               boolean isShippable, String review, boolean isAvailable) {
      this.id = id;
      this.title = title;
      this.ISBN = ISBN;
      this.year = year;
      this.publisher = publisher;
      this.language = language;
      this.author = author;
      this.isShippable = isShippable;
      this.review = review;
      this.isAvailable = isAvailable;
   }
}
