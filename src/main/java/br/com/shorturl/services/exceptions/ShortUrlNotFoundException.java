package br.com.shorturl.services.exceptions;

public class ShortUrlNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 7500021566267749301L;

	public ShortUrlNotFoundException(String mensagem) {
		super(mensagem);
	}
	
	public ShortUrlNotFoundException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	} 
}
