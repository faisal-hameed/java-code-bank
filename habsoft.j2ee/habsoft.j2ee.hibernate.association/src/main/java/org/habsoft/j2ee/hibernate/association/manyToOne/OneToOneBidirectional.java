package org.habsoft.j2ee.hibernate.association.manyToOne;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.habsoft.j2ee.hibernate.association.BaseDao;
import org.habsoft.j2ee.hibernate.association.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class OneToOneBidirectional extends BaseDao {

    protected OneToOneBidirectional() {
        super(OneToOneBidirectional.class.getName());
    }

    public static void main(String[] args) {
        OneToOneBidirectional d = new OneToOneBidirectional();
        d.test();
    }

    public void test() {

        Student student1 = new Student("Shami");
        Address address1 = new Address("OMR Road", student1);
        address1.setStudent(student1);
        Long id = save(address1);

        // Criteria criteria =
        // getSession().createCriteria(Address.class).createAlias("student",
        // "std");
        // criteria.add(Restrictions.eq("std.id", 2L));
        // Address std = (Address) criteria.uniqueResult();

        Criteria criteria = getSession().createCriteria(Student.class);
        criteria.add(Restrictions.eq("id", 2L));
        Student std = (Student) criteria.uniqueResult();

        System.out.println(std);

    }

    @Entity
    @Table(name = "student")
    public static class Student {

        @Id
        @GeneratedValue
        private long id;
        private String name;

        @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        @JoinColumn(name = "id")
        private Address address;

        public Student() {
        }

        public Student(String studentName) {
            this.name = studentName;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        @Override
        public String toString() {
            return "Student [id=" + id + ", name=" + name + ", address=" + address + "]";
        }

    }

    @Entity
    @Table(name = "address")
    public static class Address {

        @Id
        @GeneratedValue
        private long id;
        private String street;

        @OneToOne(cascade = CascadeType.ALL)
        private Student student;

        public Address() {
        }

        public Address(String street, Student student) {
            this.street = street;
            this.student = student;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public Student getStudent() {
            return student;
        }

        public void setStudent(Student student) {
            this.student = student;
        }

        @Override
        public String toString() {
            return "Address [id=" + id + ", street=" + street + ", student=" + student + "]";
        }

    }

}