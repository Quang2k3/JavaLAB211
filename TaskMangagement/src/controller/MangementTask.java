/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Date;
import model.Task;

/**
 *
 * @author admin
 */
public class MangementTask {

    private ArrayList<Task> taskList;

    public MangementTask() {
        taskList = new ArrayList<>();
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public boolean checkDuplicateTime(String requirement, Date date, double converFrom, double converTo) {
        for (Task task : taskList) {
            if (task.getRequirementName().equalsIgnoreCase(requirement) && task.getDate().equals(date)) {
                double from = Double.parseDouble(task.getPlanFrom());
                double to = Double.parseDouble(task.getPlanTo());
                //check duplicate
                if (converFrom == from) {
                    return false;
                } else if (converFrom > from && converFrom < to) {
                    return false;
                } else if (to > converFrom && to < converTo) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkExitsID(int id) {
        for (Task task : taskList) {
            if (task.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public Task getTaskByID(int id) {
        Task taskDelete = new Task();
        for (Task task : taskList) {
            if (task.getId() == id) {
                taskDelete = task;
            }
        }
        return taskDelete;
    }
}
