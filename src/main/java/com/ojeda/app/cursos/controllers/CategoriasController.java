package com.ojeda.app.cursos.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.ojeda.app.cursos.models.Categoria;
import com.ojeda.app.cursos.services.CategoriasService;
import com.ojeda.app.cursos.services.IService;


@Controller
@RequestMapping("/categorias")
public class CategoriasController {
	@Autowired
	private IService<Categoria> categoriasService;
	
	@GetMapping(value = "/listar")
	public String listar(Model model) throws InterruptedException {
		//Thread.sleep(6000);
		List<Categoria> categorias = categoriasService.getAll();
		//a traves del objeto model, le pasamos la lista de
			//categorias a la vista
		model.addAttribute("categorias", categorias);
		return "Categorias/index";
	}
	
	public int suma(int a, int b) {
		return a;
	}
	
	/* api para devolver la lista de categorias */
	@GetMapping(value="/api/listadoCategorias", 
			produces = { "application/json" })	
	public @ResponseBody Map<String, List<Categoria>> apiListar() 
			throws InterruptedException{
		//Thread.sleep(6000);
		//float dv = 4 / (4-4);
		Map<String, List<Categoria>> map = 
				new HashMap<String, List<Categoria>>();
		map.put("data", categoriasService.getAll());
		return map;
	}
	
	@DeleteMapping(value = "/api/delete/{id123}", 
			produces = { "application/json" })
	public @ResponseBody Map<String, String> apiDelete(
			@PathVariable(value = "id123") 
			Long id, Model model
			) {
		categoriasService.delete(id);
		
		Map<String, String> resultados = 
				new HashMap<String, String>();
		
		resultados.put("success", "true");
		resultados.put("message", 
				"Categoría borrada correctamente");
		return resultados;
	}
	
	@GetMapping(value = "/create")
	public String create(Model model) {
		//creamos el objeto con el que vamos a trabajar 
		//en la vista
		Categoria categoria = new Categoria();
		
		//pasamos el objeto categoria a la vista
		model.addAttribute("categoria", categoria);		
		
		return "Categorias/create";
	}
	
	@PostMapping(value="/insert")
	public String insert(@Valid @ModelAttribute("categoria") 
		Categoria categoria, 
			BindingResult result ) {
		if(result.hasErrors()) {
			return "Categorias/create";
		}
		if(  (categoria.getId() == null) ) {
			categoria.setNumeroCursos(0);
		}
		else {
			categoria.setNumeroCursos(categoriasService
					.getById(categoria.getId()).getNumeroCursos());
		}
		categoriasService.save(categoria);
		return "redirect:/categorias/listar";
	}
	@GetMapping(value = "/edit/{id}")
	public String edit(@PathVariable(value = "id") Long id, 
			Model model)
	{
		Categoria categoria = null;
		if (id > 0) {
			//recuperamos el objeto categoria que queremos 
			//editar
			categoria = categoriasService.getById(id);
			if (categoria == null) {
				return "redirect:/categorias/listarAsync";
			}
		} 
		else {
			return "redirect:/categorias/listar";
		}
		//le pasamos el objeto categoria a la vista
		model.addAttribute("categoria", categoria);
		return "Categorias/create";
	}
}
