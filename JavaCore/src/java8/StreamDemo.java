package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        /**
         * Stream:
         * Feature Introduced in java 8
         * process collections of data in a functional and declarative manner
         * Simplify data processing
         * Embrace functional programming
         * Improve readability and maintainability
         * Enable Easy Parallelism
         *
         *
         * what is stream?
         * a sequence of elements supporting various operations in a functional and declarative manner
         *
         * How to use streams ?
         * Source, Intermediate Operations and terminal Operation
         */

        List<Integer> numbers = Arrays.asList(1,2,3,4,5); // source
//        To convert list into streams
        Stream<Integer> stream=numbers.stream();
//        Find the even numbers in the list and their count
//        using traditional way
        int cnt=0;
        for(int i=0;i<numbers.size();i++){
            if(numbers.get(i)%2==0){
                cnt++;
            }
        }
        System.out.println("The count of even numbers is : "+ cnt);
//        Using stream
        List<Integer> evens= numbers.stream().filter(x->x%2==0).toList();
        long count= numbers.stream().filter(x->x%2==0).count();
        for(int even:evens){
            System.out.println(even);
        }
        System.out.println("Count of even numbers: "+ count);


        /**
         * Creating streams:
         * 1. from collections
         * collection_object_name.stream()
         *
         * 2. from arrays
         * Integer [] arr= new Integer[5];
         *
         * Stream<Integer> arrStream=Arrays.stream(arr);
         *
         * 3. Using Stream.of()
         *
         * 4. Infinite Stream
         *
         */
        Integer [] arr= new Integer[5];
        System.out.println(arr.length);
        for(int i=0;i<arr.length;i++){
            arr[i]=i;
            System.out.println(arr[i]);
        }
        Stream<Integer> arrStream=Arrays.stream(arr);
//      Using Stream.of()
        Stream<Integer> arrStream2 = Stream.of(1,2,4,6,7);
//        Infinite stream
        Stream.generate(()->1); // creates an infinite stream of 1's
        List<Integer> ls= Stream.iterate(1,x->x+1).limit(100).toList(); // creates a list of maxSize given starting from 1 value according to the lambda function defined
        System.out.println(ls.toString());

        /**
         * Intermediate Operations:
         * 1. Intermediate operations converts a stream into another stream
         * 2. They are lazy, means they don't execute until a terminal operation is invoked
         */
        List<String> friends=Arrays.asList("Rituraj", "Shibam", "Suraj","Mohit","Nikhil","Sanjeeb","Sambit",new String("Shibam"));
        /**
         * 1. filter: used to filter out elements from the stream
         */
        Stream<String> friendsStreamStartWithS=friends.stream().filter(x->x.startsWith("S"));

//        Can't use enhanced for loop with Stream
//        for (String s:friendsStreamStartWithS){
//            System.out.println(s);
//        }
        friendsStreamStartWithS.forEach(System.out::println);

        /**
         * 2. map
         */
        Stream<String> friendsInUpperCase=friends.stream().map(String::toUpperCase);

        /**
         * 3. sorted
         */
        System.out.println(friends);
        Stream<String> sortedNames=friends.stream().sorted();
        List<String> sortedNamesUsingComparator=friends.stream().sorted((a,b)->{
            if(a.length()>b.length()){
                return 1;
            }else{
                if(a.length()==b.length()){
                    return 0;
                }
                return -1;
            }
        }).collect(Collectors.toList());
        System.out.println(sortedNamesUsingComparator);
        List<String> sortedNamesInTermsOfLength = friends.stream()
                .sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
        System.out.println(sortedNamesInTermsOfLength);

        /**
         * 4. distinct
         */
        List<String> distinctNamesStartingWithS = friends.stream()
                .filter(x->x.toLowerCase().startsWith("s")).distinct().toList();
        System.out.println(distinctNamesStartingWithS);

        /**
         * 5. limit
         */
        List<Integer> lists=Stream.iterate(1,x->x+1).limit(100L).toList();
        System.out.println(lists);
        /**
         * 6. skip
         */
        List<Integer> skip_lists=Stream.iterate(1,x->x+1).skip(10L).limit(100L).toList();
        System.out.println(skip_lists);
    }

}
