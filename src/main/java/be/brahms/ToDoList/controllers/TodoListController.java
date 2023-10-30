package be.brahms.ToDoList.controllers;

import be.brahms.ToDoList.models.entities.TodoList;
import be.brahms.ToDoList.services.Impl.TodoListServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/todolist")
public class TodoListController {

    private final TodoListServiceImpl todolistService;

    public TodoListController(TodoListServiceImpl todolistService){
        this.todolistService = todolistService;
    }


    @GetMapping
    public String getCreate(Model model){
        model.addAttribute("todolist", new TodoList());
        return "list/create";
    }

    @PostMapping
    public String postCreate(@ModelAttribute TodoList todolist){
        todolistService.create(todolist);
        return "redirect:/todolist/list";
    }

    @GetMapping("/list")
    public String findAll(Model model){
        List<TodoList> todoLists = todolistService.findAll();
        model.addAttribute("todoLists", todoLists);

        return "list/list";
    }

    @GetMapping("/update/{id}")
    public String getUpdate(@PathVariable Long id, Model model){
        TodoList todoListUpdate = todolistService.findById(id);
        model.addAttribute("id",id);
        model.addAttribute("todoListUpdate", todoListUpdate);
        return "list/list";
    }

    @PostMapping("/update/{id}")
    public String postUpdate(@ModelAttribute TodoList todoList, @PathVariable Long id){
        todolistService.update(id, todoList);
        return "redirect:/todolist/list";
    }

    @GetMapping("/goTrue/{id}")
    public String goTrue(@PathVariable Long id){
        todolistService.goTrueTodo(id);
        return "redirect:/todolist/list";
    }

    @GetMapping("/goFalse/{id}")
    public String goFalse(@PathVariable Long id){
        todolistService.goFalseTodo(id);
        return "redirect:/todolist/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        todolistService.delete(id);
        return "redirect:/todolist/list";
    }

    @GetMapping("/delete/allTrue")
    public String deleteAll(){
        todolistService.deleteByDoneTrue();
        return "redirect:/todolist/list";
    }


}
