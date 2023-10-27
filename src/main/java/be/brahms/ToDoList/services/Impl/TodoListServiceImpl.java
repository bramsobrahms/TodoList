package be.brahms.ToDoList.services.Impl;

import be.brahms.ToDoList.models.entities.TodoList;
import be.brahms.ToDoList.repositories.TodoListRepository;
import be.brahms.ToDoList.services.TodoListService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListServiceImpl implements TodoListService {

    public final TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository){
        this.todoListRepository = todoListRepository;
    }
    @Override
    public void create(TodoList todolist) {
        todolist.setDone(false);
        todoListRepository.save(todolist);
    }

    @Override
    public List<TodoList> findAll() {
        return todoListRepository.findAll();
    }

    @Override
    public TodoList findById(Long id) {
        return todoListRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public void update(Long id, TodoList todoList){
        TodoList todoListUpdate = findById(id);
        todoListUpdate.setId(todoList.getId());
        todoListUpdate.setName(todoList.getName());
        todoListRepository.save(todoListUpdate);
    }

    @Override
    public void goTrueTodo(Long id){
        TodoList todoTrue = findById(id);
        todoTrue.setDone(true);
        todoListRepository.save(todoTrue);
    }

    @Override
    public void goFalseTodo(Long id){
        TodoList todoTrue = findById(id);
        todoTrue.setDone(false);
        todoListRepository.save(todoTrue);
    }

    @Override
    public void delete(Long id){
        todoListRepository.deleteById(id);
    }
}
