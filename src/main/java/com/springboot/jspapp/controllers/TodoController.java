package com.springboot.jspapp.controllers;

import com.springboot.jspapp.model.Todo;
import com.springboot.jspapp.services.TodoService;
import com.springboot.jspapp.utils.Utilities;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@SessionAttributes("name")
@Slf4j
public class TodoController {

    @Autowired
    private TodoService service;
    @Autowired
    private Utilities utilities;
    @Autowired
    private SimpleDateFormat dateFormat;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String showTodos(ModelMap model) {
        String name = utilities.getLoggedInUserName(model);
        model.put("todos", service.retrieveTodos(name));
        model.put("name", name);
        return "list-todos";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showAddTodoPage(ModelMap model) {
        model.addAttribute(new Todo(0, utilities.getLoggedInUserName(model), "A new TODO", new Date()));
        return "todo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        log.info("1");
        if (result.hasErrors()) {
            result.getFieldErrors().forEach(System.out::println);
            log.info("66");
            return "todo";
        }
        log.info("2");
        service.addTodo(utilities.getLoggedInUserName(model), todo.getDesc(), todo.getTargetDate());
        log.info("3");
        return "redirect:/list-todos";
    }

    @RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id) {
        service.deleteTodo(id);
        return "redirect:/list-todos";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        Todo todo = service.retrieveTodo(id);
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        todo.setUser(utilities.getLoggedInUserName(model));
        service.updateTodo(todo);
        return "redirect:/list-todos";
    }

}
