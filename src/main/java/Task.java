package main.java;

public class Task {
    private String text;
    private boolean done;

    public Task() {
        this.text = "";
        this.done = false;
    }

    public Task(String input_text) {
        this.text = input_text;
        this.done = false;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String toString() {
        String output_string = "[" + (this.done ? "\u2713" : "\u2718") + "] " + this.text;
        return output_string;
    }
}
