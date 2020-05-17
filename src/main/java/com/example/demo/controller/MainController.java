package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.EstudianteDAO;
import com.example.demo.domain.Estudiante;
@Controller
public class MainController {
	@Autowired
	private EstudianteDAO estudianteDAO;
	
	@RequestMapping("/inicio")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("estudiante",new Estudiante());
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/listado")
	public ModelAndView listado(){
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		try{
			estudiantes = estudianteDAO.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("listado");
		return mav;
	}
	
	@RequestMapping("/listado2")
	public ModelAndView insertEstudiante(@Valid @ModelAttribute Estudiante student, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		if(result.hasErrors() == false) {
			mav.addObject("estudiante", new Estudiante());
			try {
				estudianteDAO.insert(student);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return mav;
	}
}

