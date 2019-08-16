package main.java;


import java.util.ArrayList;
import java.util.Iterator;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class DukeConsole {
    private final String MESSAGE_BARRIER = "    ____________________________________________________________";
    private final String MESSAGE_SPACING = "     ";
    private final String LOGO = " ____        _        \n"
                              + "|  _ \\ _   _| | _____ \n"
                              + "| | | | | | | |/ / _ \\\n"
                              + "| |_| | |_| |   <  __/\n"
                              + "|____/ \\__,_|_|\\_\\___|\n";

    private BufferedReader bufferedreader;

    public DukeConsole() {
        bufferedreader = new BufferedReader(new InputStreamReader(System.in));
    }

    /*
    Message printing methods
    */
    public void dukeMessage(String message) {
        System.out.println(MESSAGE_BARRIER);
        System.out.println(MESSAGE_SPACING + message);
        System.out.println(MESSAGE_BARRIER);
    }

    public void dukeMessage(ArrayList<String> messages) {
        System.out.println(MESSAGE_BARRIER);
        Iterator<String> message = messages.iterator();
        while (message.hasNext()) {
            System.out.println(MESSAGE_SPACING + message.next());
        }
        System.out.println(MESSAGE_BARRIER);
    }

    public void dukeMessage(String ... messages) {
        System.out.println(MESSAGE_BARRIER);
        for (String message : messages) {
            System.out.println(MESSAGE_SPACING + message);
        }
        System.out.println(MESSAGE_BARRIER);
    }

    /*
    System input methods
    */
    public String readUserInputLine() {
        String input_line = null;
        try {
            input_line = bufferedreader.readLine();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return input_line;
    }

    public void welcomeMessage() {
        System.out.println(LOGO);
        this.dukeMessage("Hello! I'm Duke","What can I do for you?");
    }
}