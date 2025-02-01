package java8;

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
