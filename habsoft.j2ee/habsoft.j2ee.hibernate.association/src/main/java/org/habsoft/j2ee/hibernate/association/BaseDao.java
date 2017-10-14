package org.habsoft.j2ee.hibernate.association;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.github.fluent.hibernate.cfg.scanner.EntityScanner;

public class BaseDao<T> {

    private String packageToScan;

    protected BaseDao(String packageToScan) {
        this.packageToScan = packageToScan;
        System.out.println("Package to SCAN >>>>>>>>>>>>> " + packageToScan);
    }

    protected Session getSession() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        return sf.openSession();

    }

    private SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml

            Configuration configuration = new Configuration().configure();
            EntityScanner.scanPackages(packageToScan).addTo(configuration);
            SessionFactory sessionFactory = configuration.buildSessionFactory();

            return sessionFactory;

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public Long save(Object obj) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        Long id = (Long) session.save(obj);

        session.getTransaction().commit();
        session.close();

        return id;
    }

    public T getById(Class<T> clazz, long id) {

        T result;

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        result = session.get(clazz, id);
        session.close();

        return result;
    }

}
