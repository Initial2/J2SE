package string.practice;

import java.util.Arrays;

/**
 * 对字符串中字符,进行自然排序
 *
 * @author initial
 * @create 2020-11-08 15:13
 */
public class Practice5 {

    /**
     * 先把字符串转成数组, 然后调用数组sort方法,进行排序.
     * 排序后,再把它转换回字符串. 去掉逗号之类的不要的符号
     *
     * @param needSortStr 需要排序的字符串
     * @return 返回排好序的字符串.
     */
    private static String sortStr(String needSortStr) {

        // 初始化结果
        String result = "";

        //避免空指针异常
        if (needSortStr.length() == 0) {
            return null;
        }
        char[] chars = needSortStr.toCharArray();
        Arrays.sort(chars);
        for (char x : chars) {
            result += x;
        }
        return result;

    }

    public static void main(String[] args) {
        String needSortStr = "bdaga1616";
        String sortStr = sortStr(needSortStr);
        System.out.println(sortStr);

    }
}
