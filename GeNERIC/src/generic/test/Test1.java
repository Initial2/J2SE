package generic.test;



/**
 * @author initial
 * @create 2021-03-06 15:53
 */

public class Test1<T> {
    T  age;
    //泛型类中的普通方法
    public  void  test1(T  num){
        this.age = num;
    }
    //静态泛型方法,也是可以的
    public  static  <E> void  test2(E name){
        System.out.println(name);
    }



    public void test(){
        //错误的方式
        //T[] array = new T[];   编译器报错

        //正确方法
       T[] array =  (T[]) new Object[10];
    }
}
class Test2{
    public static void main(String[] args) {
        Test1<String> stringTest1 = new Test1<>();
        /*String[] test = (String[]) stringTest1.test();
        test[0] = "123";
        System.out.println(test.getClass());
        System.out.println(test[0]);*/
    }

}
