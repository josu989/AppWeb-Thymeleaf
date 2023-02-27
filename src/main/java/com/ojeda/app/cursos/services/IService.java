package com.ojeda.app.cursos.services;

import java.util.List;

import com.ojeda.app.cursos.models.Categoria;

public interface IService <T>{
	public List<T> getAll();
	public void save(T obj);
	public T getById(Long id);
	public void delete(Long id);
}
