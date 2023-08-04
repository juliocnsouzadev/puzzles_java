package info.juliocnsouza.puzzles.functional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapEmployees {
    public static Map<Integer, List<Employee>> mapEmployees(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getId));
    }

    public static class Employee {
        private int id;
        private String name;
        private double salary;


        public Employee(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "{" +
                    "id:" + id +
                    ", name:'" + name + '\'' +
                    ", salary:" + salary +
                    '}';
        }
    }
}

