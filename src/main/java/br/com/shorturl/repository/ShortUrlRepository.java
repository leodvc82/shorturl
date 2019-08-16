package br.com.shorturl.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.shorturl.model.ShortUrl;

public interface ShortUrlRepository extends JpaRepository< ShortUrl, Long> {

	Optional<ShortUrl> findByUrlOriginal(String urlOriginal);
	Optional<ShortUrl> findByUrlModified(String urlModified);

}
