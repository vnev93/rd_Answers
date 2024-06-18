package org.example.Homework_9;

public class Woman extends Person {
    private String previousLastName;

    public Woman(String firstName, String lastName, int age, Person partner) {
        super(firstName, lastName, age, partner);
    }
    @Override
    public boolean isRetired(){
        return age > 65;
    }
    @Override
    public void registerPartnership (Person partner){
        if (partner instanceof Man){
            this.previousLastName = previousLastName;
            this.lastName = partner.getLastName();
        }
        super.registerPartnership(partner);
    }
    @Override
    public void deregisterPartnership(boolean returnToPreviousLastName){
        if (returnToPreviousLastName && this.previousLastName != null){
            this.lastName = this.previousLastName;
        }
        super.deregisterPartnership(returnToPreviousLastName);
    }
}
