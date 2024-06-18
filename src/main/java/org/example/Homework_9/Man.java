package org.example.Homework_9;

 class Man extends Person {
    public Man(String firstName, String lastName, int age, Person partner){
    super(firstName,lastName,age,partner);
    }
    @Override
     public boolean isRetired(){
        return age > 65;
    }
    @Override
     public void registerPartnership(Person partner){
        super.registerPartnership(partner);
    }
    @Override
     public void deregisterPartnership(boolean returnToPreviousLastName){
        super.deregisterPartnership(returnToPreviousLastName);
    }
}
