package com.springboot.jspapp.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.springboot.jspapp.model.Todo;
import org.springframework.stereotype.Service;


@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<Todo>();
    private static int todoCount = 3;

    static {
        todos.add(new Todo(1, "adrian", "Learn Spring", new Date(), false));
        todos.add(new Todo(2, "adrian", "Learn To Sleep", new Date(), false));
        todos.add(new Todo(3, "adrian", "Learn Hibernate", new Date(), false));
    }

    public List<Todo> retrieveTodos(String user) {
        return todos.stream().filter(todo -> todo.getUser().equals(user)).collect(Collectors.toList());
    }

    public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
        todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
    }

    public void deleteTodo(int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }
}
