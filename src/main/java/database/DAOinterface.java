package database;

import java.util.ArrayList;

public interface DAOinterface<T>{
	public ArrayList<T> selectAll();
	public T selectById(String O);
	public int insert(T t);
	public int insertAll(ArrayList<T> t);
	public int delete(T t);
	public int deleteAll(ArrayList<T> t);
	public int update(T t);
	
}