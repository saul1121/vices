package com.app.vice.networking;


import java.util.List;


//generic and small repository
public interface GenericRepository<T> {

     T getById(int id);

     List<T> getAll();

    void save(T entity);

    void remove(T entity);

}