package com.MathLearningApp.MathLearningApp.service;

import com.MathLearningApp.MathLearningApp.dto.QuestionDTO;
import com.MathLearningApp.MathLearningApp.entity.Question;
import com.MathLearningApp.MathLearningApp.exception.ResourceNotFoundException;
import com.MathLearningApp.MathLearningApp.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private  final  QuestionRepository questionRepository;

    public List<QuestionDTO>getAll(){
       return questionRepository.findAll().stream()
               .map(QuestionDTO::fromEntity)
               .collect(Collectors.toList());
    }

    public QuestionDTO getById(Long id){
        Question q = questionRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Question not found with id = "+id));
                return QuestionDTO.fromEntity(q);
    }

    public List<QuestionDTO>getByCategory(Question.Category category){
        return questionRepository.findByCategory(category).stream()
                .map(QuestionDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public QuestionDTO create(QuestionDTO dto){
        Question saved = questionRepository.save(dto.toEntity());
        return QuestionDTO.fromEntity(saved);
    }

    public QuestionDTO update(Long id,QuestionDTO dto){
        Question existing = questionRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Question not found with id"+id));
        existing.setQuestion(dto.getQuestion());
        existing.setOptionA(dto.getOptionA());
        existing.setOptionB(dto.getOptionB());
        existing.setOptionC(dto.getOptionC());
        existing.setCorrectAnswer(dto.getCorrectAnswer());
        existing.setCategory(dto.getCategory());
        existing.setImage(dto.getImage());
        return QuestionDTO.fromEntity(questionRepository.save(existing));
    }

    public void delete(Long id){
        if(!questionRepository.existsById(id)){
            throw new ResourceNotFoundException("Question not found with id"+id);
        }
        questionRepository.deleteById(id);
    }

}

