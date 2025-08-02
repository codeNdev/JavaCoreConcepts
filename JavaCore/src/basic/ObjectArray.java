package basic;
class Student{
    int rollNo;
    String name;
    String address;
    public Student(int rollNo,String name){
        this.rollNo=rollNo;
        this.name=name;
    }
}
public class ObjectArray {
    public static void main(String[] args) {
        Student students[]=new Student[5];
        for(int i=0;i<students.length;i++){
            students[i]=new Student(i+1,"student"+(i+1));
        }
        for(Student s:students){
            System.out.println(s.rollNo+" "+s.name);
        }
    }
}
