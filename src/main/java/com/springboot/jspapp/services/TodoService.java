package com.springboot.jspapp.services;

import com.springboot.jspapp.model.Todo;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;


@Service
public class TodoService {
    private final Set<Todo> todos = new TreeSet<>();
    private int todoCount = 3;

    @PostConstruct
    public void init() {
        todos.add(new Todo(1, "adrian", "Learn Spring", new Date(LocalDate.ofInstant(LocalDate.now()., ZoneId.systemDefault()))));
        todos.add(new Todo(2, "adrian", "Learn To Sleep", new Date(2020, 8, 5)));
        todos.add(new Todo(3, "adrian", "Learn Hibernate", new Date(2020, 9, 5)));
        todos.add(new Todo(3, "gigel", "Learn Hibernate", new Date(2021, 1, 5)));
    }

    public Set<Todo> retrieveTodos(String user) {
        return todos.stream().filter(todo -> todo.getUser().equals(user)).collect(Collectors.toSet());
    }

    public void addTodo(String name, String desc, Date targetDate) {
        todos.add(new Todo(++todoCount, name, desc, targetDate));
    }

    public void deleteTodo(int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }

    public Todo retrieveTodo(int id) {
        return todos.stream().filter(todo -> todo.getId() == id).findFirst().orElse(null);
    }

    public void updateTodo(Todo todo) {
        todos.remove(todo);
        todos.add(todo);
    }
}

