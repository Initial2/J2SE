package collection.exer;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author initial
 * @create 2021-03-04 14:56
 */
public class Test {

    public static void main(String[] args) {

        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                    int p1year = o1.getBirthDay().getYear();
                    int p2year = o2.getBirthDay().getYear();
                    if (p1year == p2year){
                        if (o1.getBirthDay().getMonth() == o2.getBirthDay().getMonth() ){
                                if (o1.getBirthDay().getDay() == o2.getBirthDay().getDay()){
                                    return 1;
                                }else{
                                    return Integer.compare(o1.getBirthDay().getDay(),o2.getBirthDay().getDay());
                                }
                        }else{
                            return Integer.compare(o1.getBirthDay().getMonth(),o2.getBirthDay().getMonth());
                        }
                    }else{
                        return Integer.compare(p1year,p2year);
                    }
                }


        };

        TreeSet<Employee> treeSet = new TreeSet<Employee>();
        treeSet.add(new Employee("Arc",20,new MyDate(2020,11,5)));
        treeSet.add(new Employee("Borax",40,new MyDate(1999,1,5)));
        treeSet.add(new Employee("Curse",10,new MyDate(1999,1,5)));
        treeSet.add(new Employee("Marry",35,new MyDate(2001,9,23)));
        treeSet.add(new Employee("Jon",70,new MyDate(2003,12,5)));

        for (Employee employee : treeSet) {
            System.out.println(employee);
        }

    }
}
