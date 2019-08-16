package br.com.shorturl.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Util {
	
	public static final String URL_MAIN = "http://localhost:8080/shorturl/";
	
	public static String gerarUrlModified(String urlOriginal) throws NoSuchAlgorithmException {
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(String.valueOf(new Date().getTime()).getBytes());
		byte[] hash = md.digest();
		
		return hash.toString().substring(3,10);
	}

}
