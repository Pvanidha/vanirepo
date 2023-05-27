package com.codedecode.microservices.EmployeeCRUDApplication.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.codedecode.microservices.EmployeeCRUDApplication.custom.exception.EmptyInputException;
import com.codedecode.microservices.EmployeeCRUDApplication.custom.exception.ExceptionDetail;
import com.codedecode.microservices.EmployeeCRUDApplication.custom.exception.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException) {
		
		return new ResponseEntity<String>("Input field is empty", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoSuchElementException.class) 
	public ResponseEntity<ExceptionDetail> handleNoSuchElement(NoSuchElementException noSuchElementException) {

		ExceptionDetail exceptionDetail = new ExceptionDetail();
		exceptionDetail.setErrorCode(noSuchElementException.getErrorCode());
		exceptionDetail.setErrorMessage(noSuchElementException.getErrorMessage());
		exceptionDetail.setDetailedMessage("Error Code: " + noSuchElementException.getErrorCode() + " Error Message: "
				+ noSuchElementException.getErrorMessage());

		return new ResponseEntity<ExceptionDetail>(exceptionDetail, HttpStatus.BAD_REQUEST);
	}
}
