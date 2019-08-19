package main.java;

import java.util.ArrayList;

public class DukeLogic {

    private DukeConsole console;
    private ArrayList<Task> tasklist;

    public DukeLogic() {
        console = new DukeConsole();
        tasklist = new ArrayList<Task>();
    }

    public void addTask(String task_string) {
        Task new_task = new Task(task_string);
        tasklist.add(new_task);
    }

    public void markTaskAsDone(String index_string) {
        int index = -1;
        try {
            index = Integer.parseInt(index_string) - 1;
            if (index < 0 || index > tasklist.size()) {
                console.dukeMessage("Error! Please provide a proper index");
            }
            else {
                Task task = tasklist.get(index);
                task.setDone(true);
                console.dukeMessage("Nice! I've marked this task as done:", task.toString());
            }
        }
        catch (NumberFormatException | NullPointerException nfe) {
            console.dukeMessage("Error! Please provide a proper index");
        }
    }

    public void listTasks() {
        ArrayList<String> task_tostrings = new ArrayList<String>();
        for (Task task: tasklist) {
            task_tostrings.add(task.toString());
        }
        console.dukeMessage(task_tostrings);          //w00t
    }

    public boolean processInput(String input_string) {
        boolean result = true;
        String split_input[] = input_string.split(" ", 2);
        if (split_input.length == 0) {
            console.dukeMessage("Error! Empty string");
            return false;
        }
        String first_token = split_input[0];

        switch (first_token) {
            case "bye":
                console.dukeMessage("Bye. Hope to see you again soon!");
                result = false;
                break;
            case "list":
                listTasks();
                break;
            case "done":
                if (split_input.length <= 1) {
                    console.dukeMessage("Error! Task to be marked not specified");
                }
                else {
                    markTaskAsDone(split_input[1]);
                }
                break;
            default:
                addTask(input_string);
                console.dukeMessage("added: " + input_string);
        }

        return result;
    }

    public void runLogic() {
        boolean res = true;
        console = new DukeConsole();
        console.welcomeMessage();

        while (res) {
            String user_input = console.readUserInputLine();
            res = processInput(user_input);
        }
    }
}