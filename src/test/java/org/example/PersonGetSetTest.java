package org.example;

import org.example.Homework_9.Man;
import org.example.Homework_9.Person;
import org.example.Homework_9.Woman;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonGetSetTest {
    private Man man;
    private Woman woman;
    private Person partner;

    @Before
    public void setUp(){
        partner = new Person("John", "Andrade", 30, null);
        man = new Man("Fernando", "Alonso", 66, partner);
        woman = new Woman("Michele", "Andrade", 61, partner);
    }

    @Test
    public void testManSettersAndGetters(){
        man.setFirstName("Tom");
        assertEquals("Tom",man.getFirstName());

        man.setLastName("Cruise");
        assertEquals("Cruise",man.getLastName());

        man.setAge(58);
        assertEquals(58,man.getAge());

        Person newPartner = new Person("Sarah", "Connor",40,null);
        man.setPartner(newPartner);
        assertEquals(newPartner,man.getPartner());
    }

    @Test
    public void testWomanSettersAndGetters(){
        woman.setFirstName("Angelina");
        assertEquals("Angelina",woman.getFirstName());

        woman.setLastName("Jolie");
        assertEquals("Jolie",woman.getLastName());

        woman.setAge(45);
        assertEquals(45,woman.getAge());

        Person newPartner = new Person("Tom", "Hanks", 65, null);
        woman.setPartner(newPartner);
        assertEquals(newPartner,woman.getPartner());
    }

}
