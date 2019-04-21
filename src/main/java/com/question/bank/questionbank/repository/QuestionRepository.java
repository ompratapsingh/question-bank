package com.question.bank.questionbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.question.bank.questionbank.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
