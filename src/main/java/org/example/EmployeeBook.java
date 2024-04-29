package org.example;

import java.util.Arrays;
import java.util.Objects;

public class EmployeeBook {
    private Employee[] employees;

    private int length = 10;

    public EmployeeBook(int numberOfWorkspaces) {
        employees = new Employee[length];
    }

    public int getLength() {
        return length;
    }

    // Добавляем сотрудника, если есть место
    public boolean addNewEmployee(Employee employee) {
        boolean isAdded = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return true;
            }
        }
        return false;
    }

    // Удаляем сотрудника по введенному ID
    public void removeEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            }
            if (employees[i].getId() == id) {
                employees[i] = null;
                return;
            }
        }
    }

    //Получаем сотрудника по введенному ID
    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    // Проверяем существует ли отдел
    public boolean isDivisionExist(int division) {
        return division > 0 && division <= 5;
    }

    // Вывести полную информацию о всех сотрудниках
    public void printEmployees() {
        if (employees == null || employees.length == 0) {
            throw new NullPointerException("Невозможно вывести информацию по сотрудникам. Список сотрудников пуст.");
        }
        for (Employee e : employees) {
            if (e == null) {
                continue;
            }
            System.out.println(e);
        }
    }

    // Посчитать сумму затрат на ЗП
    public int calculateTotalSalarySum() {
        if (employees == null || employees.length == 0) {
            throw new NullPointerException("Невозможно ввычислить общюю сумму зарплат. Список сотрудников пуст.");
        }
        int salarySum = 0;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            salarySum += employee.getSalary();
        }
        return salarySum;
    }

    // Найти сотрудника с минимальной ЗП
    public Employee findLessCostEmployee() {
        if (employees == null || employees.length == 0) {
            throw new NullPointerException("Невозможно найти наименьшую зарплату. Список сотрудников пуст.");
        }
        Employee min = null;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (min == null) {
                min = employee;
                continue;
            }
            if (min.getSalary() > employee.getSalary()) {
                min = employee;
            }
        }
        return min;
    }

    // Найти сотрудника с максимальной ЗП
    public Employee findMoreCostEmployee() {
        if (employees == null || employees.length == 0) {
            throw new NullPointerException("Невозможно найти наибольшую. Список сотрудников пуст.");
        }
        Employee max = null;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (max == null) {
                max = employee;
                continue;
            }
            if (max.getSalary() < employee.getSalary()) {
                max = employee;
            }
        }
        return max;
    }

    // Получить среднее значение зарплат
    public double calculateEverageSalary() {
        if (employees == null || employees.length == 0) {
            throw new NullPointerException("Невозможно найти среднее значение зарплат. Список сотрудников пуст.");
        }
        return calculateTotalSalarySum() / employees.length;
    }

    // Вывести на экран фио всех сотрудников
    public void printEmployeesFullNames() {
        if (employees == null || employees.length == 0) {
            throw new NullPointerException("Невозможно вывести на экран ФИО сотрудников. Список сотрудников пуст.");
        }
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            System.out.println(employee.getFirstName() + " " + employee.getMiddleName() + " " + employee.getLastName());
        }
    }

    // Индексация зарплат
    public void salaryIndexation(float percent) {
        if (employees == null || employees.length == 0) {
            throw new NullPointerException("Невозможно проиндексировать зарплаты. Список сотрудников пуст.");
        }
        percent = percent / 100;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            employee.setSalary(employee.getSalary() + (int) (employee.getSalary() * percent));
        }
    }

    // Методы для получения информации по номеру отдела:

    // Найти сотрудника с минимальной ЗП в отделе
    public Employee findLessCostEmployeeInDivision(int division) {
        if (employees == null || employees.length == 0) {
            throw new NullPointerException("Невозможно найти наименьшую зарплату. Список сотрудников пуст.");
        }
        if (!isDivisionExist(division)) {
            throw new IllegalArgumentException("Отдела с таким номером в компании нет.");
        }
        Employee min = null;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getDivision() != division) {
                continue;
            }
            if (min == null) {
                min = employee;
                continue;
            }
            if (min.getSalary() > employee.getSalary()) {
                min = employee;
            }
        }
        if (min == null) {
            throw new NullPointerException("В этом отделе нет сотрудников. Отдел пуст.");
        }
        return min;
    }

    // Найти сотрудника с максимальной ЗП в отделе
    public Employee findMoreCostEmployeeInDivision(int division) {
        if (employees == null || employees.length == 0) {
            throw new NullPointerException("Невозможно найти наибольшую. Список сотрудников пуст.");
        }
        if (!isDivisionExist(division)) {
            throw new IllegalArgumentException("Отдела с таким номером в компании нет.");
        }
        Employee max = null;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getDivision() != division) {
                continue;
            }
            if (max == null) {
                max = employee;
                continue;
            }
            if (max.getSalary() < employee.getSalary()) {
                max = employee;
            }
        }
        if (max == null) {
            throw new NullPointerException("В этом отделе нет сотрудников. Отдел пуст.");
        }
        return max;
    }

    // Найти сумму затрат на зп по отделу
    public int calculateTotalSalarySumInDivision(int division) {
        if (employees == null || employees.length == 0) {
            throw new NullPointerException("Невозможно ввычислить общюю сумму зарплат. Список сотрудников пуст.");
        }
        if (!isDivisionExist(division)) {
            throw new IllegalArgumentException("Отдела с таким номером в компании нет.");
        }
        int salarySum = 0;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getDivision() != division) {
                continue;
            }
            salarySum += employee.getSalary();
        }
        return salarySum;
    }

    //Найти среднее значение ЗП по отделу
    public double calculateEverageSalaryInDivision(int division) {
        if (employees == null || employees.length == 0) {
            throw new NullPointerException("Невозможно найти среднее значение зарплат. Список сотрудников пуст.");
        }
        if (!isDivisionExist(division)) {
            throw new IllegalArgumentException("Отдела с таким номером в компании нет.");
        }
        int employeesInDivision = 0;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getDivision() == division) {
                employeesInDivision++;
            }
        }
        if (employeesInDivision == 0) {
            throw new NullPointerException("Невозможно найти среднее значение зарплат. Список сотрудников пуст.");
        }
        return calculateTotalSalarySumInDivision(division) / employeesInDivision;
    }

    // Проиндексировать зарплаты в отделе
    public void salaryIndexationInDivision(float percent, int division) {
        if (employees == null || employees.length == 0) {
            throw new NullPointerException("Невозможно проиндексировать зарплаты. Список сотрудников пуст.");
        }
        if (!isDivisionExist(division)) {
            throw new IllegalArgumentException("Отдела с таким номером в компании нет.");
        }
        percent = percent / 100;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getDivision() != division) {
                continue;
            }
            employee.setSalary(employee.getSalary() + (int) (employee.getSalary() * percent));
        }
    }

    // Напечатать всех сотрудников отдела (все данные, кроме отдела)
    public void printEmployeesInfoInDivision(int division) {
        if (employees == null || employees.length == 0) {
            throw new NullPointerException("Невозможно найти среднее значение зарплат. Список сотрудников пуст.");
        }
        if (!isDivisionExist(division)) {
            throw new IllegalArgumentException("Отдела с таким номером в компании нет.");
        }
        boolean isEmpty = true;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getDivision() != division) {
                continue;
            }
            isEmpty = false;
            System.out.println("ID сотрудника: " + employee.getId() + ", ФИО: " + employee.getFirstName() + " " + employee.getMiddleName() + " " + employee.getLastName() + ", Размер ЗП: " + employee.getSalary());
        }
        if (isEmpty) {
            System.out.println("В " + division + " отделе нет сотрудников");
        }
    }

    // Получить в качестве параметра число, и вывести:

    // Всех сотрудников с ЗП ниже или равной заданной
    public void printEmployeesWithSalaryLessThen(int salaryEdge) {
        if (employees == null || employees.length == 0) {
            throw new NullPointerException("Невозможно обнаружить сотрудников. Список сотрудников пуст.");
        }
        boolean isFind = false;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getSalary() <= salaryEdge) {
                isFind = true;
                System.out.println("ID сотрудника: " + employee.getId() + ", ФИО: " + employee.getFirstName() + " " + employee.getMiddleName() + " " + employee.getLastName() + ", Размер ЗП: " + employee.getSalary());
            }
        }
        if (!isFind) {
            System.out.println("Сотрудников с зарплатой ниже заданного значения не обнаружено.");
        }
    }

    // Всех сотрудников с ЗП выше или равной заданной
    public void printEmployeesWithSalaryMoreThen(int salaryEdge) {
        if (employees == null || employees.length == 0) {
            throw new NullPointerException("Невозможно обнаружить сотрудников. Список сотрудников пуст.");
        }
        boolean isFind = false;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getSalary() >= salaryEdge) {
                isFind = true;
                System.out.println("ID сотрудника: " + employee.getId() + ", ФИО: " + employee.getFirstName() + " " + employee.getMiddleName() + " " + employee.getLastName() + ", Размер ЗП: " + employee.getSalary());
            }
        }
        if (!isFind) {
            System.out.println("Сотрудников с зарплатой выше заданного значения не обнаружено.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeBook that = (EmployeeBook) o;
        return length == that.length && Arrays.equals(employees, that.employees);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(length);
        result = 31 * result + Arrays.hashCode(employees);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Employee employee : employees) {
            if (employee != null) {
                builder.append("  ");
                builder.append(employee.toString()).append("\n");
            }
        }
        return "EmployeeBook:\n" + " Employees:\n" + builder + " Length:" + length;
    }
}
