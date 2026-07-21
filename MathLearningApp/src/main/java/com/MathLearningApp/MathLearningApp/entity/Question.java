package com.MathLearningApp.MathLearningApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "questions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

    @Column(nullable = false)
   private String question;
   private String optionA;
   private String optionB;
   private String optionC;

   @Column(nullable = false)
   private String correctAnswer;

   // Number, Counting , Addition , Subtraction
   @Enumerated(EnumType.STRING)
   @Column(nullable = false)
   private Category category;

   private String image;

   public enum Category{
       NUMBER, COUNTING, ADDITION, SUBTRACTION
   }
}
