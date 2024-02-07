package src.edu.hogwarts.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

public abstract class Controller<T> {
    private ArrayList<T> list = new ArrayList<T>();

    public void add(T entity) {
        list.add(entity);
    }

    public void add(T[] entities) {
        Collections.addAll(list, entities);
    }

    public abstract T get(UUID id);

    public abstract ArrayList<T> getAll();

    public abstract void update(UUID id, T entity);

    public abstract void delete(UUID id);
}
