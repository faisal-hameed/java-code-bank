package org.habsoft.j2ee.hibernate.association;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.github.fluent.hibernate.cfg.scanner.EntityScanner;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml

            Configuration configuration = new Configuration().configure();
            EntityScanner.scanPackages("org.habsoft.j2ee.hibernate.association").addTo(configuration);
            SessionFactory sessionFactory = configuration.buildSessionFactory();

            return sessionFactory;

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}