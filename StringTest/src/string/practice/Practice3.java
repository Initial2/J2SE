package string.practice;

import java.util.Scanner;

/**
 * 题目要求:
 * 给定一个字符串,计算在另一个字符串当中出现的次数.
 *
 * @author initial
 * @create 2020-11-08 14:17
 */
public class Practice3 {

    /**
     * 实现方法1, 使用contains()方法来实现计算
     * @param targetStr  给定目标字符串
     * @param needCountStr   需要计算的字符串
     */
    private static void method1(String targetStr, String needCountStr) {
        // 初始化次数
        int count = 0;

        /*
        只要targetStr目标字符串还包含,需要计算的字符串,就一直运行.
         */
        while (targetStr.contains(needCountStr)) {
            /*如果包含,就删去第一个匹配到的needCountStr.
            把目标字符串修改为替换为空.
            然后count+1.
             */
            targetStr = targetStr.replaceFirst(needCountStr, "");
            count += 1;
        }
        System.out.println(needCountStr + "出现的次数:" + count);
    }

    /**
     * 方法2: 使用indexOf()方法实现计算.
     * @param targetStr  给定目标字符串
     * @param needCountStr 需要计算的字符串
     */
    private static void method2(String targetStr, String needCountStr) {
        /*
           @param targetStrLength 目标字符串长度
         * @param needCountStrLength  需要计算的字符串长度
         * @param index 索引位置
         * @param count 出现次数
         */
        int count = 0;
        int targetStrLength = targetStr.length();
        int needCountLength = needCountStr.length();
        int index = 0;

        if (targetStrLength < needCountLength) {
            System.out.println("无法计算,目标字符串长度小于需要计算的字符串.");
        } else {
            /*
            首先index从0开始, 然后targetStr.indexOf(needCountStr,index)开始获取第一次
            出现的needCountStr的索引.  获取之后,次数+1. 且index从第一次出现的索引,往后增加
            needCountLength. 这样下次再进行indexOf判断, index的值就是从出现相同字符串的后面那一位开始.
            就可以避免重复计算之前已经出现过得字符串了,
             */
            while ((index = targetStr.indexOf(needCountStr, index)) != -1) {
                count++;
                index += needCountLength;
            }
        }
        System.out.println(needCountStr + "出现的次数为:" + count);


    }

    public static void main(String[] args) {

        System.out.println("给定源字符串");
        Scanner input = new Scanner(System.in);
        String targetStr = input.next();

        System.out.println("给定需要计算的字符串");
        String needCountStr = input.next();

        // 方法1
        //method1(targetStr, needCountStr);

        //方法2
        method2(targetStr, needCountStr);

    }


}
