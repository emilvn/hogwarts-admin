package src.edu.hogwarts.application;

import src.edu.hogwarts.data.House;
import src.edu.hogwarts.data.HouseName;

public abstract class HogwartsController<T> {

    public HogwartsController() {

    }


    public abstract void add(T entity);
    public abstract void add(T[] entities);
    public abstract T get(String id);
    public abstract T[] getAll();
    public abstract void update(String id, T entity);
    public abstract void delete(String id);
}
