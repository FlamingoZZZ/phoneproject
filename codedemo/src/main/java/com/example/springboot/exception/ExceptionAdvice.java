package com.example.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler{
	
	
	static class ApiError {

		private HttpStatus status;
		   private String message;

		   private ApiError() {
		   }

		   ApiError(HttpStatus status) {
		       this();
		       this.status = status;
		   }

		   ApiError(HttpStatus status, String message) {
		       this();
		       this.status = status;
		       this.message = message;
		   }

		   public HttpStatus getStatus() {
			return status;
		}

		public void setStatus(HttpStatus status) {
			this.status = status;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
		}
	   @ExceptionHandler(InvalidPhoneNumberException.class)
	   public ResponseEntity<Object> handleBadRequestEntity(InvalidPhoneNumberException ex) {
	       ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
	       apiError.setMessage(ex.getMessage());
	       return buildResponseEntity(apiError);
	   }
	
	   private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
	       return new ResponseEntity<>(apiError, apiError.getStatus());
	   }
}
