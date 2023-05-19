import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
       Employee employee1 =  new Employee(1002, "mohacel", "dev",500.50);
       Employee employee2 =  new Employee(1003, "Asadu", "QA",400.50);
       Employee employee3 =  new Employee(1004, "Reznu", "dev",450.50);
       Employee employee4 =  new Employee(1005, "Adi", "Network",440.50);
       Employee employee5 =  new Employee(1009, "megh","Graphic",300.50);

       List<Employee> employeeList = new ArrayList<>();
       employeeList.add(employee1);
       employeeList.add(employee2);
       employeeList.add(employee3);
       employeeList.add(employee4);
       employeeList.add(employee5);

        System.out.println("________ printing all the employees ________");
        employeeList.forEach(x-> System.out.println(x));


        System.out.println("------------- print who works on 'Dev' ---------");
       List<Employee> empList = employeeList.stream().filter(x->x.getDepartment().equals("dev")).collect(Collectors.toList());
       empList.forEach(x-> System.out.println(x));

        System.out.println("--- who works on graphic depart increase their salary 100----------");

        Predicate<Employee> test =(x)->{ return  x.getDepartment().equalsIgnoreCase("graphic");};
        employeeList.stream()
                .filter(test)
                .map(x->new Employee(x.getId(), x.getName(),x.getDepartment(),x.getSalary()+100.00))
                .forEach(System.out::println);
    }
}
