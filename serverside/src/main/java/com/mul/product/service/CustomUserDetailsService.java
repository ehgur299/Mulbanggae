package com.mul.product.service;

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
import com.mul.product.model.UserInfo;
import com.mul.product.model.UserType;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
	@Autowired
	private UserInfoService service;
	
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException
	{
		UserInfo userInfo = service.detail(Integer.parseInt(id));
		
		if(userInfo == null)
		{
			throw new UsernameNotFoundException("can't find userData");
		}
		
		return new User(userInfo.getId(), userInfo.getPwd(),true, true, true, true,this.getGrantdAuthorities(userInfo));
		
	}
	
	private List<GrantedAuthority> getGrantdAuthorities(UserInfo userInfo)
	{
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		for(UserType item : userInfo.getUserType())
		{
			authorities.add(new SimpleGrantedAuthority("ROLE_" + item.getType()));
		}
		
		return authorities;
	}
}
