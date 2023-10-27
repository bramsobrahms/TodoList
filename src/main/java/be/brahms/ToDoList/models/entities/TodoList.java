package be.brahms.ToDoList.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TodoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 150)
    private String name;
    private boolean done;

}

