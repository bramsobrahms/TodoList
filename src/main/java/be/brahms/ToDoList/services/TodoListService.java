package be.brahms.ToDoList.services;

import be.brahms.ToDoList.models.entities.TodoList;

import java.util.List;

public interface TodoListService {
    void create(TodoList todolist);
    List<TodoList> findAll();
    TodoList findById(Long id);
    void update(Long id, TodoList todoList);

    void goTrueTodo(Long id);
    void goFalseTodo(Long id);
    void delete(Long id);

    void deleteByDoneTrue();
}
