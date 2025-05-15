package org.example;
import java.time.LocalDate;

public class Person {
    private int id;
    private String name;
    private Gender gender;
    private Department department;
    private double salary;
    private LocalDate birthDate;

    public Person(int id, String name, Gender gender, Department department, double salary, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", department=" + department +
                ", salary=" + salary +
                ", birthDate=" + birthDate +
                '}';
    }
}
