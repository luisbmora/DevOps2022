package com.mora.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.mora.dao.CuentaDAO;
import com.mora.modelos.Cuentas;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	CuentaDAO usrDao;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Cuentas usr = usrDao.findUsuarioByNombre(username); 
		System.out.println(" hpohajhskjHAK"+ usr.getEmail() +" "+ usr.getPassword()+" "+ usr.getId());
		return UserDetailsImpl.build(usr);
	}
}
