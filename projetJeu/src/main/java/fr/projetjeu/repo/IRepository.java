package fr.projetjeu.repo;

import java.util.List;
import java.util.Optional;

public interface IRepository<T, ID> {
	public List<T> findAll();
	public T findById(ID id);
	public void save(T entity);
	public void deleteById(ID id);
}