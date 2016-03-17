package com.github.vlsidlyarevich.JSFSpringSecHibernate.services;


import com.github.vlsidlyarevich.JSFSpringSecHibernate.dao.UserDAO;
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



@Transactional
@Service("userDetailsService")
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;


    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        UserDetails userDetails = null;
        com.github.vlsidlyarevich.JSFSpringSecHibernate.entities.UserEntity userEntity = userDAO.findUserByLogin(login);

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
