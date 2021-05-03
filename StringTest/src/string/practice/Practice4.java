package string.practice;

/**
 * 题目要求:
 * 获取两个字符串最大相同子串.
 *
 * @author initial
 * @create 2020-11-10 12:50
 */
public class Practice4 {

    /**
     * @param str1 给定字符串1
     * @param str2 给定字符串2
     */
    private static String getMaxSameStr(String str1, String str2) {
        String maxLengthStr;
        String minLengthStr;
        int minStrLength;

        // 确定一下长短字符串.
        if (str1.length() > str2.length()) {
            maxLengthStr = str1;
            minLengthStr = str2;
        } else {
            maxLengthStr = str2;
            minLengthStr = str1;
        }

        // 先做判断,看看长的字符串是否包含短的. 如果包含了,最大相同字串就是小的.
        if (maxLengthStr.contains(minLengthStr)) {
            return minLengthStr;

        }
        /*  如果不包含,就开始一步一步算
         * 该方法把minStr的所有子串拿出来与maxStr进行对比.
         * 子串长度每次-1. 所以如果匹配到,肯定是最长的相同字串.
         *  */
        minStrLength = minLengthStr.length();
        for (int i = 0; i < minStrLength; i++) {
            for (int x = 0, y = minStrLength - i; y <= minStrLength; x++, y++) {
                String subStr = minLengthStr.substring(x, y);
                if (maxLengthStr.contains(subStr)) {
                    return subStr;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "efg";

        String maxSameStr = getMaxSameStr(str1, str2);
        System.out.println("最大相同字符串为" + maxSameStr);

    }

}
