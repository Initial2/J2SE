package collection.CollectionsTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author initial
 * @create 2021-03-05 16:35
 */
public class CopyTest {

    @Test
    public void  test1(){
        List src = new ArrayList();
        src.add(1);
        src.add(2);
        src.add(3);

        //保证dest的size()一定 >= src.size()
        List dest = Arrays.asList(new Object[src.size()]);
        Collections.copy(dest,src);
        System.out.println(dest);

    }
}
