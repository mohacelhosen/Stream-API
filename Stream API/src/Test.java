import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
       Employee employee1 =  new Employee(1002, "Mohacel", "dev",500.50);
       Employee employee2 =  new Employee(1003, "Asadu", "QA",400.50);
       Employee employee6 =  new Employee(1006, "Anaf", "QA",400.50);
       Employee employee3 =  new Employee(1004, "Reznu", "dev",450.50);
       Employee employee4 =  new Employee(1005, "Adi", "Network",440.50);
       Employee employee5 =  new Employee(1009, "Megh","Graphic",300.50);
       Employee employee8 =  new Employee(1008, "Aisha","Graphic",300.50);

       List<Employee> employeeList = new ArrayList<>();
       employeeList.add(employee1);
       employeeList.add(employee2);
       employeeList.add(employee3);
       employeeList.add(employee4);
       employeeList.add(employee5);
       employeeList.add(employee6);
       employeeList.add(employee8);

        System.out.println("________ printing all the employees ________");
        employeeList.forEach(x-> System.out.println(x));
//

        System.out.println("------------- print who works on 'Dev' ---------");
       List<Employee> empList = employeeList.stream().filter(x->x.getDepartment().equals("dev")).collect(Collectors.toList());
       empList.forEach(x-> System.out.println(x));
//
        System.out.println("--- who works on graphic depart increase their salary 100----------");
//
        Predicate<Employee> test =(x)->{ return  x.getDepartment().equalsIgnoreCase("graphic");};
        employeeList.stream()
                .filter(test)
                .map(x->new Employee(x.getId(), x.getName(),x.getDepartment(),x.getSalary()+100.00))
                .forEach(System.out::println);


        System.out.println("----------------- Group By Department-------------------------------");
        Map<String, List<Employee>> collect = employeeList.stream().collect(Collectors.groupingBy(x -> x.getDepartment()));
        collect.forEach((x,y)-> System.out.println(x+"= "+y));
//
        System.out.println("------------------------- Sorting by name -------------------------");
        employeeList.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);

        System.out.println("------------------------- Sorting by name in descending way -------------------------");
        employeeList.stream().sorted(Comparator.comparing(Employee::getName).reversed()).forEach(System.out::println);


        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("-------------------- Highest Salary in Each Department ----------------------------");
        // Group employees by department and find the one with the highest salary in each department
        Map<String, Optional<Employee>> highestSalaryByDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));

        // Display the result
        highestSalaryByDepartment.forEach((department, optionalEmployee) -> {
            System.out.println("Department: " + department);
            optionalEmployee.ifPresent(employee -> {
                System.out.println("Employee with the highest salary: " + employee.getName() + " - $" + employee.getSalary());
            });
            System.out.println();
        });

    }
}
