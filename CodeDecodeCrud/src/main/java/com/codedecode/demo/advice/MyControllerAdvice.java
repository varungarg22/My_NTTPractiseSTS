package com.codedecode.demo.advice;

import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler{

	// @ExceptionHandler(NoSuchElementException.class)
	// public ResponseEntity<String> handleEmptyInput(NoSuchElementException emptyInputException){
	//	 return null;
	// }
	 
	/*
	 * @ExceptionHandler(.class) public ResponseEntity<String>
	 * handleEmptyInput(NoSuchElementException emptyInputException){ return null; }
	 */
	
}
