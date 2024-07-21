package org.example;

import org.example.Homework_9.Man;
import org.example.Homework_9.Person;
import org.example.Homework_9.Woman;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNull;

public class PersonTest {
    private Man man;
    private Woman woman;
    private Person partner;

    @BeforeMethod
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

    @DataProvider(name = "personDataProvider")
    public Object[][] personalDataProvider() {
        return new Object[][]{
                {new Man("Fernando", "Alonso", 66, partner), "Fernando", "Alonso", 66, true},
                {new Woman("Michele", "Andrade", 61, partner), "Michele", "Andrade", 61, false}
        };
    }

    @Test(dataProvider = "personDataProvider")
    public void testPersonFields(Person person, String firstName, String lastName, int age, boolean isRetired) {
        assertEquals(person.getFirstName(), firstName);
        assertEquals(person.getLastName(), lastName);
        assertEquals(person.getAge(), age);
        if (person instanceof Man) {
            assertEquals(((Man) person).isRetired(), isRetired);
        } else if (person instanceof Woman) {
            assertEquals(((Woman) person).isRetired(), isRetired);
        }
    }

    @DataProvider(name = "partnershipDataProvider")
    public Object[][] partnershipDataProvider() {
        return new Object[][] {
                {new Man("Fernando", "Alonso", 66, partner), new Person("Sarah", "Connor", 40, null)},
                {new Woman("Michele", "Andrade", 61, partner), new Person("Arnold", "Schwarzenegger", 50, null)}
        };
    }
    @Test(dataProvider = "partnershipDataProvider")
    public void testRegisterPartnership(Person person,Person newPartner){
        person.registerPartnership(newPartner);
        assertEquals(newPartner,person.getPartner());
    }
    @DataProvider(name = "deregisterDataProvider")
    public Object[][] deregisterDataProvider(){
        return new Object[][]{
                {new Man("Fernando", "Alonso", 66, partner), false},
                {new Woman("Michele", "Andrade", 61, partner), true}
        };
    }
    @Test(dataProvider = "deregisterDataProvider")
    public void testDeregisterPartnership(Person person,boolean changeLastName){
        person.deregisterPartnership(changeLastName);
        assertNull(person.getPartner());
        if (changeLastName) {
            assertEquals(((Woman)person).getLastName(),"Andrade");
        }
    }
}







