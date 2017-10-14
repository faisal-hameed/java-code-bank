package org.habsoft.j2ee.hibernate.association.manyToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.habsoft.j2ee.hibernate.association.BaseDao;

public class ManyToOneUnidirectional extends BaseDao {

    protected ManyToOneUnidirectional() {
        super(ManyToOneUnidirectional.class.getName());
    }

    public static void main(String[] args) {
        ManyToOneUnidirectional d = new ManyToOneUnidirectional();
        d.test();
    }

    public void test() {
        System.out.println("Hibernate Many-To-One example (Annotation)");

        Person person = new Person();
        save(person);

        Phone phone = new Phone("123-456-7890");
        phone.setPerson(person);

        save(phone);

        phone = new Phone("123-456-7890");
        phone.setPerson(person);

        save(phone);
    }

//    @Entity(name = "Person")
    public static class Person {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        public Person() {
        }
    }

//    @Entity(name = "Phone")
    public static class Phone {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "`number`")
        private String number;

        @ManyToOne
        @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "PERSON_ID_FK"))
        private Person person;

        public Phone() {
        }

        public Phone(String number) {
            this.number = number;
        }

        public Long getId() {
            return id;
        }

        public String getNumber() {
            return number;
        }

        public Person getPerson() {
            return person;
        }

        public void setPerson(Person person) {
            this.person = person;
        }
    }
}
