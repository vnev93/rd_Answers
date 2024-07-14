package org.example;

import org.example.Homework_9.Man;
import org.example.Homework_9.Person;
import org.example.Homework_9.Woman;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    private Man man;
    private Woman woman;
    private Person partner;

    @Before
    public void setUp() {
        partner = new Person("John", "Andrade", 30, null);
        man = new Man("Fernando", "Alonso", 66, partner);
        woman = new Woman("Michele", "Andrade", 61, partner);
    }

    @Test
    public void testManFields() {
        assertEquals("Fernando", man.getFirstName());
        assertEquals("Alonso", man.getLastName());
        assertEquals(66, man.getAge());
        assertEquals(partner, man.getPartner());
    }

    @Test
    public void testWomanFields() {
        assertEquals("Michele", woman.getFirstName());
        assertEquals("Andrade", woman.getLastName());
        assertEquals(61, woman.getAge());
        assertEquals(partner, woman.getPartner());
    }

    @Test
    public void testManIsRetired() {
        assertTrue(man.isRetired());
    }

    @Test
    public void testWomanIsRetired() {
        assertFalse(woman.isRetired());
    }

    @Test
    public void testManRegisterPartnership() {
        Person newPartner = new Person("Sarah", "Connor", 40, null);
        man.registerPartnership(newPartner);
        assertEquals(newPartner, man.getPartner());
    }

    @Test
    public void testWomanRegisterPartnership() {
        Person newPartner = new Person("Arnold", "Schwarzenegger", 50, null);
        woman.registerPartnership(newPartner);
        assertEquals(newPartner, woman.getPartner());
    }

    @Test
    public void testManDeregisterPartnership() {
        man.deregisterPartnership(false);
        assertNull(man.getPartner());
    }

    @Test
    public void testWomanDeregisterPartnership() {
        woman.registerPartnership(new Man("Arnold", "Schwarzenegger", 50, null));
        woman.deregisterPartnership(true);
        assertEquals("Schwarzenegger", woman.getLastName());
        assertNull(woman.getPartner());
    }
}







