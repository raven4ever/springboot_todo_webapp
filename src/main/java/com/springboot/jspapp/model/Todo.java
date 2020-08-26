package com.springboot.jspapp.model;

import lombok.Data;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class Todo {

    private int id;
    private String user;
    @Size(min = 10, message = "Enter at least 10 Characters!")
    private String desc;
    @FutureOrPresent(message = "Date must be in the future!")
    private Date targetDate;
    private boolean isDone = false;

    public Todo(int id, String user, String desc, Date targetDate) {
        this.id = id;
        this.user = user;
        this.desc = desc;
        this.targetDate = targetDate;
    }
}

