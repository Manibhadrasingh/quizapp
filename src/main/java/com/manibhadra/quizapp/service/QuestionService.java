package com.manibhadra.quizapp.service;

import com.manibhadra.quizapp.model.Question;
import com.manibhadra.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try
        {
            return  new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }
        catch (Exception e)
        {
         e.printStackTrace();
        }
        return  new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String topic)
    {
        try
        {
            return new ResponseEntity<>(questionDao.findByCategory(topic),HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return  new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> addQuestion(Question question) {
        try
        {
            questionDao.save(question);
            return new ResponseEntity<>("Question added successfully", HttpStatus.OK);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to add question", HttpStatus.BAD_REQUEST);
        }
    }


    public ResponseEntity<String> deleteQuestion(int id) {
        try
        {
            questionDao.deleteById(id);
            return new ResponseEntity<>("Question deleted successfully", HttpStatus.OK);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to delete question", HttpStatus.BAD_REQUEST);
        }
    }


//    public void updateQuestion(int id, Question updatedQuestion) {
//        questionDao.findById(id).ifPresent(question -> {
//            // Update the question attributes
//            question.setCategory(updatedQuestion.getCategory());
//            question.setDifficultyLevel(updatedQuestion.getDifficultyLevel());
//            // Update other attributes as needed
//
//            // Save the updated question back to the database
//            questionDao.save(question);
//        });
//    }

}
