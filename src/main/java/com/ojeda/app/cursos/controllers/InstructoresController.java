package com.ojeda.app.cursos.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ojeda.app.cursos.models.Instructor;
import com.ojeda.app.cursos.services.IService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/instructores")
public class InstructoresController {
	@Autowired
	private IService<Instructor> instructoresService;
	
	@GetMapping(value = "/create")
	public String create(Model model) {
		Instructor instructor = new Instructor();
	
		model.addAttribute("instructor", instructor);
		//obtenemos la lista de direcciones para pasarsela a la vista
		
		return "Instructores/create";
	}
	
	@PostMapping(value = "/insert")
	public String insert(@Valid @ModelAttribute("instructor")
			Instructor instructor,
			BindingResult result,
			@RequestParam("image") MultipartFile file) throws IOException {
			
		if(result.hasErrors()) {
			return "Instructores/create";
		}
		if( (instructor.getId() == null) ) {
			instructor.setHoras(0D);
		}
		else {
			instructor.setHoras(instructoresService
					.getById(instructor.getId()).getHoras());
		}
		//codigo para recuperar la imagen del isntructor
		StringBuilder fileNames = new StringBuilder();
Path fileNameAndPath = Paths.get(System.getProperty("user.dir")
		+ "/src/main/resources/static/uploads", file.getOriginalFilename());
fileNames.append(file.getOriginalFilename()); //CU.jpg
String extension = file.getOriginalFilename()
		.substring(file.getOriginalFilename().lastIndexOf(".") + 1);
if( (!extension.toLowerCase().equals("png")) &&
		(!extension.toLowerCase().equals("jpg")) &&
		(!extension.toLowerCase().equals("jpeg")) ) {
	FieldError error = new FieldError("instructor",
					"urlFoto",
					"El archivo debe de ser una imagen valida " + extension);
			result.addError(error);
			return "Instructores/create";
}
Files.write(fileNameAndPath, file.getBytes());
instructor.setUrlFoto(fileNames.toString());
		////////////////////////////////////////////
		
		instructoresService.save(instructor);
		return "redirect:/instructores/listar";
		
	}
	
	@GetMapping(value = "/listar")
	public String listar(Model model) {
		return "Instructores/index";
	}
	
	
	/*devolver la lista de instructores*/
	@GetMapping(value = "/api/listadoInstructores",
			produces = { "application/json" })
	public @ResponseBody Map<String, List<Instructor>>
		apiListar(Model model)
	{
		// Thread.sleep(1500);
		Map<String, List<Instructor>> map =
				new HashMap<String, List<Instructor>>();
		map.put("data", instructoresService.getAll());
		return map;
	}
	
	@GetMapping(value = "/edit/{id}")
	public String edit(@PathVariable(value = "id") Long id, Model model) throws InterruptedException {
		//Thread.sleep(5000);
		
		Instructor instructor = null;
		if (id > 0) {
			instructor = instructoresService.getById(id);
			if (instructor == null) {
				return "redirect:/instructores/listar";
			}
		}
		else {
			return "redirect:/instructores/listar";
		}
		model.addAttribute("instructor", instructor);
		
		return "Instructores/create";
	}
	
	@DeleteMapping(value = "/api/delete/{id}", produces = { "application/json" })
	public @ResponseBody Map<String, String> apiDelete(@PathVariable(value = "id") Long id, Model model) {
		instructoresService.delete(id);
		Map<String, String> resultados = new HashMap<String, String>();
		resultados.put("success", "true");
		resultados.put("message", "Instructor eliminado correctamente");
		return resultados;
	}
}



