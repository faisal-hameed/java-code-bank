package org.habsoft.j2ee.hibernate;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

// Imports ...
@Repository
public class HbmTempletUserDao {

    @Autowired
    HibernateTemplate templete;

    public void save(User user) {
        System.out.println("Try to save user.");
        Serializable id = templete.save(user);
        System.out.println("User saved : " + id);
    }

    public void delete(User user) {
        // TODO Auto-generated method stub

    }

    public User findByEmail(String email) {
        // TODO Auto-generated method stub
        return null;
    }

    public User findOne(long id) {
        // TODO Auto-generated method stub
        return null;
    }

}