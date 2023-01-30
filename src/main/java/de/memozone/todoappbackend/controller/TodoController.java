package de.memozone.todoappbackend.controller;


import de.memozone.todoappbackend.model.TodoModel;
import de.memozone.todoappbackend.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class TodoController {


    @Autowired
    private TodoService todoService;


    @PostMapping("/todos")
    public ResponseEntity<TodoModel> saveUser(@RequestBody TodoModel todo) {
        todoService.saveTodo(todo);
        return ResponseEntity.ok(todo);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<TodoModel>> getAllTodos() {

        List<TodoModel> todo = todoService.getAllTodos();
        return ResponseEntity.ok(todo);

    }


    @GetMapping("/todos/{id}")
    public ResponseEntity<TodoModel> getSingleTodo(@PathVariable("id") Long id) {

        TodoModel todo = null;
        todo = todoService.getTodoById(id);
        return ResponseEntity.ok(todo);

    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteTodo(@PathVariable("id") Long id){

        boolean deleted=false;
        deleted=todoService.deleteTodo(id);

        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted",deleted);

        return ResponseEntity.ok(response);
    }


@PutMapping("/todos/{id}")
    public ResponseEntity<TodoModel> updateTodo(@PathVariable("id") Long id,@RequestBody TodoModel todo){

        todo=todoService.updateTodo(id,todo);

        return ResponseEntity.ok(todo);

}

}
