package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReference {
    public static void main(String[] args) {
          //    Method Reference:- Use method without invoking & in place of lambda expression
                List<String> brothers= Arrays.asList("Rituraj", "Rishikesh", "Ratnadeep");
                brothers.forEach(x-> System.out.println(x)); // lambda expression
                brothers.forEach(System.out::println); // method reference

          //    Constructor Reference
                List<MobilePhone> mobilePhones=brothers.stream().map(x->new MobilePhone(x)).collect(Collectors.toList());
                List<MobilePhone> mobilePhones2=brothers.stream().map(MobilePhone::new).toList();
//        System.out.println(mobilePhones2);
                System.out.println("Print the Mobile Phone Names: ");
                mobilePhones.forEach(x-> System.out.println(x.name));
                System.out.println("Print the Mobile Phone Names: ");
                mobilePhones2.forEach(x-> System.out.println(x.name));
    }
}
class MobilePhone{
    String name;

    public MobilePhone(String name) {
        this.name = name;
    }
}
