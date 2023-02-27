package com.ojeda.app.cursos.dao;

import org.springframework.data.repository.CrudRepository;

import com.ojeda.app.cursos.models.Categoria;
import com.ojeda.app.cursos.models.Curso;

public interface ICursosDao  extends CrudRepository<Curso, Long>{

}
