package string.practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * 题目要求:
 *      模拟一个trim()方法,去掉给定一个字符串两端的空格
 * @author initial
 * @create 2020-11-08 12:41
 */
public class Practice1 {

    public static String trimTest(String str) {
         /*
            无限循环判断,如果该字符串首个元素是空格,就把首个空格去掉.
            直到该字符串不是以空格开头的
         */
        while (true) {
            if (str.indexOf(" ") == 0) {
                str = str.substring(1);
            } else {
                break;
            }
        }

        /*
        现在的字符串开头已经没有空格了, 现在对结尾进行操作.
         */
        while (true) {
            if (str.lastIndexOf(" ") == str.length() - 1) {
                str = str.substring(0, str.length() - 1);
            } else {
                break;
            }
        }
        // 最后的字符串, 开头和结尾都没有空格了.
        return str;

    }
    public static void main(String[] args) {

        // 从键盘获取一行字符串,处理后打印
        System.out.println(trimTest(new Scanner(System.in).nextLine()));


    }
}
