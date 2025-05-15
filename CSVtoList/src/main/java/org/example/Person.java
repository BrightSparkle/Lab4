package org.example;
import java.time.LocalDate;

/**
 * Представляет информацию о человеке, включая его личные данные и данные о работе.
 */
public class Person {
    private int id;
    private String name;
    private Gender gender;
    private Department department;
    private double salary;
    private LocalDate birthDate;

    /**
     * Создает экземпляр человека.
     *
     * @param id          уникальный идентификатор (должен быть положительным)
     * @param name        полное имя (не должно быть null или пустым)
     * @param gender      пол
     * @param department  подразделение
     * @param salary      зарплата (должна быть неотрицательной)
     * @param birthDate   дата рождения (не должна быть null или будущей датой)
     * @throws IllegalArgumentException если параметры не соответствуют ограничениям
     */
    public Person(int id, String name, Gender gender, Department department, double salary, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
        this.birthDate = birthDate;
    }

    /**
     * Возвращает уникальный идентификатор человека.
     * @return ID человека.
     */
    public int getId() {
        return id;
    }

    /**
     * Возвращает полное имя человека.
     * @return имя
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает пол человека.
     * @return пол
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Возвращает подразделение человека.
     * @return подразделение
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Возвращает зарплату человека.
     * @return зарплата
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Возвращает дату рождения человека.
     * @return дата рождения
     */
    public LocalDate getBirthDate() {
        return birthDate;
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
