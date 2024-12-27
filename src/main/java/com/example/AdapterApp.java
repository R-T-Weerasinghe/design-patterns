package com.example;

class OldStudent {
    String name;
    int year;

    OldStudent(String name, int year) {
        this.name = name;
        this.year = year;
    }
}

class NewStudent {
    String name;
    String level;

    NewStudent(String name, String level) {
        this.name = name;
        this.level = level;
    }
}


class OldSystem {
    OldStudent getStudent() {
        return new OldStudent("Janith", 3);
    }
}


class NewSystem {
    void displayStudent(NewStudent student) {
        System.out.println("Student name: " + student.name);
        System.out.println("Student level: " + student.level);
    }
}

class Adapter {
    private OldSystem oldSystem;

    Adapter(OldSystem oldSystem) {
        this.oldSystem = oldSystem;
    }

    NewStudent getStudent() {
        OldStudent oldStudent = oldSystem.getStudent();
        NewStudent newStudent = new NewStudent(oldStudent.name, String.valueOf(oldStudent.year));
        return newStudent;
    }
}


public class AdapterApp {
    public static void main(String[] args) {
        OldSystem oldSystem = new OldSystem();
        Adapter adapter = new Adapter(oldSystem);
        NewSystem system = new NewSystem();
    
        system.displayStudent(adapter.getStudent());
    }
}
