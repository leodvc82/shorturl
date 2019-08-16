package br.com.shorturl.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class ShortUrl {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_shorturl")
	private Long id;
	
	@NotNull(message = "O campo url é obrigatório.")
	@Column(length = 200, updatable = false)
	private String urlOriginal;
	
	@Column(length = 200, updatable = false, unique = true)
	private String urlModified;
	
	@Column(nullable = false, columnDefinition = "integer default 0") 
	private Integer counter;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dtRegister;
	
	@JsonInclude(Include.NON_EMPTY)
	@OneToMany(mappedBy = "shortUrl", cascade = CascadeType.ALL)
	private List<ShortUrlRegister> registers;
	
	public ShortUrl() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrlOriginal() {
		return urlOriginal;
	}

	public void setUrlOriginal(String urlOriginal) {
		this.urlOriginal = urlOriginal;
	}

	public String getUrlModified() {
		return urlModified;
	}

	public void setUrlModified(String urlModified) {
		this.urlModified = urlModified;
	}

	public Integer getCounter() {
		return counter;
	}

	public void setCounter(Integer counter) {
		this.counter = counter;
	}

	public Date getDtRegister() {
		return dtRegister;
	}

	public void setDtRegister(Date dtRegister) {
		this.dtRegister = dtRegister;
	}

	public List<ShortUrlRegister> getRegisters() {
		return registers;
	}

	public void setRegisters(List<ShortUrlRegister> registers) {
		this.registers = registers;
	}

}
