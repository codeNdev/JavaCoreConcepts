package basic;

public class Basic {
    public static void main(String[] args) {
        long n=105;// implicit conversion
        System.out.println(n);
        boolean b=true;
        System.out.println(b);
//        to use number in binary format
        int binary=0b101;
        System.out.println(binary);

        int a=130;
        byte byt=(byte) a;
        System.out.println(byt); // while narrowing, it takes only the least significant bits, as many required

        /**
         * Opertors in java
         * 1. Arithmatic Operators
         * 2. Assignment Operators
         * 3. Relational/Comparison Operators
         * 4. Unary Operators
         * 5. Logical Operators
         *
         */


        /**
         * Conditionals in Java
         *
         */
        String gender="Male";
        if(gender.equalsIgnoreCase("male")){
            System.out.println("This person is a male");
        }else{
            System.out.println("This person is a female");
        }
        int age=10;
        if(age<6){
            System.out.println("You are an Infant");
        }else if (age<18){
            System.out.println("You are in adolescence");
        }else {
            System.out.println("You are Mature");
        }
    }
}
