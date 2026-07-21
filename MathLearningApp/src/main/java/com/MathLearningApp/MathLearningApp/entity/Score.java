package com.MathLearningApp.MathLearningApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "score")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String studentName;
    @Column(nullable = false)
    private Integer score;
    @Column(nullable = false)
    private Integer totalQuestion;
    @Column(nullable = false)
    private LocalDateTime playedDate = LocalDateTime.now();
}
