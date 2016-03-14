package com.github.vlsidlyarevich.JSFSpringSecHibernate.services;

import com.github.vlsidlyarevich.JSFSpringSecHibernate.dao.UserDAO;
import com.github.vlsidlyarevich.JSFSpringSecHibernate.entities.UserEntity;

public interface UserService {

    public void setUserDAO(UserDAO userDAO);

    public Integer getId();

    public void saveUser(UserEntity user);

    public UserEntity findUserByLogin(String login);

}
