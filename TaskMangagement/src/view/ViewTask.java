/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MangementTask;
import controller.Validation;
import java.util.Date;
import model.Task;

/**
 *
 * @author admin
 */
public class ViewTask {

    MangementTask mangementTask = new MangementTask();

    void addTask() {
        //enter attribute
        //enter name
        String requirement = Validation.getInputString("Requirement Name: ");
        //enter task type
        int taskType = Validation.getInputInteger("Task Type: ", "You must be enter the digits", 1, 4);
        //enter date
        Date date = Validation.getDate("Date: ");
        //enter from
        String from = Validation.getStringPlan("From: ", "^\\d{1,2}\\.[0|5]$", 8.0, 17.0);
        double converFrom = Double.parseDouble(from);
        //enter to
        String to = Validation.getStringPlan("To: ", "^\\d{1,2}\\.[0|5]$", converFrom + 0.5, 17.5);
        double converTo = Double.parseDouble(to);
        //enetr assignee
        String assignee = Validation.getInputString("Assignee: ");
        //enter reviewer
        String reviewer = Validation.getInputString("Reviewer: ");
        //check duplicate time 
        if (!mangementTask.checkDuplicateTime(requirement, date, converFrom, converTo)) {
            System.out.println("DUPLICATE TIME!!!!!");
            return;
        } else {
            //create task
            Task task = new Task(requirement, taskType, date, from, to, assignee, reviewer);
            //add to list task
            mangementTask.getTaskList().add(task);
        }

    }

    void displayTask() {
        System.out.println("----------------------------------------- Task -------------------------------------------------------");
        System.out.printf("%-10s%-20s%-18s%-15s%-15s%-15s%-10s\n", "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        for (Task task : mangementTask.getTaskList()) {
            task.display();
        }
    }

    void deleteTask() {
        int id = Validation.getInputInteger("ID: ", "You must be enter digits", 1, Integer.MAX_VALUE);
        if (mangementTask.checkExitsID(id)) {
            Task taskDelete = mangementTask.getTaskByID(id);
            mangementTask.getTaskList().remove(taskDelete);
            System.out.println("DELETE SUCESSFULL!!!");
        } else {
            System.out.println("ID NOT EXITS!!!!");
            return;
        }
    }

}
