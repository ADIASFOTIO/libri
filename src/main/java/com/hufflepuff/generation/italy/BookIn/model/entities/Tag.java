package com.hufflepuff.generation.italy.BookIn.model.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tag")
public class Tag {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   @SequenceGenerator(name = "tag_generator", allocationSize = 1)
   private long id;
   private String name;
   private String description;
   @ManyToMany(mappedBy = "tags", fetch = FetchType.EAGER)
   private Set<Book> tagBooks;
}
