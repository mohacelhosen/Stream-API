import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1002,"Mohacel","CSE"));
        studentList.add(new Student(1003,"Adi","CSE"));
        studentList.add(new Student(1004,"Asadu","CSE"));
        studentList.add(new Student(1005,"Reznu","CSE"));

        Consumer<Student> accept = (x)-> System.out.println(x);
        studentList.forEach(accept);

        System.out.println("----------filter with first character of the name > 'A' ---------------");
        // whose name starting letter > 'A'
        Predicate<Student> test =(x)->{return x.getName().charAt(0)>'A';};
        studentList.stream().filter(test).forEach(accept);

        System.out.println("------------------------filter with name='mohacel' ----------------------");
        //to find is there have any object with name property is "mohacel"
        studentList.stream().filter(x->x.getName().equalsIgnoreCase("mohacel")).forEach(System.out::println);

        System.out.println("-----------------------------filter with odd id----------------------------");
        // print all object whose  id is odd
        studentList.stream().filter(x-> x.getId()%2==0).forEach(x-> System.out.println(x));

        System.out.println("------filter with even id and their name should be in Capital -------------");
        //print all the even id and their name should be capital
        studentList.stream()
                .filter(x->x.getId()%2!=0)
                .map(x->new Student(x.getId(), x.getName().toUpperCase(), x.getDepartment()))
                .forEach(System.out::println);





    }
}