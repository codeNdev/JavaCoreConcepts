package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Streams {
    public static void main(String[] args) {
//        Java8 key features
//        1. minimal code
//        2. functional programming
//
//        Ways to perform these features:
//        1. Lambda Expression
//        2. Streams
//        3. Date and Time API

//        Lambda Expression:
//        Lambda Expression is an anonymous function =>(no-name,no-access-modifier,no-return-type)
//        Thread t1=new Thread(new Task());
//        using Lambda Expression
//        Thread t2=new Thread(()->{
//            System.out.println("Run method Implemented Using Lambda Expression");
//        });// no-name, no-access-modifier, no-return-type(need to introduce an ->(arrow) on between)
//        Lambda Expression used to implement Functional Interface (abstract class/interface having only one abstract method)
        MathOperation sumOperation=(int a, int b) ->{
            return a+b;
        };
        MathOperation subtractOperation=(a,b)->a-b;
        int res=sumOperation.operation(1,2);
        System.out.println("The result of SumOperation is: "+res);

//        Predicate Functional Interface
        Predicate<Integer> isEven=x->x%2==0;
        System.out.println("The Number 10 is Even: "+isEven.test(10));

        System.out.println("Combining predicates Example");
        Predicate<String> isWordStartsWithA=(String x)->{
            return x.toLowerCase().startsWith("a");
        };
        System.out.println(isWordStartsWithA.test("Ankit"));
        Predicate<String> isWordEndingWithT=x->x.toLowerCase().endsWith("t");
        Predicate<String> andOperator =isWordStartsWithA.and(isWordEndingWithT);// both the conditions should be true for answer to be true
        System.out.println(andOperator.test("Ankit"));
        Predicate<String> orOperator=isWordStartsWithA.or(isWordEndingWithT); // Any condition true implies answer is true
        System.out.println("Applying and of both the predicates on the String: " +andOperator.test("Akshay"));
        System.out.println("Applying or of both the predicates on the String: " +orOperator.test("Akshay"));


        /**
         * Function Uses
         *
         */
        Function<Integer,Integer> doubleIt=(x)->{
            return 2*x;
        };
        System.out.println("Using apply method of Function functional-interface on a number: " + doubleIt.apply(10));
        Function<Integer,Integer> tripleIt=x->3*x;
        Function<Integer,Integer> oneAfterOther=doubleIt.andThen(tripleIt);
        /**
         * First doubtIt operates then tripleIt works in the andThen example below
         */
        System.out.println("andThen-composition of apply method of Function functional-interface on a number: " + doubleIt.andThen(tripleIt).apply(10));

        /**
         * First tripleIt operates then doubleIt works in the compose example below
         */
        System.out.println("compose-composition of apply method of Function functional-interface on a number: " + doubleIt.compose(tripleIt).apply(10));

        /**
         * Usage of Static methods of functional-interface
         */
        Function<Integer,Integer> identity=Function.identity();
        Integer ans=identity.apply(10);
        System.out.println(ans);

        /**
         * Consumer Functional Interface Usage
         */
        Consumer<Integer> print=x-> System.out.println(x);
        print.accept(10);
        Consumer<List<Integer>> printList=x->{
            for (Integer it:x){
                System.out.println(it);
            }
        };
        Consumer<List<Integer>> printAsString=x-> System.out.println(x.toString());
        printAsString.accept(Arrays.asList(1,2,3,4,5));
        printList.andThen(printAsString).accept(Arrays.asList(1,2,3,4,5));

        /**
         * Supplier
         */
        Supplier<String> giveHelloWorld=()->"Hello World!";
        System.out.println(giveHelloWorld.get());

        /**
         * Combined Example
         *
         */
        Predicate<Integer> predicate=x->x%2==0; // test weather the number is even
        Function<Integer,Integer> function=x->x*x;
        Consumer<Integer> consumer=x-> System.out.println(x);
        Supplier<Integer> supplier=()->100;
        if(predicate.test(supplier.get())){
            consumer.accept(function.apply(supplier.get()));
        }

        /**
         * Similarly we have
         * BiPredicate, BiConsumer, BiFunction
         */
        System.out.println("Using the Bi-Functional-Interfaces: ");
        BiPredicate<Integer,Integer> isSumEven =(a, b)->{
            return (a+b)%2==0;
        };
        System.out.println("Sum of both the Numbers is Even: "+ isSumEven.test(51,72));

        BiConsumer<Integer,String> printer=(a,b)->{
            System.out.println(a+ " "+b);
        };
        printer.accept(10,"Hello World");

        BiFunction<String,String,Integer> biFunction=(p,q)->(p+q).length();
        System.out.println(biFunction.apply("abc","def"));


//        Function replaced by UnaryOperator
        Function<Integer,Integer> f1r=x->(2*x); // when both the object types are same
        UnaryOperator<Integer> operator=x->(2*x);
//        BiFunction replaced by BinaryOperator
        BiFunction<Integer,Integer,Integer> biFunc2=(x,y)->x+y; // when all the object types are same
        BinaryOperator<Integer> biOperator=(x,y)->x+y;
        System.out.println(operator.apply(10));
        System.out.println(biOperator.apply(10,20));
//       Aram ke liye hai yeh dono
    }
}
//class Task implements Runnable{
//    @Override
//    public void run() {
//        System.out.println("Run method Implemented");
//    }
//}

class SumOperation implements MathOperation{

    @Override
    public int operation(int a, int b) {
        return a+b;
    }
}
interface MathOperation{
    int operation(int a,int b);
}
