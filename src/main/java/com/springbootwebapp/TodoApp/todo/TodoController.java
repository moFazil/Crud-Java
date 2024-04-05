package com.springbootwebapp.TodoApp.todo;

import java.time.LocalDate;
import java.util.List;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class TodoController {
	private TodoService todoService;

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping("TodoLists")
	public String ListAllTodos(ModelMap model) {
		String userName = getLoggedInUsername(model);
		List<Todo> todos = todoService.findByUsername(userName);
		model.addAttribute("todosList", todos);

		return "todosList";
	}
	
	@RequestMapping(value="addTodo", method= RequestMethod.GET)
	public String showAddTodos(ModelMap model) {
		String userName = getLoggedInUsername(model);
		Todo todo = new Todo(0,userName,"",LocalDate.now().plusYears(1),false);
		model.put("todo", todo);
		return "addtodo";
	}
	
	@RequestMapping(value="addTodo", method= RequestMethod.POST)
	public String AddTodo(ModelMap model,@Valid Todo todo ,BindingResult result) {
		
		if(result.hasErrors()) {
			return "addtodo";
		}
		String userName = getLoggedInUsername(model);
		todoService.addTodo(userName, todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:TodoLists";
	}
	
	@RequestMapping("DeleteTodo")
	public String DeleteTodo(@RequestParam int id) {
		todoService.DeleteById(id);
		return "redirect:TodoLists";
	}
	
	@RequestMapping(value="UpdateTodo",method=RequestMethod.GET)
	public String UpdateTodo(@RequestParam int id,ModelMap model) {
		Todo todo = todoService.findById(id);
		model.addAttribute("todo", todo);
		return "addtodo";
	}
	
	@RequestMapping(value="UpdateTodo", method= RequestMethod.POST)
	public String SaveTodo(ModelMap model,@Valid Todo todo ,BindingResult result) {
		
		if(result.hasErrors()) {
			return "addtodo";
		}
		String userName = getLoggedInUsername(model);
		todo.setUserName(userName);
		todoService.SaveTodo(todo);
		return "redirect:TodoLists";
	}
	
	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
				return authentication.getName();
	}

}
