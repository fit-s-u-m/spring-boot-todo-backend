package com.fitsum.todo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitsum.todo.Model.Todo;
import com.fitsum.todo.Service.TodoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * TodoController
 */
@RestController
@RequestMapping(path = "todos")
public class TodoController {
	@Autowired
	private TodoService service;

	@GetMapping("/{todoId}")
	public Mono<Todo> getTodo(@PathVariable long todoId) {
		return service.getById(todoId);
	}

	@PutMapping("/{todoId}")
	public Mono<Todo> updateTodo(@PathVariable long todoId, @RequestBody Todo newTodo) {
		return service.updateTodo(todoId, newTodo);
	}

	@DeleteMapping("/{todoId}")
	public Mono<Void> deleteTodo(@PathVariable long todoId) {
		return service.delete(todoId);
	}

	@GetMapping("/search/{search}")
	public Flux<Todo> searchTodos(@PathVariable String search) {
		return service.searchByName(search);
	}

	@PostMapping("/")
	public Mono<Todo> addTodo(@RequestBody Todo todo) {
		return service.addTodo(todo).log();
	}

	@GetMapping("/")
	public Flux<Todo> getTodos() {
		return service.getAll();
	}
}
