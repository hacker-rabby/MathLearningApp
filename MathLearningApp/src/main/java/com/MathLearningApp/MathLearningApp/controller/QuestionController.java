package com.MathLearningApp.MathLearningApp.controller;

import com.MathLearningApp.MathLearningApp.dto.QuestionDTO;
import com.MathLearningApp.MathLearningApp.entity.Question;
import com.MathLearningApp.MathLearningApp.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping
    public List<QuestionDTO> getAll(){
        return questionService.getAll();
    }

    @GetMapping("/{id}")
    public QuestionDTO getById(@PathVariable Long id){
        return questionService.getById(id);
    }

    @GetMapping("/category/{category}")
    public List<QuestionDTO>getCategory(@PathVariable Question.Category category){
        return questionService.getByCategory(category);
    }

    @PostMapping
    public ResponseEntity<QuestionDTO>create(@Valid @RequestBody QuestionDTO dto){
        return ResponseEntity.ok(questionService.create(dto));
    }

    @PutMapping("/{id}")
    public QuestionDTO update(@PathVariable Long id,@Valid @RequestBody QuestionDTO dto){
        return questionService.update(id,dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        questionService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
