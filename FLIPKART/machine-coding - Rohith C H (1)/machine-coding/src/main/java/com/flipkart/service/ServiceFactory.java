package com.flipkart.service;

public class ServiceFactory {

    private static TaskManager taskManager;
    private static UserService userService;

    public static TaskManager getTaskManagerService(){
        if(taskManager == null){
            taskManager = new TaskManager();
        }

        return taskManager;
    }

    public static UserService getUserService(){
        if(userService == null){
            userService = new UserService();
        }

        return userService;
    }
}
