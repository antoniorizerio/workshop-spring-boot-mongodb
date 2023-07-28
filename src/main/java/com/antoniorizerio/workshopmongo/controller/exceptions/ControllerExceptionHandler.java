package com.antoniorizerio.workshopmongo.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.antoniorizerio.workshopmongo.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

// Classe responsável por tratar possíveis erros nas minhas requisições //

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, 
			HttpServletRequest request) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		StandardError standardError = new StandardError(System.currentTimeMillis(), status.value(),
				"Recurso não encontrado", e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(standardError);
	}
}
