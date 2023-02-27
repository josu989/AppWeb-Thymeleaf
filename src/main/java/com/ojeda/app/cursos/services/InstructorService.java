package com.ojeda.app.cursos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojeda.app.cursos.dao.IInstructoresDao;
import com.ojeda.app.cursos.models.Instructor;

@Service
public class InstructorService implements IService<Instructor>{
	@Autowired
	private IInstructoresDao instructoresDao;
	@Override
	public List<Instructor> getAll() {
		// TODO Auto-generated method stub
		return (List<Instructor>)instructoresDao.findAll();
	}
	@Override
	public void save(Instructor instructor) {
		// TODO Auto-generated method stub
		instructoresDao.save(instructor);
	}
	@Override
	public Instructor getById(Long id) {
		// TODO Auto-generated method stub
		return instructoresDao.findById(id).orElse(null);
	}
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		instructoresDao.deleteById(id);
	}


}
