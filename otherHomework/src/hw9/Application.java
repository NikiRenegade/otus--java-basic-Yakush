package hw9;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

    }
    public static List<Integer> generateList(int min, int max) {
        List<Integer> list = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            list.add(i);
        }
        return list;
    }

    public static int sumNumbersGreaterFive(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            if (number > 5) {
                sum += number;
            }
        }
        return sum;
    }
    public static void changeAllNumbersToValue(int value, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
           list.set(i, value); ;
        }
    }
    public static void incrementAllNumbersToValue(int incrementValue, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + incrementValue);
        }
    }

    public static List<String> getEmployeeNames(List<Employee> employees) {
        List<String> names = new ArrayList<>();
        for (Employee employee : employees) {
            names.add(employee.getName());
        }
        return names;
    }

    public static List<Employee> filterEmployeeByMinAge(List<Employee> employees, int minAge) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getAge() >= minAge) {
                result.add(employee);
            }
        }
        return result;
    }

    public static boolean isAverageAgeGreaterThanMinAverageAge(List<Employee> employees, double minAverageAge) {
        double totalAge = 0;
        for (Employee employee : employees) {
            totalAge += employee.getAge();
        }
        double averageAge = totalAge / employees.size();
        return averageAge > minAverageAge;
    }

    public static Employee getYoungestEmployee(List<Employee> employees) {
        Employee youngestEmployee = employees.get(0);
        for (Employee employee : employees) {
            if (employee.getAge() < youngestEmployee.getAge()) {
                youngestEmployee = employee;
            }
        }
        return youngestEmployee;
    }
}
