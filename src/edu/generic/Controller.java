package src.edu.generic;

public interface Controller<T> {
    public void add(T entities);
    public void add(T[] entity);
    public T get(String id);
    public void update(String id, T entity);
    public void delete(String id);
}
