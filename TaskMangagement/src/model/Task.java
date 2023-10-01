/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author admin
 */
public class Task {

    private static int auto_crem = 1;
    private int id;
    private String requirementName;
    private int taskType;
    private Date date;
    private String planFrom;
    private String planTo;
    private String assignee;
    private String reviewer;

    public Task() {
    }

    public Task(String requirementName, int taskType, Date date, String planFrom, String planTo, String assignee, String reviewer) {
        this.id = auto_crem;
        auto_crem++;
        this.requirementName = requirementName;
        this.taskType = taskType;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public static int getAuto_crem() {
        return auto_crem;
    }

    public static void setAuto_crem(int auto_crem) {
        Task.auto_crem = auto_crem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public int getTaskType() {
        return taskType;
    }

    public void setTaskType(int taskType) {
        this.taskType = taskType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(String planFrom) {
        this.planFrom = planFrom;
    }

    public String getPlanTo() {
        return planTo;
    }

    public void setPlanTo(String planTo) {
        this.planTo = planTo;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    private double converPlane(String plane) {
        double converPlan = Double.parseDouble(plane);
        return converPlan;
    }

    private String converTaskType(int taskType) {
        switch (taskType) {
            case 1:
                return "Code";
            case 2:
                return "Test";
            case 3:
                return "Design";
            default:
                return "Review";
        }
    }

    public void display() {
        System.out.printf("%-10s%-20s%-18s%-15s%-15s%-15s%-10s\n", id, requirementName, converTaskType(taskType),
                new SimpleDateFormat("dd-MM-yyyy").format(date),
                (converPlane(planTo) - converPlane(planFrom)), assignee, reviewer);
    }
}
