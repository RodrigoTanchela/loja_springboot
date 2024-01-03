package com.rodrigo.loja.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rodrigo.loja.springboot.model.Usuario;
import com.rodrigo.loja.springboot.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository repository;

	public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repository.findByUsername(username);
		if(usuario != null) {
			return usuario;
		}else {
	        throw new UsernameNotFoundException("Username " + username + " not found!");
	    }
	}

}
