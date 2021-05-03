package generic.exer;

import java.util.*;

/**
 * @author initial
 * @create 2021-03-07 15:33
 */
public class DAO<T>{
    Map<String,T>  map = new HashMap<>();


    public DAO() {
    }

    public DAO(Map<String, T> map) {
        this.map = map;
    }

    public void save(String id, T entry){
        this.map.put(id,entry);
    }

    public void get(String id){
        T t = map.get(id);
        System.out.println(id+"----->"+t);
    }

    public void update(String id ,T entry){
        this.map.put(id, entry);
    }
    public List<T> list(){
        return new ArrayList<>(this.map.values());

    }
    public void delete(String id){
        this.map.remove(id);
    }
}
