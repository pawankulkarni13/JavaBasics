package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeStreamDemo {
    public static void main(String[] args) {
        List<Employee> employees = dataSetup();

        System.out.println("Employees " + employees);

        Map<Integer, List<Employee>> employeeGradeMap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGrade));

        System.out.println("Grouping based on Grade \n" + employeeGradeMap);

        Map<Integer, List<String>> employeeNameListGroupedByGrade = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGrade,
                        Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println("Grouping and Mapping based on Grade \n" + employeeNameListGroupedByGrade);

        Map<Integer, List<Integer>> employeeAgeListGroupedByGrade = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGrade,
                        Collectors.mapping(Employee::getAge,
                                Collectors.toList())));
        System.out.println("Grouping and Mapping based on Age \n" + employeeAgeListGroupedByGrade);

        Map<Integer, Long> employeeCountAsLongBasedOnGrade = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGrade,
                        Collectors.counting()));
        System.out.println("Grouping and Counting based on Grade \n" + employeeCountAsLongBasedOnGrade);

        employeeCountAsLongBasedOnGrade.values().stream().max(Comparator.naturalOrder());
        Map<Integer, Integer> employeeCountAsIntegerBasedOnGrade = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGrade,
                        Collectors.collectingAndThen(Collectors.counting(),
                                Long::intValue)));
        System.out.println("Grouping and Counting based on Grade \n" + employeeCountAsLongBasedOnGrade);
    }

    private static List<Employee> dataSetup() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(3, "Pawan", 31));
        employeeList.add(new Employee(3, "Naveen", 31));
        employeeList.add(new Employee(3, "Sandeep", 32));
        employeeList.add(new Employee(1, "Shashi", 54));
        employeeList.add(new Employee(1, "Mahadev", 36));
        employeeList.add(new Employee(2, "Mahesh", 26));
        employeeList.add(new Employee(2, "Raju", 25));
        return employeeList;
    }

}
