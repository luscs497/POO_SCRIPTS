package tecinfo.poo.model.dao;

import java.util.List;

public interface Dao<T> { //generic
    Object get(String n);
    List<T> getAll();
    int save(T t);
    boolean update(T t);
    boolean delete(T t);
}