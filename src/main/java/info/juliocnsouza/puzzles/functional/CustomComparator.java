package info.juliocnsouza.puzzles.functional;

import java.util.List;
import java.util.stream.Collectors;

public class CustomComparator {
    public static List<Employee> sortEmployees(List<Employee> employees) {
        return employees.stream().sorted((e1, e2) -> {
            if (e1.age == e2.age) {
                return e1.name.compareTo(e2.name);
            }
            return e1.age - e2.age;

        }).collect(Collectors.toList());
    }

    public static class Employee {
        private String name;
        private int age;

        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "{" +
                    "name:'" + name + '\'' +
                    ", age:" + age +
                    '}';
        }
    }
}

