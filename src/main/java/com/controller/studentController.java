package com.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.StudentDao.StudentDao;
import com.beans.Student;

@Controller
public class studentController {

	@Autowired
	StudentDao dao;
	
	
	@RequestMapping("/studentform")
	public String showform (Model m)
	{
		m.addAttribute("command",new Student());
		return "studentform";
	}
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String save(@ModelAttribute("std") Student std){ 
		System.out.println("Record is saved Successfully...!");
        dao.save(std);    
        return "redirect:/viewstudent";//will redirect to viewstudent request mapping    
    }    
	@RequestMapping("/viewstudent")    
    public String viewstudent(Model m){    
        List<Student> list=dao.getStudents();    
        m.addAttribute("list",list);
        return "viewstudent";    
    }
	@RequestMapping(value="/editstudent/{id}")    
    public String edit(@PathVariable int id, Model m){    
        Student std=dao.getStudentById(id);    
        m.addAttribute("command",std);  
        return "studenteditform";    
    }    
    /* It updates model object. */    
	@RequestMapping(value="/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("std") Student std){    
		System.out.println("Record is updated and saved");
        dao.editsave(std);    
        return "redirect:/viewstudent";    
    }    
	@RequestMapping(value="/deletestudent/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){
		System.out.println("Record is deleted...!");
        dao.delete(id);    
        return "redirect:/viewstudent";    
    }     

	
}
