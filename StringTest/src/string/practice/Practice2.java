package string.practice;


import java.util.Scanner;

/**
 * 题目要求:
 * 将一个字符串进行翻转, 反转的部分需要指定. 不是全部翻转.
 *
 * @author initial
 * @create 2020-11-08 13:18
 */
public class Practice2 {

    /**
     * 通过拆分,把字符串拆成三个部分,然后对中间翻转部分进行处理. 最后再拼接起来.
     * 该方法不足之处:
     * 每次把数组元素拼接到字符串后面时,都回建一个新的字符串. 效率比较低
     * 且如果字符串比较长的话,就非常占用空间.
     *
     * @param mainStr 给定字符串
     * @param start   翻转开始位置
     * @param end     翻转结束位置
     */
    private static void method1(String mainStr, int start, int end) {

        //把字符串分成三个部分, 首部分, 需要反转的部分, 尾部分.
        //首部分  从开头到需要修改的前面
        String headStr = mainStr.substring(0, start);

        //需要反转的部分. 因为区间是左闭右开[start,end) . 指定的end其实是截不到的 所以+1

        String needReverseStr = mainStr.substring(start, end + 1);

        // 结尾的部分 左闭右开[start,end), 开始位置是可以取到的. 所以开始位置要+1 防止截重.
        String endStr = mainStr.substring(end + 1);

        //把需要反转的部分转换成char 数组
        char[] chars = needReverseStr.toCharArray();
        // 倒着把这个数组的元素拼接到headStr后面
        for (int i = chars.length - 1; i >= 0; i--) {
            headStr = headStr + chars[i];
        }
        // 第三部分,把尾巴加上
        System.out.println(headStr + endStr);

    }

    /**
     * 使用StringBuilder 中的reverse()方法 对需要反转的字符串进行翻转,
     * 然后再拼接  这个方法比方法1好在:
     * 总共就三个字符串. 把需要翻转的翻转完在和其他俩拼接上就ok了
     * 效率比方法1高.
     *
     * @param mainStr 给定字符串
     * @param start   起始位置
     * @param end     结束位置
     */
    private static void method2(String mainStr, int start, int end) {
        String headStr;
        StringBuilder needReverseStr;
        String endStr;
        StringBuilder stringBuilder;
        String result;

        stringBuilder = new StringBuilder(mainStr);

        // 照旧把mainStr分成三部分
        headStr = stringBuilder.substring(0, start);
        needReverseStr = new StringBuilder(stringBuilder.substring(start, end + 1));
        endStr = stringBuilder.substring(end + 1);

        // 翻转
        needReverseStr.reverse();

        //拼接
        result = headStr + needReverseStr + endStr;

        System.out.println(result);
    }


    public static void main(String[] args) {

        // 获取字符串
        System.out.println("输入字符串");
        Scanner input = new Scanner(System.in);
        String mainStr = input.next();

        // 获取需要反转的部分
        System.out.println("输入需要反转的部分:开始    结尾");
        int start = input.nextInt();
        int end = input.nextInt();

        //method1(mainStr,start,end);
        method2(mainStr, start, end);

    }


}
