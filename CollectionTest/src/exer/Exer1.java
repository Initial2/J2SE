package exer;

import java.util.*;

/**
 * 从键盘随机输入10个数存到list当中,  按照倒序,和从大到小排列打印
 *
 * @author initial
 * @create 2021-03-05 17:10
 */
public class Exer1 {

    public static void main(String[] args) {
        //按照倒序
        List list = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            list.add(scanner.nextInt());
        }
        Collections.reverse(list);
        System.out.println(list);

        //按照从大到小
       /* Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Integer && o2 instanceof Integer) {
                    Integer num1 = (Integer) o1;
                    Integer num2 = (Integer) o2;
                    return -Integer.compare(num1, num2);
                } else {
                    throw new RuntimeException("输入类型不是整数");
                }
            }
        };
        List list = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            list.add(scanner.nextInt());
        }
        Object[] objects = list.toArray();
        Arrays.sort(objects, comparator);

        for (Object obj :
                objects) {
            System.out.println(obj);
        }*/

    }

}
