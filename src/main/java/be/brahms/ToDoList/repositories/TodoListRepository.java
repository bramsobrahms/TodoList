package be.brahms.ToDoList.repositories;

import be.brahms.ToDoList.models.entities.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoListRepository extends JpaRepository<TodoList, Long> {
}
