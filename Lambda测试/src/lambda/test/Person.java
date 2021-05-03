package lambda.test;

/**
 * @author initial
 * @create 2021-03-16 16:12
 */
public class Person {
    public String name;
    public int age;

    public Person() {
    }

    public Person(String name){
        this.name = name;
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
