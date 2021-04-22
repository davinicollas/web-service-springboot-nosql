package com.example.wssbd.Resource.exception;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.wssbd.Services.Exception.ObjectNotFound;
@ControllerAdvice
public class ResourceExpition implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ExceptionHandler(ObjectNotFound.class)
	public ResponseEntity<StanderdError> objectNotFound(ObjectNotFound e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StanderdError er = new StanderdError(System.currentTimeMillis(), status.value(), "Não encotrado",
				e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(er);
	}

}
