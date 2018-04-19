/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PJPA.Aula02.Ex02;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Filipe
 */
public interface DAO<T, I> {

    boolean insert(T t) throws SQLException;

    boolean remove(I i) throws SQLException;

    boolean update(T t) throws SQLException;

    T getById(I i) throws SQLException;

    List<T> findAll() throws SQLException;
}


