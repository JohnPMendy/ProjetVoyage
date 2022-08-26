package fr.projetjeu.repo;

import java.util.List;
import java.util.Optional;

public interface IRepository<T> {
	public List<T> findAll();
	public T findById(int id);
	public void save(T entity);
	public void deleteById(int id);
}