package sandard.io.test;

import java.io.*;

/**从键盘获取字符串,写入到data.txt文件中.  输入e或者exit则终止输入.
 * @author initial
 * @create 2021-03-09 16:55
 */
public class Exer {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            //1. 创建输入流.输出流 因为System.in是 字节输入流. 所以给他做一个转换
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            //重新设置System.out的输出路径.
            System.setOut(new PrintStream("C:\\Users\\Inital\\Desktop\\data.txt"));
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);


            //2. 创建处理流
            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            //3. 处理
            while(true){
                //一次读取一行
                String s = bufferedReader.readLine();
                if ("e".equalsIgnoreCase(s) || "exit".equalsIgnoreCase(s)){
                    break;
                }else{
                    bufferedWriter.write(s);
                    bufferedWriter.newLine(); // 自动添加回车
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 关闭流
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bufferedWriter != null){
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }
}
