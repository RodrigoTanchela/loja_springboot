package com.rodrigo.loja.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rodrigo.loja.springboot.model.vo.v1.security.AccountCredentialsVO;
import com.rodrigo.loja.springboot.model.vo.v1.security.TokenVO;
import com.rodrigo.loja.springboot.repository.UsuarioRepository;
import com.rodrigo.loja.springboot.security.jwt.JwtTokenProvider;

@Service
public class AuthServices {
	
	@Autowired
	private AuthenticationManager authentication;
	
	@Autowired
	private JwtTokenProvider tokenProvider;
	
	@Autowired
	private UsuarioRepository repository;
	
	@SuppressWarnings("rawtypes")
	public ResponseEntity signin(AccountCredentialsVO data) {
		try {
				var username = data.getUsername();
				var password = data.getPassword();
				authentication.authenticate(
						new UsernamePasswordAuthenticationToken(username, password));
				
				var user = repository.findByUsername(username);
				
				TokenVO token = new TokenVO();
				if (user != null) {
					token = tokenProvider.createAccessToken(username, user.getRoles());
				} else {
					throw new UsernameNotFoundException("Username "+ username+ " not found!");
				}
				return ResponseEntity.ok(token);
				
			}catch (Exception e) {
				throw new BadCredentialsException("Invalid username/password supplied!");
			}
				
		}		
	
	@SuppressWarnings("rawtypes")
	public ResponseEntity refreshToken(String username, String refreshToken) {
		var user = repository.findByUsername(username);
		
		var tokenVO = new TokenVO();
		if(user != null) {
			tokenVO = tokenProvider.refreshToken(username);
		} else {
			throw new UsernameNotFoundException("Username "+ username+ " not found!");
		}
		return ResponseEntity.ok(tokenVO);
	}
}
