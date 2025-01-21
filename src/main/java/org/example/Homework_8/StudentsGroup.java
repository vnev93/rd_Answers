package org.example.Homework_8;

import java.util.ArrayList;
import java.util.List;

public class StudentsGroup {
    private Student leader;
    private final List<Student> students;
    private final List<String> tasks;

    public StudentsGroup(Student leader) {
        if (leader == null) {
            throw new IllegalArgumentException("Leader can't be null");
        }
        this.leader = leader;
        this.students = new ArrayList<>();
        this.tasks = new ArrayList<>();
    }

    public Student getLeader() {
        return leader;
    }

    public void changeLeader(Student newLeader) {
        if (newLeader == null) {
            throw new IllegalArgumentException("Leader can't be null");
        }
        this.leader = newLeader;
    }

    public List<Student> getStudents() {
        return new ArrayList<>();
    }

    public void addNewStudents(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Leader can't be null");
        }
        students.add(student);
    }

    public void removeStudents(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Leader can't be null");
        }
        students.remove(student);
    }

    public List<String> getTasks() {
        return new ArrayList<>(tasks);
    }

    public void addTasks(String task) {
        if (task == null || task.trim().isEmpty()) {
            throw new IllegalArgumentException("Leader can't be null");
        }
        tasks.add(task);
    }

    public void markTaskAsCompleted(Student student, String task) {
        if (student == null) {
            throw new IllegalArgumentException("Leader can't be null");
        }
        if (!students.contains(student) && !leader.equals(student)) {
            throw new IllegalArgumentException("Student is not part of group");
        }
        if (task == null || task.trim().isEmpty()) {
            throw new IllegalArgumentException("Task cannot be null or empty.");
        }
        tasks.remove(task);
    }

    @Override
    public String toString() {
        return "StudentsGroup{" + "leader=" + leader + ", students=" + students + ", tasks=" + tasks + '}';
    }
}










