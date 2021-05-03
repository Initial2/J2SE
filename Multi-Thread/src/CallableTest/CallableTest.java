package CallableTest;

import java.util.concurrent.Callable;

/**
 * 创建Callable接口的实现类, 实现多线程创建的第三种方式 该方法为, JDK 5.0 之后新增的方法
 *
 * @author initial
 * @create 2020-11-06 17:24
 */
public class CallableTest implements Callable {

  /*
  重写call方法,把需要的操作写在里面 , call方法会抛出异常.
  该方法有返回值, 返回值为Object类型
  */
  @Override
  public Object call() throws Exception {

    /* 求100以内所有的偶数,并且打印求和 */
    int sum = 0;
    for (int i = 1; i <= 100; i++) {
      if (i % 2 == 0) {
        System.out.println(i);
        sum += i;
      }
    }
    return sum; // 返回总和
  }
}
