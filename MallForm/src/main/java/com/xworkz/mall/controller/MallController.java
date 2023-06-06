package com.xworkz.mall.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.mall.dto.MallDTO;

@Component
@RequestMapping
public class MallController {
	
	private Collection<MallDTO> mallDtos = new ArrayList<>();
	
	public MallController() {
		System.out.println("Running MallController no-arg const..");
	}
	@RequestMapping("/send")
	public String onSubmit(Model m, @Valid MallDTO dto, BindingResult b) {
		if (b.hasErrors()) {
			m.addAttribute("errors", b.getFieldErrors());
			List<FieldError> errors = b.getFieldErrors();
		    for (FieldError error : errors) {
		        System.out.println("Error in field: " + error.getField());
		        System.out.println("Error message: " + error.getDefaultMessage());
		    }
			return "Welcome.jsp";
		}
		
		System.out.println("Running onSubmit method: "+dto);
		this.mallDtos.add(dto);
		
		for (MallDTO mallDTO : mallDtos) {
		System.out.println("Saved Successfully: "+mallDTO);	
		}
		
		m.addAttribute("msg","Thank you for visiting "+dto.getName());
		return "Welcome.jsp";
	}
	@RequestMapping("/view")
	public String onView(Model model) {
		
		model.addAttribute("list", this.mallDtos);
		return "view.jsp";
	}
	
	

}
