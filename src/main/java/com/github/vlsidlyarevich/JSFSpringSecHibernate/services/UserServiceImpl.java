package com.github.vlsidlyarevich.JSFSpringSecHibernate.services;


import com.github.vlsidlyarevich.JSFSpringSecHibernate.dao.UserDAO;
import com.github.vlsidlyarevich.JSFSpringSecHibernate.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@Service
@Transactional("transactionManager")
@ManagedBean(name = "userService")
@SessionScoped
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public Integer getId(){
        return userDAO.getId();
    }

    public void saveUser(UserEntity user){
        userDAO.save(user);
    }


    public UserEntity findUserByLogin(String login) {
        return userDAO.findUserByLogin(login);
    }

}
