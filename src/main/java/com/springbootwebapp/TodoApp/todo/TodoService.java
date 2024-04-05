package com.springbootwebapp.TodoApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {

	private static List<Todo> todos=new ArrayList<>();
	private static int CountTodo = 0;

	static {
		todos.add(new Todo(++CountTodo, "Fazil", "Learn Java full stack-1", LocalDate.now().plusYears(1), false));
	}

	public List<Todo> findByUsername(String userName) {
		Predicate<? super Todo>
			predicate = todo-> todo.getUserName().equalsIgnoreCase(userName);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String userName, String description, LocalDate targetDate, boolean done ) {
		Todo todo = new Todo(++CountTodo,userName,description,targetDate,done);
		todos.add(todo);
	}
	public void DeleteById(int id) {
		
		Predicate<? super Todo> predicate = todo-> todo.getId()==id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo-> todo.getId()==id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void SaveTodo(@Valid Todo todo) {
		DeleteById(todo.getId());
		todos.add(todo);	
	}

	
}
