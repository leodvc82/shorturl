package br.com.shorturl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.shorturl.model.ShortUrlRegister;

public interface ShortUrlRegisterRepository extends JpaRepository<ShortUrlRegister, Long> {

}
