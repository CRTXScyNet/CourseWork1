package org.example;

public class Main {
    public static void main(String[] args) {
        EmployeeBook book = new EmployeeBook(10);

        //заполняем список случайными сотрудниками (плохой рандом)
        for (int i = 0; i < book.getLength(); i++) {
            System.out.println(book.addNewEmployee(createEmployee()));
        }

        book.printEmployees();
        System.out.println();
        System.out.println("Затраты на зарплаты: " + book.calculateTotalSalarySum());
        System.out.println();
        System.out.println("Самая маленькая зарплата в компании: " + book.findLessCostEmployee());
        System.out.println();
        System.out.println("Самая большая зарплата в компании: " + book.findMoreCostEmployee());
        System.out.println();
        System.out.println("Среднее значение зарплат в компании: " + book.calculateEverageSalary());
        System.out.println();
        book.printEmployeesFullNames();
        System.out.println();
        book.salaryIndexation(30);
        System.out.println();
        System.out.println("Самая маленькая зарплата в отделе: " + book.findLessCostEmployeeInDivision(3));
        System.out.println();
        System.out.println("Самая большая зарплата в отделе:" + book.findMoreCostEmployeeInDivision(3));
        System.out.println();
        System.out.println("Затраты на зарплаты в отделе: " + book.calculateTotalSalarySumInDivision(3));
        System.out.println();
        System.out.println("Среднее значение зарплат в отделе: " + book.calculateEverageSalaryInDivision(3));
        System.out.println();
        book.salaryIndexationInDivision(15, 3);
        System.out.println();
        System.out.println("Сотрудники третьего отдела:");
        book.printEmployeesInfoInDivision(3);
        System.out.println();
        System.out.println("Сотрудники с зарплатой ниже 30000:");
        book.printEmployeesWithSalaryLessThen(30000);
        System.out.println();
        System.out.println("Сотрудники с зарплатой выше 30000:");
        book.printEmployeesWithSalaryMoreThen(30000);
        System.out.println();
        book.removeEmployee(3);
        book.removeEmployee(5);
        book.removeEmployee(8);
        book.removeEmployee(8);
        book.printEmployees();
        System.out.println(book);

    }


//    static boolean isDivisionExist(int division) {
//        return division > 0 && division <= 5;
//    }
//
//    // Вывести полную информацию о всех сотрудниках
//    static void printEmployees(Employee[] employees) {
//        if (employees == null || employees.length == 0) {
//            throw new NullPointerException("Невозможно вывести информацию по сотрудникам. Список сотрудников пуст.");
//        }
//        for (Employee e :
//                employees) {
//            System.out.println(e);
//        }
//    }
//
//    // Посчитать сумму затрат на ЗП
//    static int calculateTotalSalarySum(Employee[] employees) {
//        if (employees == null || employees.length == 0) {
//            throw new NullPointerException("Невозможно ввычислить общюю сумму зарплат. Список сотрудников пуст.");
//        }
//        int salarySum = 0;
//        for (Employee employee : employees) {
//            salarySum += employee.getSalary();
//        }
//        return salarySum;
//    }
//
//    // Найти сотрудника с минимальной ЗП
//    static Employee findLessCostEmployee(Employee[] employees) {
//        if (employees == null || employees.length == 0) {
//            throw new NullPointerException("Невозможно найти наименьшую зарплату. Список сотрудников пуст.");
//        }
//        Employee min = null;
//        for (Employee employee : employees) {
//            if (min == null) {
//                min = employee;
//                continue;
//            }
//            if (min.getSalary() > employee.getSalary()) {
//                min = employee;
//            }
//        }
//        return min;
//    }
//
//    // Найти сотрудника с максимальной ЗП
//    static Employee findMoreCostEmployee(Employee[] employees) {
//        if (employees == null || employees.length == 0) {
//            throw new NullPointerException("Невозможно найти наибольшую. Список сотрудников пуст.");
//        }
//        Employee max = null;
//        for (Employee employee : employees) {
//            if (max == null) {
//                max = employee;
//                continue;
//            }
//            if (max.getSalary() < employee.getSalary()) {
//                max = employee;
//            }
//        }
//        return max;
//    }
//
//    // Получить среднее значение зарплат
//    static double calculateEverageSalary(Employee[] employees) {
//        if (employees == null || employees.length == 0) {
//            throw new NullPointerException("Невозможно найти среднее значение зарплат. Список сотрудников пуст.");
//        }
//        return calculateTotalSalarySum(employees) / employees.length;
//    }
//
//    // Вывести на экран фио всех сотрудников
//    static void printEmployeesFullNames(Employee[] employees) {
//        if (employees == null || employees.length == 0) {
//            throw new NullPointerException("Невозможно вывести на экран ФИО сотрудников. Список сотрудников пуст.");
//        }
//        for (Employee employee : employees) {
//            System.out.println(employee.getFirstName() +
//                    " " + employee.getMiddleName() +
//                    " " + employee.getLastName());
//        }
//    }
//
//    // Индексация зарплат
//    static void salaryIndexation(Employee[] employees, float percent) {
//        if (employees == null || employees.length == 0) {
//            throw new NullPointerException("Невозможно проиндексировать зарплаты. Список сотрудников пуст.");
//        }
//        percent = percent / 100;
//        for (Employee employee : employees) {
//            employee.setSalary(employee.getSalary() + (int) (employee.getSalary() * percent));
//        }
//    }
//
//    // Методы для получения информации по номеру отдела:
//
//    // Найти сотрудника с минимальной ЗП в отделе
//    static Employee findLessCostEmployeeInDivision(Employee[] employees, int division) {
//        if (employees == null || employees.length == 0) {
//            throw new NullPointerException("Невозможно найти наименьшую зарплату. Список сотрудников пуст.");
//        }
//        if (!isDivisionExist(division)) {
//            throw new IllegalArgumentException("Отдела с таким номером в компании нет.");
//        }
//        Employee min = null;
//        for (Employee employee : employees) {
//            if (employee.getDivision() != division) {
//                continue;
//            }
//            if (min == null) {
//                min = employee;
//                continue;
//            }
//            if (min.getSalary() > employee.getSalary()) {
//                min = employee;
//            }
//        }
//        if (min == null) {
//            throw new NullPointerException("В этом отделе нет сотрудников. Отдел пуст.");
//        }
//        return min;
//    }
//
//    // Найти сотрудника с максимальной ЗП в отделе
//    static Employee findMoreCostEmployeeInDivision(Employee[] employees, int division) {
//        if (employees == null || employees.length == 0) {
//            throw new NullPointerException("Невозможно найти наибольшую. Список сотрудников пуст.");
//        }
//        if (!isDivisionExist(division)) {
//            throw new IllegalArgumentException("Отдела с таким номером в компании нет.");
//        }
//        Employee max = null;
//        for (Employee employee : employees) {
//            if (employee.getDivision() != division) {
//                continue;
//            }
//            if (max == null) {
//                max = employee;
//                continue;
//            }
//            if (max.getSalary() < employee.getSalary()) {
//                max = employee;
//            }
//        }
//        if (max == null) {
//            throw new NullPointerException("В этом отделе нет сотрудников. Отдел пуст.");
//        }
//        return max;
//    }
//
//    // Найти сумму затрат на зп по отделу
//    static int calculateTotalSalarySumInDivision(Employee[] employees, int division) {
//        if (employees == null || employees.length == 0) {
//            throw new NullPointerException("Невозможно ввычислить общюю сумму зарплат. Список сотрудников пуст.");
//        }
//        if (!isDivisionExist(division)) {
//            throw new IllegalArgumentException("Отдела с таким номером в компании нет.");
//        }
//        int salarySum = 0;
//        for (Employee employee : employees) {
//            if (employee.getDivision() != division) {
//                continue;
//            }
//            salarySum += employee.getSalary();
//        }
//        return salarySum;
//    }
//
//    //Найти среднее значение ЗП по отделу
//    static double calculateEverageSalaryInDivision(Employee[] employees, int division) {
//        if (employees == null || employees.length == 0) {
//            throw new NullPointerException("Невозможно найти среднее значение зарплат. Список сотрудников пуст.");
//        }
//        if (!isDivisionExist(division)) {
//            throw new IllegalArgumentException("Отдела с таким номером в компании нет.");
//        }
//        int employeesInDivision = 0;
//        for (Employee employee : employees) {
//            if (employee.getDivision() == division) {
//                employeesInDivision++;
//            }
//        }
//        if (employeesInDivision == 0) {
//            throw new NullPointerException("Невозможно найти среднее значение зарплат. Список сотрудников пуст.");
//        }
//        return calculateTotalSalarySumInDivision(employees, division) / employeesInDivision;
//    }
//
//    // Проиндексировать зарплаты в отделе
//    static void salaryIndexationInDivision(Employee[] employees, float percent, int division) {
//        if (employees == null || employees.length == 0) {
//            throw new NullPointerException("Невозможно проиндексировать зарплаты. Список сотрудников пуст.");
//        }
//        if (!isDivisionExist(division)) {
//            throw new IllegalArgumentException("Отдела с таким номером в компании нет.");
//        }
//        percent = percent / 100;
//        for (Employee employee : employees) {
//            if (employee.getDivision() != division) {
//                continue;
//            }
//            employee.setSalary(employee.getSalary() + (int) (employee.getSalary() * percent));
//        }
//    }
//
//    // Напечатать всех сотрудников отдела (все данные, кроме отдела)
//    static void printEmployeesInfoInDivision(Employee[] employees, int division) {
//        if (employees == null || employees.length == 0) {
//            throw new NullPointerException("Невозможно найти среднее значение зарплат. Список сотрудников пуст.");
//        }
//        if (!isDivisionExist(division)) {
//            throw new IllegalArgumentException("Отдела с таким номером в компании нет.");
//        }
//        for (Employee employee : employees) {
//            if (employee.getDivision() != division) {
//                continue;
//            }
//            System.out.println("ID сотрудника: " + employee.getId() +
//                    ", ФИО: " + employee.getFirstName() +
//                    " " + employee.getMiddleName() +
//                    " " + employee.getLastName() + ", Размер ЗП: " + employee.getSalary());
//        }
//    }
//
//    // Получить в качестве параметра число, и вывести:
//
//    // Всех сотрудников с ЗП ниже или равной заданной
//    static void printEmployeesWithSalaryLessThen(Employee[] employees, int salaryEdge) {
//        if (employees == null || employees.length == 0) {
//            throw new NullPointerException("Невозможно обнаружить сотрудников. Список сотрудников пуст.");
//        }
//        boolean isFind = false;
//        for (Employee employee : employees) {
//            if (employee.getSalary() <= salaryEdge) {
//                isFind = true;
//                System.out.println("ID сотрудника: " + employee.getId() +
//                        ", ФИО: " + employee.getFirstName() +
//                        " " + employee.getMiddleName() +
//                        " " + employee.getLastName() + ", Размер ЗП: " + employee.getSalary());
//            }
//        }
//        if (!isFind) {
//            System.out.println("Сотрудников с зарплатой ниже заданного значения не обнаружено.");
//        }
//    }
//
//    // Всех сотрудников с ЗП выше или равной заданной
//    static void printEmployeesWithSalaryMoreThen(Employee[] employees, int salaryEdge) {
//        if (employees == null || employees.length == 0) {
//            throw new NullPointerException("Невозможно обнаружить сотрудников. Список сотрудников пуст.");
//        }
//        boolean isFind = false;
//        for (Employee employee : employees) {
//            if (employee.getSalary() >= salaryEdge) {
//                isFind = true;
//                System.out.println("ID сотрудника: " + employee.getId() +
//                        ", ФИО: " + employee.getFirstName() +
//                        " " + employee.getMiddleName() +
//                        " " + employee.getLastName() + ", Размер ЗП: " + employee.getSalary());
//            }
//        }
//        if (!isFind) {
//            System.out.println("Сотрудников с зарплатой выше заданного значения не обнаружено.");
//        }
//    }

    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // Методы для генерации рандомных сотрудников, ну и просто забавы ради.
    static Employee createEmployee() {
        String firstName = createRandomString();
        String middleName = createRandomString();
        String lastName = createRandomString();
        int division = (int) (Math.random() * 4) + 1;
        int salary = (int) (Math.random() * 50000);
        return new Employee(firstName, middleName, lastName, division, salary);
    }

    static String createRandomString() {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append(getRandomLetter(true));
        int length = (int) (Math.random() * 10);
        for (int i = 0; i < length; i++) {
            stringBuffer.append(getRandomLetter(false));
        }
        return stringBuffer.toString();
    }

    static char getRandomLetter(boolean isUpperCase) {
        int i = (int) (64 + Math.random() * (122 - 64));
        char r = (char) i;
        if (isUpperCase) {
            if (Character.isLetter(r) && Character.isUpperCase(r)) {
                return r;
            } else {
                return getRandomLetter(isUpperCase);
            }
        } else {
            if (Character.isLetter(r) && Character.isLowerCase(r)) {
                return r;
            } else {
                return getRandomLetter(isUpperCase);
            }
        }


    }
}