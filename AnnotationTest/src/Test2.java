/**
 * @author initial
 * @create 2021-03-01 15:02
 */
public class Test2 {
    public static void main(String[] args) {
        /*
        定义变量,但是没有用.在IDEA中默认是灰色的. 这其实就是一种编译器警告.
        告诉你当前变量永远不会被使用
        */

        @SuppressWarnings({})
        int num = 10;
    }

}
