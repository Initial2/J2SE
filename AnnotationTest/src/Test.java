import java.util.Date;

/**
 * JDK三个基本注解之一, @Override的使用
 * @author initial
 * @create 2021-03-01 14:37
 */
@Deprecated
public class Test {
    public static void main(String[] args) {
        Person student = new Student();
        student.eat();
        student.walk();

    }
}


//定义父类Person
class Person{
    public Person() {
    }
    public void eat(){
        System.out.println("人会吃");
    }
    public void walk(){
        System.out.println("人会走");
    }
}

//定义子类Student
class  Student extends Person{

    @Override
    public void eat(){
        System.out.println("学生会吃");
    }


    //也可以不适用直接重写
    public void walk(){
        System.out.println("学生会走");
    }
}


