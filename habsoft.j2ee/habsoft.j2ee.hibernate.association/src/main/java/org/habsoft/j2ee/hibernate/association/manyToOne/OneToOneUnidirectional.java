package org.habsoft.j2ee.hibernate.association.manyToOne;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.habsoft.j2ee.hibernate.association.BaseDao;

public class OneToOneUnidirectional extends BaseDao {

    protected OneToOneUnidirectional() {
        super(OneToOneUnidirectional.class.getName());
    }

    public static void main(String[] args) {
        OneToOneUnidirectional d = new OneToOneUnidirectional();
        d.test();
    }

    public void test() {

        Student student1 = new Student("Shami");
        Address address1 = new Address("OMR Road", student1);
        save(address1);

    }

    @Entity
    @Table(name = "student")
    public class Student {

        @Id
        @GeneratedValue
        private long id;
        private String name;

        public Student() {
        }

        public Student(String studentName) {
            this.name = studentName;
        }

    }

    @Entity
    @Table(name = "address")
    public class Address {

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

    }

}
