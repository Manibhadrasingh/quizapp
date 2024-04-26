package com.manibhadra.quizapp.dao;

import com.manibhadra.quizapp.model.Quiz;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz,Integer> {
}
