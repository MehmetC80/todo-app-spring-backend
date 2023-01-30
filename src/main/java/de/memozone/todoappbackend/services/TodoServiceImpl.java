package de.memozone.todoappbackend.services;

import de.memozone.todoappbackend.entity.TodoEntity;
import de.memozone.todoappbackend.model.TodoModel;
import de.memozone.todoappbackend.repository.TodoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService {


    @Autowired
    private TodoRepository todoRepository;

    @Override
    public void saveTodo(TodoModel todo) {

        TodoEntity todoEntity = new TodoEntity();
        BeanUtils.copyProperties(todo, todoEntity);

        todoRepository.save(todoEntity);


    }

    @Override
    public List<TodoModel> getAllTodos() {

        List<TodoEntity> todoEntitieList = todoRepository.findAll();

        List<TodoModel> todo = todoEntitieList.stream().map(todoEntity -> new TodoModel(
                todoEntity.getId(),
                todoEntity.getText(),
                todoEntity.getDay(),
                todoEntity.getReminder()
        )).collect(Collectors.toList());

        return todo;
    }

    @Override
    public TodoModel getTodoById(Long id) {

        TodoEntity todoEntity = todoRepository.findById(id).get();

        TodoModel todo = new TodoModel();
        BeanUtils.copyProperties(todoEntity, todo);
        return todo;
    }

    @Override
    public boolean deleteTodo(Long id) {

        TodoEntity todoEntity = todoRepository.findById(id).get();
        todoRepository.delete(todoEntity);
        return true;
    }

    @Override
    public TodoModel updateTodo(Long id, TodoModel todo) {

        TodoEntity todoEntity=todoRepository.findById(id).get();

        todoEntity.setText(todo.getText());
        todoEntity.setDay(todo.getDay());
        todoEntity.setReminder(todo.getReminder());

        todoRepository.save(todoEntity);

        TodoModel todoModel=new TodoModel();
        BeanUtils.copyProperties(todoEntity,todoModel);
        return todoModel;
    }
}

