package de.memozone.todoappbackend.services;

import de.memozone.todoappbackend.model.TodoModel;
import de.memozone.todoappbackend.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface TodoService {


    void saveTodo(TodoModel todo);

    List<TodoModel> getAllTodos();

    TodoModel getTodoById(Long id);

    boolean deleteTodo(Long id);

    TodoModel updateTodo(Long id, TodoModel todo);
}
