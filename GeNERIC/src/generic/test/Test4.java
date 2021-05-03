package generic.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author initial
 * @create 2021-03-07 14:45
 */
public class Test4 {
    @Test
    public void test1(){
        List<? extends  Father>  list1 = new ArrayList<>();
        List<?  super  Father>  list2 = new ArrayList<>();

        List<Son> son = new ArrayList<>();
        List<Father> father = new ArrayList<>();
        List<GrandFather> grandFather = new ArrayList<>();


        /*
        <? extends  Father>表示  ? <= Father  也就是最大可以装下一个Father类.
         Son虽然是 Father的子类.  但是Son 和 ? 之前不确定谁大谁小.  万一 ? 比 Son类还要小
         那么,Son就是?的父类,  ? = Son就行不通了
         因为Son都不确定放不下了   所以Father和GrandFather就更不用说了
         */
        /*list1.add(new Son());
        list1.add(new Father());
        list1.add(new GrandFather())*/;



/*
        list1 = son;   //正确  son < father
        list1 = father; //正确   father <= father
        // list1 = grandFather; // 不可以,超出了范围 <= Father类

       // list2 = son;  //不可以,超出范围了必须是>=Father的类
        list2 = father;   //正确  father >= father
        list2 = grandFather; //正确  grandfather >=  father*/


        /*
            因为 <?  super  Father>  即 ? >= Father 代表了List中最小可以装下一个 Father类.
            所以Father和Son都可以被添加
         */
        list2.add(new Father());
        list2.add(new Son());

        //但是因为 GrandFather > Father  所以系统不能确定是否能放下GrandFather
        // 所以不可添加
        //list2.add(new GrandFather());




        /*
            可以读取,但是读取类型是Father,因为<? extends  Father> 就代表了这里面所有的元素
            都会是Father这个类的子类. 所以使用Father这个类就可以包含所有的子类.
         */



        father.add(new Father());
        list2 = father;
        Object object = list2.get(0);
        /*
               为什么使用Object类型接收返回值呢.
               因为 <?  super  Father> 是 >= Father类
               而Object类是所有类的父类. 所以拿Object类就可以包含所有
               >= Father类 的元素了
         */


    }

}

class Son extends Father{
    public Son() {
    }
}

class Father extends  GrandFather{
    public Father() {
    }
}

class GrandFather{
    public GrandFather() {
    }
}