package com.ojeda.app.cursos.dao;

import org.springframework.data.repository.CrudRepository;

import com.ojeda.app.cursos.models.Instructor;

public interface IInstructoresDao  extends CrudRepository<Instructor, Long>{

}
