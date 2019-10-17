package repository;

import model.Product;

import java.util.List;

public interface GeneralRepository <E>{
    List<E> findALL();
    void add(E e);
    void update(int id, E e);
    void remove(int id);
    Product find(String name);
    void sortUp();
    void sortDown();
}
