package com.github.vlsidlyarevich.JSFSpringSecHibernate.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {


    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name", length = 45)
    private String name;

    @Column(name = "role", length = 45)
    private String role;

    @Column(name = "login", length = 45)
    private String login;

    @Column(name="password", length = 45)
    private String password;

    public UserEntity(int id, String name, String role, String login, String password) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.login = login;
        this.password = password;
    }

    public UserEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
