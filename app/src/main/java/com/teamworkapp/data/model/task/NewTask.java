package com.teamworkapp.data.model.task;

import com.google.gson.annotations.SerializedName;

/**
 * @author Tosin Onikute.
 */

public class NewTask {

    @SerializedName("todo-item")
    private AddTask todoItems = null;

    public NewTask(AddTask todoItems){
        this.todoItems = todoItems;
    }

}
