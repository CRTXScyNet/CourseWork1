package org.example;

import java.util.Objects;

public class Employee {
    static private long idCount = 0;
    private long id;
    private String firstName;
    private String middleName;
    private String lastName;

    private int division;

    private int salary;

    public Employee(String firstName, String middleName, String lastName, int division, int salary) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        if (division <=0 || division >= 6){
            throw new IllegalArgumentException("Ошибка!! Отдела под номером " + division + " не существует");
        }
        this.division = division;
        if (salary < 0){
            throw new IllegalArgumentException("Заработная плата не может быть ниже нуля");
        }
        this.salary = salary;
        id = idCount;
        idCount++;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        if (division <=0 || division >= 6){
            throw new IllegalArgumentException("Ошибка!! Отдела под номером " + division + " не существует!");
        }
        this.division = division;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if (salary < 0){
            throw new IllegalArgumentException("Ошибка!! Заработная плата не может быть ниже нуля!");
        }
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && division == employee.division && salary == employee.salary && Objects.equals(firstName, employee.firstName) && Objects.equals(middleName, employee.middleName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, middleName, lastName, division, salary);
    }

    @Override
    public String toString() {
        return  "Id: " + id +
                ", ФИО: " + firstName + ' ' + middleName + ' ' + lastName + ", отдел: " + division +
                ", Зарплата: " + salary + '.';
    }
}
