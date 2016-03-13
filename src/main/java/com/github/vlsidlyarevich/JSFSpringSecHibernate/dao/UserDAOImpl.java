package com.github.vlsidlyarevich.JSFSpringSecHibernate.dao;

import com.github.vlsidlyarevich.JSFSpringSecHibernate.entities.UserEntity;
import com.github.vlsidlyarevich.JSFSpringSecHibernate.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl {

    Session session = HibernateUtils.getSessionFactory().openSession();

    public void save(UserEntity userEntity){
        session.beginTransaction();
        session.save(userEntity);
        session.getTransaction().commit();
        session.close();
    }

    public Integer getId (){
        String hql = "select max(user.id) from UserEntity user";
        Query query = session.createQuery(hql);
        List<Integer> results = query.list();
        Integer userId = 1;
        if (results.get(0) != null ) {
            userId = results.get(0) + 1;
        }
        return userId;
    }

    public UserEntity findUserByLogin(String login){

        List<UserEntity> users = new ArrayList<UserEntity>();

        Query query = session.createQuery("from UserEntity u where u.login =: login");
        query.setParameter("login",login);
        users = query.list();
        if(users.size()>0)return users.get(0);
        return null;
    }


}
