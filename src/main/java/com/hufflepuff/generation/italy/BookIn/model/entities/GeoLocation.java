package com.hufflepuff.generation.italy.BookIn.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "geolocation")
public class GeoLocation {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   @SequenceGenerator(name = "geolocation_generator", allocationSize = 1)
   private long id;
   private String city;
   private double latitude;
   private double longitude;
   @OneToOne(mappedBy = "location")
   private Book book;
}
