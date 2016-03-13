package com.github.vlsidlyarevich.JSFSpringSecHibernate.services;


import com.github.vlsidlyarevich.JSFSpringSecHibernate.dao.UserDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("userDetailsService")
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserDAOImpl userDAOImpl;


    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        UserDetails userDetails = null;
        com.github.vlsidlyarevich.JSFSpringSecHibernate.entities.UserEntity userEntity = userDAOImpl.findUserByLogin(login);

        if(userEntity == null)
            throw new UsernameNotFoundException("user not found");


        return new User(
                userEntity.getLogin(),
                userEntity.getPassword(),
                true,true,true,true,
                getAuthorities(userEntity.getRole())
        );
    }



    public Collection<? extends GrantedAuthority> getAuthorities(String role) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }




}
