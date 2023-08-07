package com.kalek.crud.security.service;


import com.kalek.crud.security.entity.Usuario;
import com.kalek.crud.security.entity.UsuarioPrincipal;
import com.kalek.crud.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//cpnvierte la clase usuario en un usuario principal
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String nombreOrEmail) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNombreUsuarioOrEmail(nombreOrEmail, nombreOrEmail).get();
        return UsuarioPrincipal.build(usuario);
    }
}
