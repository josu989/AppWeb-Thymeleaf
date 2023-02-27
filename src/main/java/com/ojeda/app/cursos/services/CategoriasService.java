package com.ojeda.app.cursos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ojeda.app.cursos.dao.ICategoriasDao;
import com.ojeda.app.cursos.models.Categoria;


@Component
public class CategoriasService implements IService<Categoria>{
	@Autowired
	private ICategoriasDao categoriasDao;
	
	@Override
	public List<Categoria> getAll() {
		// TODO Auto-generated method stub
		return (List<Categoria>) categoriasDao.findAll();
	}

	@Override
	public void save(Categoria categoria) {
		// TODO Auto-generated method stub
		categoriasDao.save(categoria);
	}

	@Override
	public Categoria getById(Long id) {
		// TODO Auto-generated method stub
		return categoriasDao.findById(id).orElse(null);
	}
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		categoriasDao.deleteById(id);
	}
	
}
