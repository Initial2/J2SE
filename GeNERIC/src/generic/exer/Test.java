package generic.exer;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author initial
 * @create 2021-03-07 15:43
 */
public class Test {
    public static void main(String[] args) {
        User user = new User(9527,18,"唐伯虎");
        User user1 = new User(9527,33,"唐伯虎");
        DAO<User> dao = new DAO<>();
        dao.save("1",user);
        dao.save("2",new User(3399,21,"giaoge"));
        dao.get("1");


        dao.update("1",user1);
        dao.get("1");
        List<User> list = dao.list();
        for (User user2 : list) {
            System.out.println(user2);
        }


    }

}
