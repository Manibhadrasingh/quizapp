package com.manibhadra.quizapp.controller;

import com.manibhadra.quizapp.model.Question;
import com.manibhadra.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions()
    {
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category)
    {
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question)
    {
       return questionService.addQuestion(question);
    }

    @PostMapping("deleteQuestion/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int id) {
        return questionService.deleteQuestion(id);
    }


//    @PutMapping("updateQuestion/{id}")
//    public String updateQuestion(@PathVariable int id, @RequestBody Question updatedQuestion) {
//        questionService.updateQuestion(id, updatedQuestion);
//        return "Update successful";
//    }

}
