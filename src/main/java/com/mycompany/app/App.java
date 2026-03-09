package com.mycompany.app;

import java.util.function.*;

/**
 * HOS08A - Functional Programming in Java
 * Demonstrates lambda expressions using Predicate, Function, and Consumer
 * 
 * @author Jonathon Pioquinto
 */
public class App {
    public static void main(String[] args) {
        // Initialize array of Student objects with sample data
        Student[] students = {
            new Student("Alice", 85.0),
            new Student("Bob", 55.0),
            new Student("Charlie", 72.0),
            new Student("Diana", 45.0),
            new Student("Eve", 90.0)
        };

        // Predicate - checks if student passed (grade >= 60)
        Predicate<Student> isPassing = student -> student.grade >= 60;

        // Function - adds 5 bonus points to student's grade
        Function<Student, Student> applyBonus = student -> {
            student.grade += 5;
            return student;
        };

        // Consumer - prints student information
        Consumer<Student> printStudent = student -> 
            System.out.println(student);

        // Process the array using functional interfaces
        System.out.println("Passing Students (with 5-point bonus applied):");
        for (Student student : students) {
            // Only process students who are passing
            if (isPassing.test(student)) {
                // Apply bonus and print
                printStudent.accept(applyBonus.apply(student));
            }
        }
    }
}

/**
 * Student class - represents a student with name and grade
 */
class Student {
    String name;
    double grade;

    /**
     * Constructor to initialize student
     * @param name Student's name
     * @param grade Student's grade
     */
    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    /**
     * Override toString for readable output
     */
    @Override
    public String toString() {
        return "Student: " + name + " | Grade: " + grade;
    }
}