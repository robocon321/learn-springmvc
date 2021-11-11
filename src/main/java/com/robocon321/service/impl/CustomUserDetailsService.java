package com.robocon321.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.robocon321.constant.SystemContant;
import com.robocon321.dto.MyUser;
import com.robocon321.entity.AccountEntity;
import com.robocon321.entity.RoleEntity;
import com.robocon321.repository.AccountRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private AccountRepository accountRepository;
	
	@SuppressWarnings("unused")
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AccountEntity accountEntity = accountRepository.findOneByUsernameAndStatus(username, SystemContant.ACTIVE_STATUS);
		if(accountEntity == null) throw new UsernameNotFoundException("User not found");
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(RoleEntity role: accountEntity.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		}
		MyUser user = new MyUser(accountEntity.getUsername(), accountEntity.getPassword(), true, true, true, true, authorities);
		user.setFullname(accountEntity.getFullname());
		return user;
	}

}
