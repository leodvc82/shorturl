package br.com.shorturl.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.shorturl.handler.modelo.DetailsError;
import br.com.shorturl.services.exceptions.ShortUrlErroCreateUrlModifiedException;
import br.com.shorturl.services.exceptions.ShortUrlInvalidException;
import br.com.shorturl.services.exceptions.ShortUrlNotFoundException;

@ControllerAdvice
public class ResourcesExceptionHandler {
	
	
	@ExceptionHandler(ShortUrlNotFoundException.class)
	public ResponseEntity<DetailsError> handleShortUrlNotFoundException(ShortUrlNotFoundException e, HttpServletRequest request){
		
		DetailsError erro = new DetailsError();
		erro.setStatus(404l);
		erro.setTitle("A ShortUrl não foi encontrada!");
		erro.setMessage("http://erros.shorturl.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		
	}
	
	@ExceptionHandler(ShortUrlErroCreateUrlModifiedException.class)
	public ResponseEntity<DetailsError> handleShortUrlErroCreateUrlModifiedException(ShortUrlErroCreateUrlModifiedException e, HttpServletRequest request){
		
		DetailsError erro = new DetailsError();
		erro.setStatus(409l);
		erro.setTitle(e.getMessage());
		erro.setMessage("http://erros.shorturl.com/409");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
		
	}
	
	@ExceptionHandler(ShortUrlInvalidException.class)
	public ResponseEntity<DetailsError> handleShortUrlInvalidException(ShortUrlInvalidException e, HttpServletRequest request){
		
		DetailsError erro = new DetailsError();
		erro.setStatus(409l);
		erro.setTitle(e.getMessage());
		erro.setMessage("http://erros.shorturl.com/409");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
		
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<DetailsError> handleDataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request){
		
		DetailsError erro = new DetailsError();
		erro.setStatus(400l);
		erro.setTitle(e.getMessage());
		erro.setMessage("http://erros.shorturl.com/400");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
		
	}

}
