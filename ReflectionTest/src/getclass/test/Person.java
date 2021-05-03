package getclass.test;

/**
 * @author initial
 * @create 2021-03-11 17:15
 */
public class Person extends Animal<String> {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String showName(String name){
        this.name = name;
        System.out.println("我的名字是:"+this.name);
        return name;
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

