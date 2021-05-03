package exer;

import java.util.*;

/**
 * 录入学生的姓名和成绩, 自动输出前三名的姓名和成绩
 * @author initial
 * @create 2021-03-05 17:28
 */
public class Exer2 {

    public static void main(String[] args) {
        String name;
        int scroe;

        //定制排序方法,从大到小
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Integer && o1 instanceof Integer){
                    Integer num1 = (Integer) o1;
                    Integer num2 = (Integer) o2;
                    return -Integer.compare(num1, num2);
                } else {
                    throw new RuntimeException("输入类型不是整数");
                }
            }

        };

        TreeMap treeMap = new TreeMap(comparator);
        Scanner scanner = new Scanner(System.in);

        //获取学生的姓名和成绩 添加到TreeMap中
        for (int i = 0; i < 5; i++) {
            System.out.println("请输入姓名:");
            name = scanner.next();
            System.out.println("请输入成绩:");
            scroe = scanner.nextInt();
            treeMap.put(scroe,name);
        }

        //获取前三名的信息
        System.out.println("前三名为: ");
        Set entrySet = treeMap.entrySet();
        Iterator iterator = entrySet.iterator();
        for (int i = 0; i < 3; i++) {
            if(iterator.hasNext()){
                Object next = iterator.next();
                Map.Entry info = (Map.Entry) next;
                int key = (int)info.getKey();
                String value = (String) info.getValue();
                System.out.println(value+" : "+key);
            }


        }
    }
}
