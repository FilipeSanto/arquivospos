/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Filipe
 */
public interface DAO<T, I>{
    
    T insert(T t) throws SQLException;

	int remove(I i) throws SQLException;

	int update(T t) throws SQLException;

	T findById(I i) throws SQLException;

	List<T> findAll() throws SQLException;
    
}
