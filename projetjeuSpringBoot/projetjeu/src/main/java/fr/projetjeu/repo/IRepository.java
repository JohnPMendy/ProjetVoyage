package fr.projetjeu.repo;

import java.util.List;

public interface IRepository<T> {
	public List<T> findAll();
	public T findById(int id);
	public void save(T entity);
	public void deleteById(int id);
}