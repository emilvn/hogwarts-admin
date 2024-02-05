package src.edu.generic;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Controller<T> {
    private ArrayList<T> list = new ArrayList<T>();

    public void add(T entity){
        list.add(entity);
    }
    public void add(T[] entities){
        Collections.addAll(list, entities);
    }
    public abstract T get(String id);
    public abstract ArrayList<T> getAll();
    public abstract void update(String id, T entity);
    public abstract void delete(String id);
}
