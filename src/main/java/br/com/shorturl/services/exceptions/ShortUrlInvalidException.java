package br.com.shorturl.services.exceptions;

public class ShortUrlInvalidException extends RuntimeException {
	
	private static final long serialVersionUID = -2264126072867710210L;

	public ShortUrlInvalidException(String mensagem) {
		super(mensagem);
	}
	
	public ShortUrlInvalidException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	} 
}
