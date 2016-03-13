package com.github.vlsidlyarevich.JSFSpringSecHibernate.beans;


import com.github.vlsidlyarevich.JSFSpringSecHibernate.dao.UserDAO;
import com.github.vlsidlyarevich.JSFSpringSecHibernate.entities.UserEntity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class UserBean {

    private String login;
    private String name;
    private String password;
    private String role;

    public String saveUser(){
        UserDAO userDAO = new UserDAO();
        Integer userID = userDAO.getId();
        UserEntity userEntity = new UserEntity(userID,name,role,login,password);
        userDAO.save(userEntity);
        System.out.println("User successfully saved.");
        return "output";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
