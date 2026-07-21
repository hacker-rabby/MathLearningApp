package com.MathLearningApp.MathLearningApp.repository;

import com.MathLearningApp.MathLearningApp.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score,Long> {
}
