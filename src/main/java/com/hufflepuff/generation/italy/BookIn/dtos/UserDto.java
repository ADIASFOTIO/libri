package com.hufflepuff.generation.italy.BookIn.dtos;

import com.hufflepuff.generation.italy.BookIn.model.entities.User;
import lombok.*;

@Data
@AllArgsConstructor
public class UserDto {
   private String firstname;
   private String lastname;
   private String email;
   public static UserDto dtoFromEntity(User user){
      return new UserDto(user.getFirstname(), user.getLastname(), user.getEmail());
   }

}
