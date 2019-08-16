package br.com.shorturl.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.servlet.view.RedirectView;

import br.com.shorturl.model.ShortUrl;
import br.com.shorturl.services.ShortUrlServices;

@CrossOrigin
@RestController
@RequestMapping("/shorturl")
public class ShortUrlResources {
	
	@Autowired
	private ShortUrlServices shortUrlService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ShortUrl>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(shortUrlService.listar());
	}
	
	@RequestMapping(method =  RequestMethod.POST)
	public ResponseEntity<Void> gerarShortUrl(@Valid @RequestBody ShortUrl shortUrl) {
		shortUrl = shortUrlService.salvar(shortUrl);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{urlModified}").buildAndExpand(shortUrl.getUrlModified()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{url}/statistic", method = RequestMethod.GET)
	public ResponseEntity<ShortUrl> adicionarComentario(@PathVariable("url") String url) {
		ShortUrl shortUrl = shortUrlService.findUrlModified(url);
		return ResponseEntity.status(HttpStatus.OK).body(shortUrl);
	}
	
	@RequestMapping(value = "/{url}", method = RequestMethod.GET)
	public ModelAndView openUrl(@PathVariable("url") String url){
		String redirect = shortUrlService.openUrl(url);
		return new ModelAndView(new RedirectView(redirect));
	}
	
}
