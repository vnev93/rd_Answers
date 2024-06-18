package org.example.Homework_9;

public class Main {
    public static void main(String[] args) {
        Man man = new Man("Fernando","Alonso",66, null);
        Woman woman = new Woman("Michele","Andrade", 61,null);

        System.out.println(man.getFirstName()+" " + man.getLastName() + " is retired" + man.isRetired());
        System.out.println(woman.getFirstName()+ " " +woman.getLastName() + " is retired" + woman.isRetired());

        man.registerPartnership(woman);
        woman.registerPartnership(man);

        System.out.println("After registration:");
        System.out.println(woman.getFirstName() + " " + woman.getLastName() + " is now partnered with" + man.getFirstName()
        + " " + man.getLastName());

        woman.deregisterPartnership(true);
        man.deregisterPartnership(false);

        System.out.println("After registration:");
        System.out.println(woman.getFirstName() + " " + woman.getLastName() + " is no single");
        System.out.println(man.getFirstName() + " " + man.getLastName() + " is no single");
    }
}
