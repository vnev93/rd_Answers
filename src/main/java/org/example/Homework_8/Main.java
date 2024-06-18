package org.example.Homework_8;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Bradley", "Cooper");
        Student student2 = new Student("John", "Smith");
        Student student3 = new Student("Cristiano", "Ronaldo");

        StudentsGroup group = new StudentsGroup(student1);

        group.addNewStudents(student2);
        group.addNewStudents(student3);

        group.addTasks("Java booleans ");
        group.addTasks("Study inheritance");

        System.out.println("Initial group" + group);

        group.changeLeader(student2);
        System.out.println("After changing leader" +group);

        group.markTaskAsCompleted(student3, "Java booleans");
        System.out.println("After marking task as completed" + group);

        group.removeStudents(student3);
        System.out.println("After removing student:" +group);
    }
}
