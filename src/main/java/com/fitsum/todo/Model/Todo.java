package com.fitsum.todo.Model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "todo_list")
public class Todo {

	@Id
	private long id;

	private String name;
	private String description;

	private String deadline;
	private String created_time;
	private boolean is_done;

	public Todo(String name, String description, String deadline, boolean is_done) {
		this.name = name;
		this.deadline = deadline;
		this.created_time = new Date().toString();
		this.is_done = is_done;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public String getCreated_time() {
		return created_time;
	}

	// description
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// completed
	public boolean is_done() {
		return is_done;
	}

	public boolean setDone(boolean isDone) {
		this.is_done = isDone;
		return is_done;
	}

	// name
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(long id) {
		this.id = id;
	}

	// deadline
	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

}
