package com.github.vlsidlyarevich.JSFSpringSecHibernate.dao;

import com.github.vlsidlyarevich.JSFSpringSecHibernate.entities.UserEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;




@Repository
@SuppressWarnings("unchecked")
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void save(UserEntity userEntity){
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(userEntity);
        session.getTransaction().commit();
        session.close();
    }

    public Integer getId (){
        Session session = this.sessionFactory.getCurrentSession();
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
        Session session = this.sessionFactory.getCurrentSession();
        List<UserEntity> users = new ArrayList<UserEntity>();

        Query query = session.createQuery("from UserEntity u where u.login = :login");
        query.setParameter("login",login);
        users = query.list();
        if(users.size()>0)return users.get(0);
        return null;
    }


}
