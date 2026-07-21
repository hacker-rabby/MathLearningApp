package com.MathLearningApp.MathLearningApp.dto;

import com.MathLearningApp.MathLearningApp.entity.Question;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {
  private Long id;

  @NotBlank(message = "question text is required")
  private String question;

  private String optionA;
  private String optionB;
  private String optionC;

  @NotNull(message = "category is required")
  private Question.Category category;

  @NotBlank(message = "correctAnswer is required")
  private String correctAnswer;
  private String image;

  public static  QuestionDTO fromEntity(Question q){
      return  new QuestionDTO(q.getId(),q.getQuestion(),q.getOptionA(),q.getOptionB(),q.getOptionC(),q.getCategory(),q.getCorrectAnswer(),q.getImage());
  }

  public Question toEntity(){
      Question q = new Question();
      q.setId(this.id);
      q.setQuestion(this.question);
      q.setOptionA(this.optionA);
      q.setOptionB(this.optionB);
      q.setOptionC(this.optionC);
      q.setCategory(this.category);
      q.setCorrectAnswer(this.correctAnswer);
      q.setImage(this.image);
      return q;
  }
}
