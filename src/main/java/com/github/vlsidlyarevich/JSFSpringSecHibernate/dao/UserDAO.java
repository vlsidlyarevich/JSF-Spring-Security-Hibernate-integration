package com.github.vlsidlyarevich.JSFSpringSecHibernate.dao;


import com.github.vlsidlyarevich.JSFSpringSecHibernate.entities.UserEntity;

public interface UserDAO {


    void save(UserEntity userEntity);


    Integer getId ();


    UserEntity findUserByLogin(String login);


}
