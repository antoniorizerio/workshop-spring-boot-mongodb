package com.antoniorizerio.workshopmongo.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.antoniorizerio.workshopmongo.service.exceptions.BadRequestException;
import com.antoniorizerio.workshopmongo.service.exceptions.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

// Classe responsável por tratar possíveis erros nas minhas requisições //
// Manipulador de Exceções na minha camada de Controller //

@ControllerAdvice
public class ControllerExceptionHandler {

	
	/**
	 * Annotation for handling exceptions in specific handler classes and/or
	 * handler methods.
	 *
	 * <p>Handler methods which are annotated with this annotation are allowed to
	 * have very flexible signatures. They may have parameters of the following
	 * types.
	 * @param e
	 * @param request
	 * @return
	 */
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, 
			HttpServletRequest request) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		StandardError standardError = new StandardError(System.currentTimeMillis(), status.value(),
				"Recurso não encontrado", e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(standardError);
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<StandardError> BadRequest(BadRequestException e, 
			HttpServletRequest request) {
		
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		StandardError standardError = new StandardError(System.currentTimeMillis(), status.value(),
				"Requisição inválida", e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(standardError);
	}
}
