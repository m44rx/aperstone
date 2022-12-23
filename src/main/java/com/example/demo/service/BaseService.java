package com.example.demo.service;

import java.util.List;

public interface BaseService<T> {

    T guardar(T t);

    boolean eliminarPorId(int id);

    T actualizar(int id, T t);

    T buscarPorId(int id);

    List<T> personas();
}
