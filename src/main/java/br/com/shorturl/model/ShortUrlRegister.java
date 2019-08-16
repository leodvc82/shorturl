package br.com.shorturl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class ShortUrlRegister {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_shorturl_register")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_shorturl")
	@JsonIgnore
	private ShortUrl shortUrl;
	
	@JsonInclude(Include.NON_NULL)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dtRegister;
	
	public ShortUrlRegister() {}
	
	public ShortUrlRegister(ShortUrl shortUrl, Date dtRegister) {
		super();
		this.shortUrl = shortUrl;
		this.dtRegister = dtRegister;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ShortUrl getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(ShortUrl shortUrl) {
		this.shortUrl = shortUrl;
	}

	public Date getDtRegister() {
		return dtRegister;
	}

	public void setDtRegister(Date dtRegister) {
		this.dtRegister = dtRegister;
	}
	
}
