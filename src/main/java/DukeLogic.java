package main.java;

public class DukeLogic {

    private DukeConsole console;

    public boolean processInput(String input_string) {
        if (input_string.equals("bye")) {
            console.dukeMessage("Bye. Hope to see you again soon!");
            return false;
        }
        else {
            console.dukeMessage(input_string);
            return true;
        }
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