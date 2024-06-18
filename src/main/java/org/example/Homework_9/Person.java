package org.example.Homework_9;

public class Person {

        protected String firstName;
        protected String lastName;
        protected int age;
        protected Person partner;

    public Person(String firstName, String lastName, int age, Person partner){
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.partner = partner;
        }

    public Person() {
        }

        public String getFirstName () {
            return firstName;
        }
        public void setFirstName (String firstName){
            this.firstName = firstName;
        }
        public String getLastName () {
            return lastName;
        }
        public void setLasName (String lastName){
            this.lastName = lastName;
        }
        public int getAge () {
            return age;
        }
        public void setAge ( int age){
            this.age = age;
        }
        public Person getPartner () {
            return partner;
        }
        public void setPartner (Person partner){
            this.partner = partner;
        }
        public boolean isRetired () {
            return false;
        }
        public void registerPartnership (Person partner){
            this.partner = partner;
        }
        public void deregisterPartnership ( boolean returnToPreviousLastName){
            this.partner = null;
        }
    }
