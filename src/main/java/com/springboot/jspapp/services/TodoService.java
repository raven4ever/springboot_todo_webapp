package com.springboot.jspapp.services;

import com.springboot.jspapp.model.Todo;
import com.springboot.jspapp.utils.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;


@Service
public class TodoService {

    private final Set<Todo> todos = new TreeSet<>();
    @Autowired
    private Utilities utilities;
    private int todoCount = 3;

    @PostConstruct
    public void init() {
        todos.add(new Todo(1, "adrian", "Learn Spring", utilities.getDateOf(2020, 9, 8)));
        todos.add(new Todo(2, "adrian", "Learn To Sleep", utilities.getDateOf(2021, 11, 5)));
        todos.add(new Todo(3, "adrian", "Learn Hibernate", utilities.getDateOf(2020, 1, 8)));
        todos.add(new Todo(3, "gigel", "Learn Hibernate", utilities.getDateOf(2020, 9, 8)));
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

