package br.com.shorturl.services.exceptions;

public class ShortUrlErroCreateUrlModifiedException extends RuntimeException {
	
	private static final long serialVersionUID = -3671786555903728303L;

	public ShortUrlErroCreateUrlModifiedException(String mensagem) {
		super(mensagem);
	}
	
	public ShortUrlErroCreateUrlModifiedException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	} 

}
