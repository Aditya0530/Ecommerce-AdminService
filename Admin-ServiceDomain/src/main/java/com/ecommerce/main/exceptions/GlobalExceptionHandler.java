package com.ecommerce.main.exceptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ecommerce.main.dto.ErrorDto;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(FileNotSavedException.class)
	public ResponseEntity<ErrorDto> handleFileExceptions(FileNotSavedException ex) {
		ErrorDto errDto=new ErrorDto(ex.getMessage());
		return new ResponseEntity<>(errDto, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ImageNotUpdateException.class)
	public ResponseEntity<ErrorDto> EmployeeAndImageNotUpdateException(ImageNotUpdateException ex) {
		ErrorDto errDto=new ErrorDto(ex.getMessage());
		return new ResponseEntity<>(errDto, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDto> handleParentException(Exception ex) {
		ErrorDto errDto=new ErrorDto(ex.getMessage());
		return new ResponseEntity<>(errDto,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	

}
