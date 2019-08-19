package br.com.shorturl.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.shorturl.model.ShortUrl;
import br.com.shorturl.model.ShortUrlRegister;
import br.com.shorturl.repository.ShortUrlRepository;
import br.com.shorturl.services.exceptions.ShortUrlErroCreateUrlModifiedException;
import br.com.shorturl.services.exceptions.ShortUrlInvalidException;
import br.com.shorturl.services.exceptions.ShortUrlNotFoundException;
import br.com.shorturl.util.URLValidator;
import br.com.shorturl.util.Util;

@Service
public class ShortUrlServices {
	
	@Autowired
	private ShortUrlRepository shortUrlRepository;
	
	public List<ShortUrl> listar(){
		return shortUrlRepository.findAll();
	}
	
	public ShortUrl create(ShortUrl shortUrl) {
		
		if (URLValidator.urlValidator(shortUrl.getUrlOriginal())==false) {
			throw new ShortUrlInvalidException("Url inválida, ex. http://google.com.br ou https://google.com.br");
		}
		
		try {
			shortUrl.setCounter(0);
			shortUrl.setDtRegister(new Date());
			shortUrl.setUrlModified(Util.gerarUrlModified(shortUrl.getUrlOriginal()));
			return shortUrlRepository.save(shortUrl);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ShortUrlErroCreateUrlModifiedException("Não foi possível criar a url");
		}
		
	}
	
	public ShortUrl findByUrlOriginal(String urlOriginal) {
		Optional<ShortUrl> op = shortUrlRepository.findByUrlOriginal(urlOriginal);
		if(op.isPresent()) {
			return op.get();
		}
		throw new ShortUrlNotFoundException("A url não foi encotrada!");
	}
	
	public ShortUrl findUrlModified(String urlModified) {
		Optional<ShortUrl> op = shortUrlRepository.findByUrlModified(urlModified);
		if(op.isPresent()) {
			return op.get();
		}
		throw new ShortUrlNotFoundException("A url não foi encotrada!");
	}
	
	public String openUrl(String url) {
		ShortUrl shortUrl = findUrlModified(url);
		shortUrl.setCounter(shortUrl.getCounter() + 1);
		shortUrl.getRegisters().add(new ShortUrlRegister(shortUrl, new Date()));
		
		shortUrlRepository.save(shortUrl);
		
		return shortUrl.getUrlOriginal();
	}
	
}
