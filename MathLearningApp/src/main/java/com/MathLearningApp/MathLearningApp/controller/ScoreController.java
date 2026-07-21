package com.MathLearningApp.MathLearningApp.controller;

import com.MathLearningApp.MathLearningApp.dto.ScoreDTO;
import com.MathLearningApp.MathLearningApp.service.ScoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/scores")
@RequiredArgsConstructor
public class ScoreController {
    private final ScoreService scoreService;

    @PostMapping
    public ResponseEntity<ScoreDTO>save(@Valid @RequestBody ScoreDTO dto){
        return ResponseEntity.ok(scoreService.save(dto));
    }

    public List<ScoreDTO> getAll(){
        return scoreService.getAll();
    }


}
