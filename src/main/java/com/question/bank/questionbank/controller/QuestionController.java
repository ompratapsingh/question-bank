package com.question.bank.questionbank.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.question.bank.questionbank.exception.ResourceNotFoundException;
import com.question.bank.questionbank.model.Question;
import com.question.bank.questionbank.repository.QuestionRepository;

@RestController
public class QuestionController {

	@Autowired
	private QuestionRepository questionRepository;

	@GetMapping("/questions")
	public Page<Question> getQuestions(Pageable pageable) {
		return questionRepository.findAll(pageable);
	}

	@PostMapping(path = "/questions", consumes = "application/json")
	public Question createQuestion(@Valid @RequestBody Question question) {
		return questionRepository.save(question);
	}

	@PutMapping(path = "/questions/{questionId}", consumes = "application/json")
	public Question updateQuestion(@PathVariable Long questionId, @Valid @RequestBody Question questionRequest) {
		return questionRepository.findById(questionId).map(question -> {
			question.setTitle(questionRequest.getTitle());
			question.setDescription(questionRequest.getDescription());
			return questionRepository.save(question);
		}).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
	}

	@DeleteMapping(path = "/questions/{questionId}", consumes = "application/json")
	public ResponseEntity<?> deleteQuestion(@PathVariable Long questionId) {
		return questionRepository.findById(questionId).map(question -> {
			questionRepository.delete(question);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
	}
}
