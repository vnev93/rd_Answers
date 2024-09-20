package org.example;

import org.example.Homework_9.Man;
import org.example.Homework_9.Person;
import org.example.Homework_9.Woman;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class PersonGetSetTest {
    private Man man;
    private Woman woman;
    private Person partner;

    @BeforeMethod
    public void setUp(){
        partner = new Person("John", "Andrade", 30, null);
        man = new Man("Fernando", "Alonso", 66, partner);
        woman = new Woman("Michele", "Andrade", 61, partner);
    }

    @Test
    public void testManSettersAndGetters(){
        man.setFirstName("Tom");
        assertEquals(man.getFirstName(), "Tom");

        man.setLastName("Cruise");
        assertEquals(man.getLastName(), "Cruise");

        man.setAge(58);
        assertEquals(man.getAge(), 58);

        Person newPartner = new Person("Sarah", "Connor", 40, null);
        man.setPartner(newPartner);
        assertEquals(man.getPartner(), newPartner);
    }

    @Test
    public void testWomanSettersAndGetters(){
        woman.setFirstName("Angelina");
        assertEquals(woman.getFirstName(), "Angelina");

        woman.setLastName("Jolie");
        assertEquals(woman.getLastName(), "Jolie");

        woman.setAge(45);
        assertEquals(woman.getAge(), 45);

        Person newPartner = new Person("Tom", "Hanks", 65, null);
        woman.setPartner(newPartner);
        assertEquals(woman.getPartner(), newPartner);
    }
}
