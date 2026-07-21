package com.MathLearningApp.MathLearningApp.service;

import com.MathLearningApp.MathLearningApp.dto.ScoreDTO;
import com.MathLearningApp.MathLearningApp.entity.Score;
import com.MathLearningApp.MathLearningApp.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScoreService {
    public final ScoreRepository scoreRepository;

    public ScoreDTO save(ScoreDTO dto){
        Score score = new Score();
        score.setStudentName(dto.getStudentName());
        score.setScore(dto.getScore());
        score.setTotalQuestion(dto.getTotalQuestion());
        score.setPlayedDate(LocalDateTime.now());
        Score saved = scoreRepository.save(score);
        return toDto(saved);
    }

    public List<ScoreDTO>getAll(){
        return scoreRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private ScoreDTO toDto(Score s){
        return new ScoreDTO(s.getId(),s.getStudentName(),s.getScore(),s.getTotalQuestion());
    }
}
