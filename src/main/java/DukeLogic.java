package main.java;

import java.util.ArrayList;

public class DukeLogic {

    private DukeConsole console;
    private ArrayList<String> tasklist;

    public DukeLogic() {
        console = new DukeConsole();
        tasklist = new ArrayList<String>();
    }

    public void addTask(String task_string) {
        tasklist.add(task_string);
    }

    public void listTasks() {
        console.dukeMessage(tasklist);          //w00t
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
            default:
                addTask(input_string);
                console.dukeMessage("added: " + input_string);
        }

        return result;
    }

    public boolean runLogic() {
        boolean res = true;
        console = new DukeConsole();
        console.welcomeMessage();

        while (res) {
            String user_input = console.readUserInputLine();
            res = processInput(user_input);
        }
        return res;
    }
}