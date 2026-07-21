package com.MathLearningApp.MathLearningApp.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScoreDTO {
    private Long id;

    @NotBlank(message = "studentName is required")
    private String studentName;

    @NotNull
    @Min(0)
    private Integer score;

    @NotNull
    @Min(1)
    private Integer totalQuestion;
}
