package com.fitsum.todo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitsum.todo.Model.Todo;
import com.fitsum.todo.Model.TodoRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * TodoService
 */
@Service
public class TodoService {
	@Autowired
	private TodoRepo todoRepo;

	public final List<Todo> todos = new ArrayList<>();

	public Mono<Todo> getById(long id) {
		return todoRepo.findById(id);
	}

	public Mono<Todo> getByName(String name) {
		return todoRepo.findByName(name);
	}

	public Mono<Todo> addTodo(Todo todo) {
		return todoRepo.save(todo);
	}

	public Mono<Todo> updateTodo(long id, Todo newTodo) {
		return todoRepo.findById(id)
				.flatMap(existingTodo -> {
					// Update the properties of the existing todo with the new values
					existingTodo.setName(newTodo.getName());
					existingTodo.setDescription(newTodo.getDescription());
					existingTodo.setDeadline(newTodo.getDeadline());
					existingTodo.setDone(newTodo.is_done());
					return todoRepo.save(existingTodo); // Save the updated todo
				});
	}

	public Flux<Todo> searchByName(String name) {
		return todoRepo.findByNameContainingIgnoreCase(name);
	}

	public Flux<Todo> getAll() {
		return todoRepo.findAll();
	}

	public Mono<Void> delete(long id) {
		return todoRepo.findById(id)
				.flatMap((Todo existingTodo) -> todoRepo.delete(existingTodo));
	}

}
