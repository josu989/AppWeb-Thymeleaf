package com.ojeda.app.cursos.dao;

import org.springframework.data.repository.CrudRepository;

import com.ojeda.app.cursos.models.Categoria;


public interface ICategoriasDao extends CrudRepository<Categoria, Long>{

}
