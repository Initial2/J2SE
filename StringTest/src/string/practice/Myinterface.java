package string.practice;

/**
 * @author initial
 * @create 2021-03-17 22:07
 */
public interface Myinterface {
        
        //JDK7中 可以定义的:
        //静态常量
        public static  final String name = "abacd";
        //抽象方法
        public abstract void abstractMethod();
    
        //JDK8 新增可以定义的
        //静态方法  注意: 静态方法,只能接口自己调用. 它的实现类没法用
        public static void staticMethod() {
            System.out.println("这是一个静态方法");
        }
    
        // 默认方法
        public default void defaultMethod() {
            System.out.println("这是一个默认方法");
        }
        
        //JDK9 新增可以定义的
        //私有方法   注意: 私有方法只能用在当前接口中
        private void privateMethod(){
            System.out.println("这是一个私有方法");
        }
}
