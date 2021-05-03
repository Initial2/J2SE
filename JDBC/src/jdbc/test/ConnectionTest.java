package jdbc.test;

import java.sql.*;

/**
 * JDBC连接.
 * 以及执行简单的查询语句.
 *
 * @author initial
 * @create 2020-11-09 16:54
 */
public class ConnectionTest {




    public static void main(String[] args) {
        /*
            声明对象,赋初始值null,方便以后使用.
         */
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        // 数据库中的表名.
        String tableName = "studentinformation";
        //数据库端口号
        int port = 3306;
        // 连接数据库需要用到的url
        String url = "jdbc:mysql://localhost:"+port+"/" + tableName + "?serverTimezone=UTC";
        // 数据库用户名 用户密码
        String userName = "root";
        String userPassWord = "173836";

        // 需要执行的sql语句. 可以自己定义
        String sql = "Select *  From student";

        /*    首先加载jdbc驱动.  */
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("驱动加载失败!");

        }

        try {
            // 建立数据库连接
            connection = DriverManager.getConnection(url, userName, userPassWord);

            // 创建语句对象
            statement = connection.createStatement();

            //获取执行sql语句后的结果
            resultSet = statement.executeQuery(sql);

            /*
                读取操作,首先判断获取的结果.如果有下一个,就给他取出来. 没有就结束.
             */
            while (resultSet.next()) {
                // 获取查询后的结果中, Sname那一列的属性值.
                System.out.println(resultSet.getString("Sname"));
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {

            // 最后要把数据库关掉  注意,关闭顺序倒着关.  从后往前关.
            //关之前先做判断,避免空指针异常
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }



    }
}
