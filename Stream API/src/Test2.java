import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1002, "Mohacel", "dev",500.50));
        employeeList.add(new Employee(1003, "Asadu", "QA",400.50));
        employeeList.add(new Employee(1006, "Anaf", "QA",400.50));
        employeeList.add(new Employee(1004, "Reznu", "dev",450.50));
        employeeList.add(new Employee(1005, "Adi", "Network",440.50));
        employeeList.add(new Employee(1009, "Megh","Graphic",300.50));
        employeeList.add(new Employee(1008, "Aisha","Graphic",300.50));

//        //sort according to their name in descending order
        employeeList.stream().sorted(Comparator.comparing(Employee::getName).reversed()).forEach(System.out::println);

        //group the employee according their department
        Map<String, List<Employee>> collectByDepartment = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        collectByDepartment.forEach((department, employee)->{
            System.out.println("Department: "+department);
            employee.forEach(System.out::println);
        });

//        //how many employee has each department
//        Map<String, Long> employeeCountByDepartment  = employeeList.stream()
//                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
//
//        employeeCountByDepartment.forEach((department, count) -> {
//            System.out.println("Department: " + department);
//            System.out.println("Number of employees: " + count);
//            System.out.println();
//        });

    }
}
