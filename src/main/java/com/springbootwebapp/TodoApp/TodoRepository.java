package com.springbootwebapp.TodoApp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootwebapp.TodoApp.todo.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
	public List<Todo> findByUserName(String userName);
}
