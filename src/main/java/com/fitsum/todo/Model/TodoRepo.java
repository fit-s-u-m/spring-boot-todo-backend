package com.fitsum.todo.Model;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TodoRepo extends R2dbcRepository<Todo, Long> {
	Mono<Todo> findByName(String name);

	Flux<Todo> findByNameContainingIgnoreCase(String name);

	@Query("SELECT * FROM todo_list WHERE is_done = TRUE")
	Flux<Todo> findCompleted();
}
